package org.fix4j.test.messageflags

import org.fix4j.test.fixmodel.BaseFixMessage
import org.fix4j.test.fixspec.FixSpecification
import org.fix4j.spec.fix50sp2.FixSpec
import spock.lang.Specification

/**
 * User: ben
 * Date: 14/11/2014
 * Time: 6:00 AM
 */
class MissingRequiredFieldMessageFlagRuleTest extends Specification {

    public void "test GetMessageFlags - Nothing missing"() {
        given:
        final String msg =
            "[MsgType]35=V[MARKETDATAREQUEST]|" +
            "[MDReqID]262=AASDJKG790|" +
            "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
            "[MarketDepth]264=20|" +
            "[NoMDEntryTypes]267=2|" +
                "[MDEntryType]269=0[BID]|" +
                "[MDEntryType]269=1[OFFER]|" +
            "[NoRelatedSym]146=3|" +
                "[Symbol]55=GBP/USD|" +
                "[SettlDate]64=SP|" +
                "[Symbol]55=AUD/USD|" +
                "[SettlDate]64=1W|" +
                "[Symbol]55=USD/JPY|" +
                "[SettlDate]64=1W";

        final FixSpecification spec = FixSpec.INSTANCE
        BaseFixMessage fixMessage = spec.parse(msg)
        final MissingRequiredFieldMessageFlagRule rule = new MissingRequiredFieldMessageFlagRule();

        expect:
        assert rule.isTriggered(fixMessage);
        assert rule.getMessageFlags(fixMessage).getReportAsString() == "";
    }

    public void "test GetMessageFlags - MarketDepth and NoRelatedSym group missing"() {
        given:
        final String msg =
                "[MsgType]35=V[MARKETDATAREQUEST]|" +
                "[MDReqID]262=AASDJKG790|" +
                "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
                "[NoMDEntryTypes]267=2|" +
                    "[MDEntryType]269=0[BID]|" +
                    "[MDEntryType]269=1[OFFER]";

        final FixSpecification spec = FixSpec.INSTANCE
        BaseFixMessage fixMessage = spec.parse(msg)

        when:
        final MissingRequiredFieldMessageFlagRule rule = new MissingRequiredFieldMessageFlagRule();

        then:
        assert rule.isTriggered(fixMessage);
        assert rule.getMessageFlags(fixMessage).getReportAsString() ==
                "[MsgType]35=V[MARKETDATAREQUEST]|[MDReqID]262=AASDJKG790|[SubscriptionRequestType]263=0[SNAPSHOT]|[NoMDEntryTypes]267=2|[MDEntryType]269=0[BID]|[MDEntryType]269=1[OFFER]\n" +
                "    1.   Required field not found: [MarketDepth]264\n" +
                "    2.   Required group not found: [NoRelatedSym]146\n";
    }
}
