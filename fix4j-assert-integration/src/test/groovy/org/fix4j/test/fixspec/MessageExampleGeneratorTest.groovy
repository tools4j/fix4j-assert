package org.fix4j.test.fixspec

import org.fix4j.test.fixmodel.FixMessage
import org.fix4j.spec.fix50sp2.FixSpec
import org.fix4j.spec.fix50sp2.MsgTypes
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

/**
 * User: ben
 * Date: 30/10/2014
 * Time: 6:12 AM
 */
class MessageExampleGeneratorTest extends Specification {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageExampleGeneratorTest.class);

    def "test generateExampleMessage"() {
        expect:
        final FixMessage message = MsgTypes.ExecutionReport.generateExampleMessage(FixSpec.INSTANCE);
        LOGGER.info message.toPrettyString();
    }
}
