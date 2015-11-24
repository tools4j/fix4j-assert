package org.fix4j.test.matching

import org.fix4j.spec.fix50sp2.FieldTypes
import org.fix4j.spec.fix50sp2.FixSpec
import org.fix4j.test.expression.MessageExpression
import org.fix4j.test.expression.RawFixMessageExpressionParser
import org.fix4j.test.fixmodel.Field
import org.fix4j.test.fixspec.FixSpecification
import org.fix4j.test.properties.ApplicationProperties
import org.fix4j.test.properties.ApplicationPropertiesFactory
import org.fix4j.test.properties.MapPropertySource
import org.fix4j.test.properties.PropertyKeysAndDefaultValues
import org.fix4j.test.util.ExceptionUtils
import spock.lang.Specification

/**
 * User: ben
 * Date: 7/10/2014
 * Time: 5:51 AM
 */
class RawFixMessageExpressionParserTest extends Specification {
    private FixSpecification spec = FixSpec.INSTANCE;

    private final String MARKET_DATA_REQUEST = "35=V|262=AASDJKG790|263=0|264=20|267=2|269=0|269=1|146=3|55=GBP/USD|55=AUD/USD|55=USD/JPY|90001=|90002=blah=one,blah=two,blah=three,blah=four";

    def cleanup(){
        final String customDelimiter = PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.defaultValue;
        ApplicationProperties.Singleton.setInstance(new ApplicationPropertiesFactory().createApplicationProperties(new MapPropertySource([(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.getKey()): customDelimiter], "test.prefs")));
    }

    //Parse field type
    def "test parse expression"() {
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        when:
        final MessageExpression expression = parser.parse(MARKET_DATA_REQUEST);

        then:
        assert expression.getFieldExpressions().size() == 13;
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
        assert expression.getFieldExpressions().get(11).equals(new Field(FieldTypes.forCustomTag(90001), ""));
        assert expression.getFieldExpressions().get(12).equals(new Field(FieldTypes.forCustomTag(90002), "blah=one,blah=two,blah=three,blah=four"));
    }

    def "test parse expression with spaces before and after delimiter"() {
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        when:
        final String mdsWithSpaces = "35=V| 262=AASDJKG790 | 263=0| 264=20|";
        final MessageExpression expression = parser.parse(mdsWithSpaces);

        then:
        assert expression.getFieldExpressions().size() == 4;
        assert expression.getFieldExpressions().get(0).equals(new Field(FieldTypes.MsgType, "V"))
        assert expression.getFieldExpressions().get(1).equals(new Field(FieldTypes.MDReqID, "AASDJKG790"))
        assert expression.getFieldExpressions().get(2).equals(new Field(FieldTypes.SubscriptionRequestType, "0"))
        assert expression.getFieldExpressions().get(3).equals(new Field(FieldTypes.MarketDepth, "20"))
    }

    def "test parse expression with header field at the end of the message"() {
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        when:
        final String mdsWithSpaces = "5487=ABC|2345=CDE|35=D";
        final MessageExpression expression = parser.parse(mdsWithSpaces);

        then:
        assert expression.getFieldExpressions().size() == 3;
        assert expression.getFieldExpressions().get(0).equals(new Field(FieldTypes.forCustomTag(5487), "ABC"))
        assert expression.getFieldExpressions().get(1).equals(new Field(FieldTypes.forCustomTag(2345), "CDE"))
        assert expression.getFieldExpressions().get(2).equals(new Field(FieldTypes.MsgType, "D"))
    }

    def "test parse expression with header field at the end of the message, with ; as delimiter"() {
        given:
        final String customDelimiter = ";";
        ApplicationProperties.Singleton.setInstance(new ApplicationPropertiesFactory().createApplicationProperties(new MapPropertySource([(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.getKey()): customDelimiter], "test.prefs")));
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        when:
        final String mdsWithSpaces = "5487=ABC;2345=CDE;35=D;";
        final MessageExpression expression = parser.parse(mdsWithSpaces);

        then:
        assert expression.getFieldExpressions().size() == 3;
        assert expression.getFieldExpressions().get(0).equals(new Field(FieldTypes.forCustomTag(5487), "ABC"))
        assert expression.getFieldExpressions().get(1).equals(new Field(FieldTypes.forCustomTag(2345), "CDE"))
        assert expression.getFieldExpressions().get(2).equals(new Field(FieldTypes.MsgType, "D"))
    }


