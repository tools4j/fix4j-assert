/*******************************************************************************
 * Copyright (c) quickfixengine.org  All rights reserved. 
 * 
 * This file is part of the QuickFIX FIX Engine 
 * 
 * This file may be distributed under the terms of the quickfixengine.org 
 * license as defined by quickfixengine.org and appearing in the file 
 * LICENSE included in the packaging of this file. 
 * 
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING 
 * THE WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A 
 * PARTICULAR PURPOSE. 
 * 
 * See http://www.quickfixengine.org/LICENSE for licensing information. 
 * 
 * Contact ask@quickfixengine.org if any conditions of this licensing 
 * are not clear to you.
 ******************************************************************************/

package org.fix4j.test.integration.quickfix;

import org.fix4j.test.plumbing.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.Application;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionNotFound;
import quickfix.UnsupportedMessageType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QuickFixApplication implements Application {
    private final static Logger LOGGER = LoggerFactory.getLogger(QuickFixApplication.class);
    private final Map<SessionID, Consumer<Message>> consumers;

    public QuickFixApplication() {
        this.consumers = new ConcurrentHashMap<>();
    }

    @Override
    public void onCreate(SessionID sessionID) {
    }

    @Override
    public void onLogon(SessionID sessionID) {
    }

    @Override
    public void onLogout(SessionID sessionID) {
    }

    @Override
    public void toAdmin(quickfix.Message message, SessionID sessionID) {
    }

    @Override
    public void toApp(quickfix.Message message, SessionID sessionID) throws DoNotSend {
    }

    @Override
    public void fromAdmin(quickfix.Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        final Consumer<Message> consumer = getConsumerForSession(sessionID);
        if(consumer != null){
            consumer.accept(message);
        }
    }

    @Override
    public void fromApp(quickfix.Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        final Consumer<Message> consumer = getConsumerForSession(sessionID);
        if(consumer != null){
            consumer.accept(message);
        }
    }

    public Consumer<Message> getConsumerForSession(final SessionID sessionId){
        final Consumer<Message> consumer = consumers.get(sessionId);
        if(consumer == null){
            throw new IllegalStateException("Cannot find consumer for session with id:" + sessionId);

        }
        return consumer;
    }

    public void send(quickfix.Message message, SessionID sessionID) {
        try {
            Session.sendToTarget(message, sessionID);
        } catch (SessionNotFound e) {
            throw new IllegalStateException("Session not found:" + sessionID + " for message:" + message);
        }
    }

    public void register(final SessionID sessionId, final Consumer<Message> quickfixMessageConsumer) {
        consumers.put(sessionId, quickfixMessageConsumer);
    }
}
