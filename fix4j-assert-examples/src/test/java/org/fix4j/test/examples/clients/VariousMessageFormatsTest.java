package org.fix4j.test.examples.clients;

import org.fix4j.spec.fix50sp2.FieldTypes;
import org.fix4j.spec.fix50sp2.FixSpec;
import org.fix4j.spec.fix50sp2.fieldtype.*;
import org.fix4j.test.expression.MessageExpression;
import org.fix4j.test.expression.MessageExpressionParser;
import org.fix4j.test.fixmodel.Field;
import org.fix4j.test.fixspec.FixSpecification;
import org.junit.Test;

/**
 * User: ben
 */
public class VariousMessageFormatsTest {
    private FixSpecification spec = FixSpec.INSTANCE;
    private MessageExpressionParser parser = new MessageExpressionParser(spec);

    @Test
    public void testPrettyExpression() {
        final MessageExpression expression = parser.parse(
            "[MsgType]35=V[MARKETDATAREQUEST]|" +
            "[MDReqID]262=AASDJKG790|" +
            "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
            "[MarketDepth]264=20|" +
            "[NoMDEntryTypes]267=2|" +
            "   1. [MDEntryType]269=0[BID]|" +
            "   2. [MDEntryType]269=1[OFFER]|" +
            "[NoRelatedSym]146=3|" +
            "   1. [Symbol]55=GBP/USD|" +
            "      [SettlDate]64=SP|" +
            "   2. [Symbol]55=AUD/USD|" +
            "      [SettlDate]64=SP|" +
            "   3. [Symbol]55=USD/JPY|" +
            "      [SettlDate]64=SP|");

        assertMessage(expression);
    }

    @Test
    public void testExpressionWithDescriptorsAndPipeAsDelimiter() {
        final MessageExpression expression = parser.parse(
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
                "[SettlDate]64=SP|" +
                "[Symbol]55=USD/JPY|" +
                "[SettlDate]64=SP|");


        assertMessage(expression);
    }

    @Test
    public void testExpressionWithDescriptorsAndCtrlAAsDelimiter() {
        final MessageExpression expression = parser.parse(
            "[MsgType]35=V[MARKETDATAREQUEST]^A" +
            "[MDReqID]262=AASDJKG790^A" +
            "[SubscriptionRequestType]263=0[SNAPSHOT]^A" +
            "[MarketDepth]264=20^A" +
            "[NoMDEntryTypes]267=2^A" +
                "[MDEntryType]269=0[BID]^A" +
                "[MDEntryType]269=1[OFFER]^A" +
            "[NoRelatedSym]146=3^A" +
                "[Symbol]55=GBP/USD^A" +
                "[SettlDate]64=SP^A" +
                "[Symbol]55=AUD/USD^A" +
                "[SettlDate]64=SP^A" +
                "[Symbol]55=USD/JPY^A" +
                "[SettlDate]64=SP|");

        assertMessage(expression);
    }

    @Test
    public void testExpressionWithAsciiOneAsDelimiter() {
        final MessageExpression expression = parser.parse("35=V\u0001262=AASDJKG790\u0001263=0\u0001264=20\u0001267=2\u0001269=0\u0001269=1\u0001146=3\u000155=GBP/USD\u000164=SP\u000155=AUD/USD\u000164=SP\u000155=USD/JPY\u000164=SP");
        assertMessage(expression);
    }

    @Test
    public void testExpressionWithCtrlAAsDelimiter() {
        final MessageExpression expression = parser.parse("35=V^A262=AASDJKG790^A263=0^A264=20^A267=2^A269=0^A269=1^A146=3^A55=GBP/USD^A64=SP^A55=AUD/USD^A64=SP^A55=USD/JPY^A64=SP");
        assertMessage(expression);
    }

