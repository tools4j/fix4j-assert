package org.fix4j.test.expression

import org.fix4j.test.fixspec.FixSpecification
import org.fix4j.spec.fix50sp2.FixSpec
import spock.lang.Specification

/**
 * User: ben
 * Date: 2/09/2014
 * Time: 5:03 PM
 */
class MatcherParserTest extends Specification {
    private FixSpecification fixSpecification = FixSpec.INSTANCE;
    private MessageExpressionParser parser = new MessageExpressionParser(fixSpecification);

    def testParseByFieldNumbersAndParseByFieldNamesAreEqual() {
        expect:
        final MessageExpression messageExpressionParsedByFieldNumber = parser.parse("8=FIX.4.2|9=130|35=D|34=659|49=BROKER04|56=REUTERS|52=20070123-19:09:43|38=1000|59=1|100=N|40=1|11=ORD10001|60=20070123-19:01:17|55=HPQ|54=1|21=2|10=004");
        final MessageExpression messageExpressionParsedByFieldName = parser.parse("BeginString=FIX.4.2|BodyLength=130|MsgType=D|MsgSeqNum=659|SenderCompID=BROKER04|TargetCompID=REUTERS|SendingTime=20070123-19:09:43|OrderQty=1000|TimeInForce=1|ExDestination=N|OrdType=1|ClOrdID=ORD10001|TransactTime=20070123-19:01:17|Symbol=HPQ|Side=1|HandlInst=2|CheckSum=004|");
        assert messageExpressionParsedByFieldNumber.equals(messageExpressionParsedByFieldName);
    }
}
