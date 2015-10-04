package org.fix4j.test.fixmodel

import org.fix4j.spec.fix50sp2.fieldtype.StatsType
import org.fix4j.test.expression.MessageExpressionParser
import org.fix4j.spec.fix50sp2.FixSpec
import org.fix4j.test.properties.ApplicationProperties
import org.fix4j.test.properties.ApplicationPropertiesFactory
import spock.lang.Specification

/**
 * User: ben
 * Date: 26/10/2014
 * Time: 9:51 AM
 */
class BaseFixMessageBuilderTest extends Specification {
    def "test withFields flat message"() {
        given:
        final BaseFixMessageBuilder builder = new BaseFixMessageBuilder(FixSpec.INSTANCE);
        final MessageExpressionParser parser = new MessageExpressionParser(FixSpec.INSTANCE);

        when:
        final Collection<Field> fields = parser.parse("35=D|38=1000|59=1|100=N|40=1|11=ORD10001|60=20070123-19:01:17|55=HPQ|54=1|21=2").toFields();
        builder.withFields(fields);

        then:
        final FixMessage fixMessage = builder.build();
        final String expectedOutput =
                "------------------------------------------------------\n" +
                "NewOrderSingle\n" +
                "------------------------------------------------------\n" +
                "Header\n" +
                "    [MsgType]35=D[NEWORDERSINGLE]\n" +
                "Body\n" +
                "    [OrderQty]38=1000\n" +
                "    [TimeInForce]59=1[GOOD_TILL_CANCEL_GTC]\n" +
                "    [ExDestination]100=N\n" +
                "    [OrdType]40=1[MARKET]\n" +
                "    [ClOrdID]11=ORD10001\n" +
                "    [TransactTime]60=20070123-19:01:17\n" +
                "    [Symbol]55=HPQ\n" +
                "    [Side]54=1[BUY]\n" +
                "    [HandlInst]21=2[AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK]\n" +
                "Trailer\n" +
                "    <empty>\n";

        assert fixMessage.toPrettyString() == expectedOutput;
    }

    def "test withFields with a group with repeats 1"() {
        given:
        final BaseFixMessageBuilder builder = new BaseFixMessageBuilder(FixSpec.INSTANCE);
        final MessageExpressionParser parser = new MessageExpressionParser(FixSpec.INSTANCE);

        when:
        final Collection<Field> fields = parser.parse("|" +
                "[MsgType]35=V[MARKETDATAREQUEST]|" +
                "[NoHops]627=2|" +
                    "[HopCompID]628=string|" +
                    "[HopSendingTime]629=20140727-10:00:00.000|" +
                    "[HopRefID]630=2|" +
                    "[HopCompID]628=string|" +
                    "[HopSendingTime]629=20140727-10:00:00.000|" +
                    "[HopRefID]630=2|" +
                "[MDReqID]262=AASDJKG790|" +
                "[SubscriptionRequestType]263=1[SNAPSHOT__UPDATES_SUBSCRIBE]|" +
                "[MDUpdateType]265=0[FULL_REFRESH]|" +
                "[MarketDepth]264=0|" +
                "[NoRelatedSym]146=3|" +
                    "[Symbol]55=GBP/USD|" +
                    "[SettlDate]64=SP|" +
                    "[Symbol]55=AUD/USD|" +
                    "[SettlDate]64=1W|" +
                    "[Symbol]55=USD/JPY|" +
                    "[SettlDate]64=1W|" +
                "[NoMDEntryTypes]267=2|" +
                    "[MDEntryType]269=0[BID]|" +
                    "[MDEntryType]269=1[OFFER]|" +
                "").toFields();
        builder.withFields(fields);

        then:
        final FixMessage fixMessage = builder.build();
        final String expectedOutput =
                "------------------------------------------------------\n" +
                "MarketDataRequest\n" +
                "------------------------------------------------------\n" +
                "Header\n" +
                "    [MsgType]35=V[MARKETDATAREQUEST]\n" +
                "    [NoHops]627=2\n" +
                "      1.[HopCompID]628=string\n" +
                "        [HopSendingTime]629=20140727-10:00:00.000\n" +
                "        [HopRefID]630=2\n" +
                "      2.[HopCompID]628=string\n" +
                "        [HopSendingTime]629=20140727-10:00:00.000\n" +
                "        [HopRefID]630=2\n" +
                "Body\n" +
                "    [MDReqID]262=AASDJKG790\n" +
                "    [SubscriptionRequestType]263=1[SNAPSHOT__UPDATES_SUBSCRIBE]\n" +
                "    [MDUpdateType]265=0[FULL_REFRESH]\n" +
                "    [MarketDepth]264=0\n" +
                "    [NoRelatedSym]146=3\n" +
                "      1.[Symbol]55=GBP/USD\n" +
                "        [SettlDate]64=SP\n" +
                "      2.[Symbol]55=AUD/USD\n" +
                "        [SettlDate]64=1W\n" +
                "      3.[Symbol]55=USD/JPY\n" +
                "        [SettlDate]64=1W\n" +
                "    [NoMDEntryTypes]267=2\n" +
                "      1.[MDEntryType]269=0[BID]\n" +
                "      2.[MDEntryType]269=1[OFFER]\n" +
                "Trailer\n" +
                "    <empty>\n" +
                "";

        assert fixMessage.toPrettyString() == expectedOutput;
    }