    @Test
    public void testExpressionWithJustKeySideDescriptors() {
        final MessageExpression expression = parser.parse(
            "[MsgType]35=V|" +
            "[MDReqID]262=AASDJKG790|" +
            "[SubscriptionRequestType]263=0|" +
            "[MarketDepth]264=20|" +
            "[NoMDEntryTypes]267=2|" +
                "[MDEntryType]269=0|" +
                "[MDEntryType]269=1|" +
            "[NoRelatedSym]146=3|" +
                "[Symbol]55=GBP/USD|" +
                "[SettlDate]64=SP|" +
                "[Symbol]55=AUD/USD|" +
                "[SettlDate]64=SP|" +
                "[Symbol]55=USD/JPY|" +
                "[SettlDate]64=SP|");

        assertMessage(expression);
    }

    @Test
    public void testExpressionWithJustValueSideDescriptors() {
        final MessageExpression expression = parser.parse(
                "35=V[MARKETDATAREQUEST]|" +
                "262=AASDJKG790|" +
                "263=0[SNAPSHOT]|" +
                "264=20|" +
                "267=2|" +
                    "269=0[BID]|" +
                    "269=1[OFFER]|" +
                "146=3|" +
                    "55=GBP/USD|" +
                    "64=SP|" +
                    "55=AUD/USD|" +
                    "64=SP|" +
                    "55=USD/JPY|" +
                    "64=SP|");

        assertMessage(expression);
    }


    @Test
    public void testBuildingExpressionUsingTypes() {
        final MessageExpression expression = new MessageExpression(
                MsgType.withValue("V"),
                MDReqID.withValue("AASDJKG790"),
                SubscriptionRequestType.withValue("0"),
                MarketDepth.withValue("20"),
                NoMDEntryTypes.withValue("2"),
                    MDEntryType.withValue().BID,
                    MDEntryType.withValue().OFFER,
                NoRelatedSym.withValue("3"),
                    Symbol.withValue("GBP/USD"),
                    SettlDate.withValue("SP"),
                    Symbol.withValue("AUD/USD"),
                    SettlDate.withValue("SP"),
                    Symbol.withValue("USD/JPY"),
                    SettlDate.withValue("SP"));

        assertMessage(expression);
    }

    @Test
    public void testExpressionWithNoDescriptors() {
        final MessageExpression expression = parser.parse("35=V|262=AASDJKG790|263=0|264=20|267=2|269=0|269=1|146=3|55=GBP/USD|64=SP|55=AUD/USD|64=SP|55=USD/JPY|64=SP|");
        assertMessage(expression);
    }


    private boolean assertMessage(final MessageExpression expression){
        assert expression.getFieldExpressions().size() == 14;
        assert expression.getFieldExpressions().get(0).equals(new Field(FieldTypes.MsgType, "V"));
        assert expression.getFieldExpressions().get(1).equals(new Field(FieldTypes.MDReqID, "AASDJKG790"));
        assert expression.getFieldExpressions().get(2).equals(new Field(FieldTypes.SubscriptionRequestType, "0"));
        assert expression.getFieldExpressions().get(3).equals(new Field(FieldTypes.MarketDepth, "20"));
        assert expression.getFieldExpressions().get(4).equals(new Field(FieldTypes.NoMDEntryTypes, "2"));
        assert expression.getFieldExpressions().get(5).equals(new Field(FieldTypes.MDEntryType, "0"));
        assert expression.getFieldExpressions().get(6).equals(new Field(FieldTypes.MDEntryType, "1"));
        assert expression.getFieldExpressions().get(7).equals(new Field(FieldTypes.NoRelatedSym, "3"));
        assert expression.getFieldExpressions().get(8).equals(new Field(FieldTypes.Symbol, "GBP/USD"));
        assert expression.getFieldExpressions().get(9).equals(new Field(FieldTypes.SettlDate, "SP"));
        assert expression.getFieldExpressions().get(10).equals(new Field(FieldTypes.Symbol, "AUD/USD"));
        assert expression.getFieldExpressions().get(11).equals(new Field(FieldTypes.SettlDate, "SP"));
        assert expression.getFieldExpressions().get(12).equals(new Field(FieldTypes.Symbol, "USD/JPY"));
        assert expression.getFieldExpressions().get(13).equals(new Field(FieldTypes.SettlDate, "SP"));
        return true;
    }
}
