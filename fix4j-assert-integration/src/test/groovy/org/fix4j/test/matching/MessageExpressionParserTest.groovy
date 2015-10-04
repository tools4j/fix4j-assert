package org.fix4j.test.matching

import org.fix4j.test.expression.MessageExpression
import org.fix4j.test.expression.MessageExpressionParser
import org.fix4j.test.fixmodel.Field
import org.fix4j.test.fixspec.FixSpecification
import org.fix4j.spec.fix50sp2.FieldTypes
import org.fix4j.spec.fix50sp2.FixSpec
import org.fix4j.test.properties.ApplicationProperties
import org.fix4j.test.properties.ApplicationPropertiesFactory
import org.fix4j.test.util.ExceptionUtils
import spock.lang.Specification

/**
 * User: ben
 * Date: 7/10/2014
 * Time: 5:51 AM
 */
class MessageExpressionParserTest extends Specification {
    private FixSpecification spec = FixSpec.INSTANCE;
    private MessageExpressionParser parser = new MessageExpressionParser(spec);

    private final String MARKET_DATA_REQUEST =
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


    //Parse field type
    def "test parse expression"() {
        when:
        final MessageExpression expression = parser.parse(MARKET_DATA_REQUEST);

        then:
        assert expression.getFieldExpressions().size() == 11;
        assert expression.getFieldExpressions().get(0).equals(new Field(FieldTypes.MsgType, "V"))
        assert expression.getFieldExpressions().get(1).equals(new Field(FieldTypes.MDReqID, "AASDJKG790"))
        assert expression.getFieldExpressions().get(2).equals(new Field(FieldTypes.SubscriptionRequestType, "0"))
        assert expression.getFieldExpressions().get(3).equals(new Field(FieldTypes.MarketDepth, "20"))
        assert expression.getFieldExpressions().get(4).equals(new Field(FieldTypes.NoMDEntryTypes, "2"))
        assert expression.getFieldExpressions().get(5).equals(new Field(FieldTypes.MDEntryType, "0"))
        assert expression.getFieldExpressions().get(6).equals(new Field(FieldTypes.MDEntryType, "1"))
        assert expression.getFieldExpressions().get(7).equals(new Field(FieldTypes.NoRelatedSym, "3"))
        assert expression.getFieldExpressions().get(8).equals(new Field(FieldTypes.Symbol, "GBP/USD"))
        assert expression.getFieldExpressions().get(9).equals(new Field(FieldTypes.Symbol, "AUD/USD"))
        assert expression.getFieldExpressions().get(10).equals(new Field(FieldTypes.Symbol, "USD/JPY"))
    }

    def "test toString"() {
        when:
        final MessageExpression expression = parser.parse(MARKET_DATA_REQUEST);

        then:
        assert expression.toString() == "[MsgType]35=V[MARKETDATAREQUEST]|[MDReqID]262=AASDJKG790|[SubscriptionRequestType]263=0[SNAPSHOT]|[MarketDepth]264=20|[NoMDEntryTypes]267=2|[MDEntryType]269=0[BID]|[MDEntryType]269=1[OFFER]|[NoRelatedSym]146=3|[Symbol]55=GBP/USD|[Symbol]55=AUD/USD|[Symbol]55=USD/JPY|";
    }

    def "test ParseFieldType, number and text"() {
        expect: assert parser.parseFieldType("[MsgType]35") == FieldTypes.MsgType;
    }

    def "test ParseFieldType, just text"() {
        expect: assert parser.parseFieldType("MsgType") == FieldTypes.MsgType;
    }

    def "test ParseFieldType, text for unknown tag"() {
        when:
        assert parser.parseFieldType("BlahBlah") == FieldTypes.MsgType;

        then:
        thrown IllegalArgumentException.class;
    }

    def "test ParseFieldType, tag text is given between round brackets (not square)"() {
        when:
        assert parser.parseFieldType("(MsgType)35") == FieldTypes.MsgType;

        then:
        thrown IllegalArgumentException.class;
    }

    def "test ParseFieldType, tag text is given after tag number"() {
        expect: assert parser.parseFieldType("35[MsgType]") == FieldTypes.MsgType;
    }

    def "test ParseFieldType, just number, but for custom tag"() {
        expect: assert parser.parseFieldType("12345678") == FieldTypes.forCustomTag(12345678);
    }

    def "test ParseFieldType, mismatched tag number to tag name"() {
        when:
        parser.parseFieldType("[Blah]35")

        then:
        final IllegalArgumentException exception = thrown();
        ExceptionUtils.assertExceptionMessagesContain(exception, "Parsed field '[Blah]35' contains mismatched tag number to tag name.  Expected: '[MsgType]35'");
    }

