package org.fix4j.test.messageflags;

import org.fix4j.test.fixmodel.FixMessage;

/**
 * This class implements rule which can be applied to a fixMessage to produce {@link org.fix4j.test.messageflags.MessageFlags}
 *
 * MessageFlags are useful to alert the test author to certain aspects of an outgoing or incoming fixMessage.
 *
 * For example, we may wish to alert the test author that they have specified fields in a repeating group in the wrong order.
 *
 * If MessageFlags are triggered, they can then be used to fail a test (and provide the test author/runner with detail as to what flag was triggered)
 * Or to simply display warnings in the test log.
 *
 * User: ben
 */
public interface MessageFlagRule {
    boolean isTriggered(FixMessage fixMessage);
    MessageFlags getMessageFlags(FixMessage fixMessage);
}
