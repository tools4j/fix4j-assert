package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.Handler;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.plumbing.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Helper class for delegating message types for various FIX versions to
 * type-safe onMessage methods.
 *
 * Copied and modified from QuickFix library
 */
public class MessageDispatcher implements Consumer<FixMessage> {
    private final static Logger LOGGER = LoggerFactory.getLogger(MatchingSession.class);
    private Map<MsgType, Invoker> invokers = new HashMap<>();

    public MessageDispatcher(final FixSpecification fixSpecification, final Handler messageHandler) {
        Class<?> handlerClass = messageHandler.getClass();
        for (Method method : handlerClass.getMethods()) {
            if (isHandlerMethod(method)) {
                method.setAccessible(true);
                final Invoker invoker = new Invoker(messageHandler, method);
                final String methodName = method.getName();
                final String handlerIsForMessageType = methodName.replaceFirst("^on", "");
                LOGGER.info("Registering handler for message type: " + handlerIsForMessageType);
                final MsgType msgType = fixSpecification.getMsgTypeByName(handlerIsForMessageType);
                if(msgType == null){
                    throw new RuntimeException("Could not find MsgType in fix dictionary for name:" + handlerIsForMessageType);
                }
                Invoker existingInvoker = invokers.get(msgType);
                if (existingInvoker != null) {
                    throw new RuntimeException("There already exists a message handler for type:" + msgType + " Existing handler:" + existingInvoker);
                }
                invokers.put(msgType, invoker);
            }
        }
    }

    private boolean isHandlerMethod(Method method) {
        int modifiers = method.getModifiers();
        Class<?>[] parameterTypes = method.getParameterTypes();
        return !Modifier.isPrivate(modifiers) && matchesConventionOrAnnotation(method)
                && parameterTypes.length == 1 && FixMessage.class.isAssignableFrom(parameterTypes[0]);
    }

    private boolean matchesConventionOrAnnotation(Method method) {
        return method.getName().startsWith("on");
    }

    private class Invoker {
        private final Object target;
        private final Method method;

        public Invoker(Object target, Method method) {
            this.target = target;
            this.method = method;
        }

        public void Invoke(final FixMessage message) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
            method.invoke(target, message);
        }
    }

    @Override
    public void accept(final FixMessage fixMessage) {
        Invoker invoker = invokers.get(fixMessage.getTypeOfMessage());
        if (invoker != null) {
            try {
                invoker.Invoke(fixMessage);
            } catch (InvocationTargetException ite) {
                try {
                    throw ite.getTargetException();
                }
                catch (Throwable t) {
                    propagate(t);
                }
            }
            catch (Exception e) {
                propagate(e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type:" + fixMessage.getTypeOfMessage() + ". Methods have been found for MsgTypes:" + invokers.keySet() + " be sure to implement a method matching signature 'public void on" + fixMessage.getTypeOfMessage().getName() + "(FixMessage message)'");
        }
    }

    private void propagate(Throwable e) {
        if (e instanceof RuntimeException) {
            throw (RuntimeException) e;
        } else if (e instanceof Error) {
            throw (Error)e;
        } else {
            throw new RuntimeException(e);
        }
    }
}