    def "test withFields with a group with repeats 2"() {
        given:
        final BaseFixMessageBuilder builder = new BaseFixMessageBuilder(FixSpec.INSTANCE);
        final MessageExpressionParser parser = new MessageExpressionParser(FixSpec.INSTANCE);

        when:
        final Collection<Field> fields = parser.parse("|" +
                "[MsgType]35=V[MARKETDATAREQUEST]|" +
                "[MDReqID]262=AASDJKG790|" +
                "[NoRelatedSym]146=3|" +
                    "[Symbol]55=GBP/USD|" +
                    "[SettlDate]64=SP|" +
                    "[Symbol]55=AUD/USD|" +
                    "[SettlDate]64=1W|" +
                    "[Symbol]55=USD/JPY|" +
                    "[SettlDate]64=1W|" +
                "[NoMDEntryTypes]267=2|" +
                    "[MDEntryType]269=0[BID]|" +
                    "[MDEntryType]269=1[OFFER]|" +
                "").toFields();
        builder.withFields(fields);

        then:
        final FixMessage fixMessage = builder.build();
        final String expectedOutput =
                "------------------------------------------------------\n" +
                "MarketDataRequest\n" +
                "------------------------------------------------------\n" +
                "Header\n" +
                "    [MsgType]35=V[MARKETDATAREQUEST]\n" +
                "Body\n" +
                "    [MDReqID]262=AASDJKG790\n" +
                "    [NoRelatedSym]146=3\n" +
                "      1.[Symbol]55=GBP/USD\n" +
                "        [SettlDate]64=SP\n" +
                "      2.[Symbol]55=AUD/USD\n" +
                "        [SettlDate]64=1W\n" +
                "      3.[Symbol]55=USD/JPY\n" +
                "        [SettlDate]64=1W\n" +
                "    [NoMDEntryTypes]267=2\n" +
                "      1.[MDEntryType]269=0[BID]\n" +
                "      2.[MDEntryType]269=1[OFFER]\n" +
                "Trailer\n" +
                "    <empty>\n" +
                "";

        assert fixMessage.toPrettyString() == expectedOutput;
    }

    def "test withFields with a group with repeats 3"() {
        given:
        final BaseFixMessageBuilder builder = new BaseFixMessageBuilder(FixSpec.INSTANCE);
        final MessageExpressionParser parser = new MessageExpressionParser(FixSpec.INSTANCE);

        when:
        final Collection<Field> fields = parser.parse(
                "[MsgType]35=V[MARKETDATAREQUEST]|" +
                "[MDReqID]262=AASDJKG790|" +
                "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
                "[MarketDepth]264=20|" +
                "[NoMDEntryTypes]267=2|" +
                    "[MDEntryType]269=0[BID]|" +
                    "[MDEntryType]269=1[OFFER]|" +
                "[NoRelatedSym]146=3|" +
                    "[Symbol]55=GBP/USD|" +
                    "[Symbol]55=AUD/USD|" +
                    "[Symbol]55=USD/JPY|").toFields();

        builder.withFields(fields);

        then:
        final FixMessage fixMessage = builder.build();
        final String expectedOutput =
                "[MsgType]35=V[MARKETDATAREQUEST]|" +
                "[MDReqID]262=AASDJKG790|" +
                "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
                "[MarketDepth]264=20|" +
                "[NoMDEntryTypes]267=2|" +
                    "[MDEntryType]269=0[BID]|" +
                    "[MDEntryType]269=1[OFFER]|" +
                "[NoRelatedSym]146=3|" +
                    "[Symbol]55=GBP/USD|" +
                    "[Symbol]55=AUD/USD|" +
                    "[Symbol]55=USD/JPY|";

        assert fixMessage.toDelimitedMessageWithDescriptors() == expectedOutput;
    }



    def "test with two levels of repeats"() {
        given:
        final BaseFixMessageBuilder builder = new BaseFixMessageBuilder(FixSpec.INSTANCE);
        final MessageExpressionParser parser = new MessageExpressionParser(FixSpec.INSTANCE);

        String messageStr =
                "    [MsgType]35=X[MARKETDATAINCREMENTALREFRESH]\n" +
                "    [MDReqID]262=request123\n" +
                "    [NoMDEntries]268=4\n" +
                "      1.[MDUpdateAction]279=0[NEW]\n" +
                "        [MDEntryType]269=0[BID]\n" +
                "        [Symbol]55=AUD/USD\n" +
                "        [MDEntryPx]270=1.12345\n" +
                "        [NoPartyIDs]453=2\n" +
                "          1.[PartyID]448=MrMaker\n" +
                "            [PartyRole]452=66[MARKET_MAKER]\n" +
                "          2.[PartyID]448=Exchange\n" +
                "            [PartyRole]452=22[EXCHANGE]\n" +
                "        [NoStatsIndicators]1175=1\n" +
                "          1.[StatsType]1176=EXCHANGE_LAST\n" +
                "      2.[MDUpdateAction]279=0[NEW]\n" +
                "        [MDEntryType]269=1[OFFER]\n" +
                "        [Symbol]55=AUD/USD\n" +
                "        [MDEntryPx]270=1.12355\n" +
                "        [NoPartyIDs]453=2\n" +
                "          1.[PartyID]448=MrMaker\n" +
                "            [PartyRole]452=66[MARKET_MAKER]\n" +
                "          2.[PartyID]448=Exchange\n" +
                "            [PartyRole]452=22[EXCHANGE]\n" +
                "        [NoStatsIndicators]1175=1\n" +
                "          1.[StatsType]1176=EXCHANGE_LAST\n";

        when:
        final Collection<Field> fields = parser.parse(messageStr).toFields();
        builder.withFields(fields);

        then:
        final FixMessage fixMessage = builder.build();
        println fixMessage.toPrettyString();
        assert fixMessage.toDelimitedMessageWithDescriptors() == PrettyStripper.stripPrettiness(messageStr);
    }
}
