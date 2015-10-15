package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.expression.MessageExpression;
import org.fix4j.test.expression.FlexibleMessageExpressionParser;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.util.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: ben
 * Date: 19/11/14
 * Time: 12:52 AM
 */
public class SimpleOutboundSession {
    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleOutboundSession.class);
    private final FixSpecification fixSpecification;
    private final Consumer<FixMessage> toNetwork;
    private final FlexibleMessageExpressionParser messageExpressionParser;

    public SimpleOutboundSession(final FixSpecification fixSpecification, final Consumer<FixMessage> toNetwork) {
        this.fixSpecification = fixSpecification;
        this.toNetwork = toNetwork;
        this.messageExpressionParser = new FlexibleMessageExpressionParser(fixSpecification);
    }

    public void send(final String messageStr) {
        final MessageExpression expression = messageExpressionParser.parse(messageStr);
        final FixMessage message = expression.asMessage(fixSpecification);
        send(message);
    }

    public void send(final FixMessage message){
        LOGGER.info(">>>>>>" + Consts.EOL + message.toPrettyString());
        toNetwork.accept(message);
    }
}