    //ParseFieldValue
    def "test ParseFieldValue, just value"() {
        expect: assert parser.parseFieldValue(FieldTypes.MsgType, "Blah de blah") == "Blah de blah";
    }

    def "test ParseFieldValue, escaped square brackets"() {
        expect: assert parser.parseFieldValue(FieldTypes.OrderID, "ID\\[1234XYZ\\]") == "ID[1234XYZ]";
    }

    def "test ParseFieldValue, value enum then description"() {
        expect: assert parser.parseFieldValue(FieldTypes.MsgType, "D[NEWORDERSINGLE]") == "D";
    }

    def "test ParseFieldValue, value description then enum"() {
        expect: assert parser.parseFieldValue(FieldTypes.MsgType, "[NEWORDERSINGLE]D") == "D";
    }

    def "test ParseFieldValue, value enum then description, description does not match enum"() {
        when:
        parser.parseFieldValue(FieldTypes.MsgType, "D[BLAH]");

        then:
        thrown IllegalArgumentException.class;
    }

    def "test ParseFieldValue, value description then enum, description does not match enum"() {
        when:
        parser.parseFieldValue(FieldTypes.MsgType, "[BLAH]D");

        then:
        thrown IllegalArgumentException.class;
    }

    def "test ParseFieldValue, value enum then description, enum not valid, fieldType does have valid enums"() {
        when:
        parser.parseFieldValue(FieldTypes.MsgType, "XYZ[BLAH]");

        then:
        thrown IllegalArgumentException.class;
    }

    def "test ParseFieldValue, value description then enum, enum not valid, fieldType does have valid enums"() {
        when:
        parser.parseFieldValue(FieldTypes.MsgType, "[BLAH]XYZ");

        then:
        thrown IllegalArgumentException.class;
    }

    def "test ParseFieldValue, value enum then description, enum not valid, fieldType does NOT have any valid enums"() {
        when:
        parser.parseFieldValue(FieldTypes.OrderID, "XYZ[BLAH]");

        then:
        thrown IllegalArgumentException.class;
    }

    def "test ParseFieldValue, value description then enum, enum not valid, fieldType does NOT have any valid enums"() {
        when:
        parser.parseFieldValue(FieldTypes.OrderID, "[BLAH]XYZ");

        then:
        thrown IllegalArgumentException.class;
    }

    //ParseField
    def "test ParseField, 35=D"() {
        expect: assert parser.parseField("35=D") == new Field(FieldTypes.MsgType, "D");
    }

    def "test ParseField, 35=.*"() {
        expect: assert parser.parseField("35=.*") == new Field(FieldTypes.MsgType, ".*");
    }

    def "test ParseField, 12345678=D"() {
        expect: assert parser.parseField("12345678=D") == new Field(FieldTypes.forCustomTag(12345678), "D");
    }

    def "test ParseField, 12345678=BLAH"() {
        expect: assert parser.parseField("12345678=D") != new Field(FieldTypes.forCustomTag(12345678), "BLAH");
    }

    def "test ParseField, [MsgType]35=[NEWORDERSINGLE]D"() {
        expect: assert parser.parseField("[MsgType]35=[NEWORDERSINGLE]D") == new Field(FieldTypes.MsgType, "D");
    }

    def "test ParseField, [MsgType]35=D"() {
        expect: assert parser.parseField("[MsgType]35=D") == new Field(FieldTypes.MsgType, "D");
    }

    def "test ParseField, MsgType=D"() {
        expect: assert parser.parseField("MsgType=D") == new Field(FieldTypes.MsgType, "D");
    }

    def "test ParseExpression, no equals in field"(){
        when:
        parser.parse("35=D|foo|bar")

        then:
        final IllegalArgumentException exception = thrown()
        ExceptionUtils.assertExceptionMessagesContain(exception, "Fix field expression does not match '<tag>=<value>' format. Field: 'foo'");
    }

    def "test ParseExpression, too many equals in field"(){
        when:
        parser.parse("35=D|foo=bar=blah")

        then:
        final IllegalArgumentException exception = thrown()
        ExceptionUtils.assertExceptionMessagesContain(exception, "Badly formatted field 'foo=bar=blah'.  More than one equals sign '=' detected.  This could mean that there was more than one equals sign specified in the field, or, it could mean that two or more fields were not separated by a valid field delimiter.  Please ensure that fields are separated by text which matches regex:");
    }
}
