package org.fix4j.test.expression

import org.fix4j.spec.fix50sp2.FixSpec
import org.fix4j.test.TestMessages
import org.fix4j.test.fixmodel.FixMessage
import spock.lang.Specification

/**
 * User: ben
 * Date: 22/12/14
 * Time: 8:39 AM
 */
class MessageExpressionMatcherTest extends Specification {
    def "test message type"(){
        when:
        final FixMessage fixMessage = FixSpec.INSTANCE.parse(TestMessages.NEW_ORDER_SINGLE);

        then:
        assert matches("35=D", fixMessage)
        assert !matches("35=A", fixMessage)
        assert !matches("35=.*", fixMessage) //This should not match. Without the forward slashes, the .* is treated as literal text
        assert matches("35=/.*/", fixMessage) //This SHOULD match, because of the surrounding forward slashes, the .* is treated as a regex.
    }

    protected boolean matches(String matchingExpression, FixMessage fixMessage) {
        MessageExpression expression = new MessageExpressionParser(FixSpec.INSTANCE).parse(matchingExpression);
        return expression.getMatchResult(fixMessage).matches();
    }
}