    def "test parse expression with spaces before and after delimiter, with ; as delimiter"() {
        given:
        final String customDelimiter = ";";
        ApplicationProperties.Singleton.setInstance(new ApplicationPropertiesFactory().createApplicationProperties(new MapPropertySource([(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM.getKey()): customDelimiter], "test.prefs")));
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        when:
        final String mdsWithSpaces = "35=V; 262=AASDJKG790 ; 263=0; 264=20;";
        final MessageExpression expression = parser.parse(mdsWithSpaces);

        then:
        assert expression.getFieldExpressions().size() == 4;
        assert expression.getFieldExpressions().get(0).equals(new Field(FieldTypes.MsgType, "V"))
        assert expression.getFieldExpressions().get(1).equals(new Field(FieldTypes.MDReqID, "AASDJKG790"))
        assert expression.getFieldExpressions().get(2).equals(new Field(FieldTypes.SubscriptionRequestType, "0"))
        assert expression.getFieldExpressions().get(3).equals(new Field(FieldTypes.MarketDepth, "20"))
    }

    def "test toString"() {
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        when:
        final MessageExpression expression = parser.parse(MARKET_DATA_REQUEST);

        then:
        assert expression.toString() == "[MsgType]35=V[MARKETDATAREQUEST]|[MDReqID]262=AASDJKG790|[SubscriptionRequestType]263=0[SNAPSHOT]|[MarketDepth]264=20|[NoMDEntryTypes]267=2|[MDEntryType]269=0[BID]|[MDEntryType]269=1[OFFER]|[NoRelatedSym]146=3|[Symbol]55=GBP/USD|[Symbol]55=AUD/USD|[Symbol]55=USD/JPY|[CUSTOM]90001=|[CUSTOM]90002=blah=one,blah=two,blah=three,blah=four|";
    }

    def "test ParseFieldType, tag type is not a number"() {
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        when:
        parser.parseFieldType("blah");

        then:
        thrown IllegalArgumentException.class;
    }

    def "test ParseFieldType, known tag"() {
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        expect:
        assert parser.parseFieldType("35") == FieldTypes.MsgType;
    }

    def "test ParseFieldType, custom tag"() {
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        expect:
        assert parser.parseFieldType("12345678") == FieldTypes.forCustomTag(12345678);
    }

    //ParseField
    def "test ParseField, 35=D"() {
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        expect:
        assert parser.parseField("35=D") == new Field(FieldTypes.MsgType, "D");
    }

    def "test ParseField, 35=blah[asdf]"() {
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        expect:
        assert parser.parseField("35=blah[asdf]") == new Field(FieldTypes.MsgType, "blah[asdf]");
    }

    def "test ParseField, 12345678=D"() {
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        expect:
        assert parser.parseField("12345678=D") == new Field(FieldTypes.forCustomTag(12345678), "D");
    }

    def "test ParseField, 12345678=BLAH"() {
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        expect:
        assert parser.parseField("12345678=D") != new Field(FieldTypes.forCustomTag(12345678), "BLAH");
    }

    def "test ParseExpression, no equals in field"(){
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        when:
        parser.parse("35=D|foo|bar")

        then:
        final IllegalArgumentException exception = thrown()
        ExceptionUtils.assertExceptionMessagesContain(exception, "Field expression must contain equals sign '='");
    }

    def "test ParseField, map embedded in tag value"(){
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        expect:
        parser.parseField("123456=one=valueOne,two=valueTwo") == new Field(FieldTypes.forCustomTag(123456), "one=valueOne,two=valueTwo");
    }

    def "test ParseField, empty tag value"(){
        given:
        final RawFixMessageExpressionParser parser = new RawFixMessageExpressionParser(spec);

        expect:
        parser.parseField("123456=") == new Field(FieldTypes.forCustomTag(123456), "");
    }
}
