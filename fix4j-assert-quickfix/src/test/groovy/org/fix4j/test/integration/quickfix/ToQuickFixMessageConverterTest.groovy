package org.fix4j.test.integration.quickfix

import org.fix4j.spec.fix50sp2.FieldTypes
import org.fix4j.spec.fix50sp2.FixSpec
import org.fix4j.test.fixmodel.FixMessage
import org.fix4j.test.fixspec.BaseGroupType
import org.fix4j.test.fixspec.FixSpecification
import org.fix4j.test.expression.MessageExpression
import org.fix4j.test.expression.FlexibleMessageExpressionParser
import org.fix4j.test.util.DateUtils
import quickfix.Group
import quickfix.Message
import quickfix.field.BeginString
import quickfix.field.BodyLength
import quickfix.field.CheckSum
import quickfix.field.MsgSeqNum
import quickfix.field.MsgType
import quickfix.field.NoRelatedSym
import quickfix.field.OrdType
import quickfix.field.OrderQty
import quickfix.field.PartyRole
import quickfix.field.QuoteReqID
import quickfix.field.SenderCompID
import quickfix.field.SendingTime
import quickfix.field.SettlDate
import quickfix.field.SettlDate2
import quickfix.field.Side
import quickfix.field.Symbol
import quickfix.field.TargetCompID
import spock.lang.Specification

/**
 * User: ben
 * Date: 13/10/2014
 * Time: 5:52 AM
 */
class ToQuickFixMessageConverterTest extends Specification {
    private final FixSpecification fixSpecification = FixSpec.INSTANCE;
    private final FlexibleMessageExpressionParser parser = new FlexibleMessageExpressionParser(fixSpecification);

    def "Convert message with repeating group"(){
        given:

        final FixMessage fixMessage = parser.parse(
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
                "      2.[MDUpdateAction]279=0[NEW]\n" +
                "        [MDEntryType]269=1[OFFER]\n" +
                "        [Symbol]55=AUD/USD\n" +
                "        [MDEntryPx]270=1.12355\n" +
                "        [NoPartyIDs]453=2\n" +
                "          1.[PartyID]448=MrMaker\n" +
                "            [PartyRole]452=66[MARKET_MAKER]\n" +
                "          2.[PartyID]448=Exchange\n" +
                "            [PartyRole]452=22[EXCHANGE]\n" +
                "      3.[MDUpdateAction]279=0[NEW]\n" +
                "        [MDEntryType]269=0[BID]\n" +
                "        [Symbol]55=AUD/USD\n" +
                "        [MDEntryPx]270=1.1234\n" +
                "        [NoPartyIDs]453=2\n" +
                "          1.[PartyID]448=MrMaker\n" +
                "            [PartyRole]452=66[MARKET_MAKER]\n" +
                "          2.[PartyID]448=Exchange\n" +
                "            [PartyRole]452=22[EXCHANGE]\n" +
                "      4.[MDUpdateAction]279=0[NEW]\n" +
                "        [MDEntryType]269=1[OFFER]\n" +
                "        [Symbol]55=AUD/USD\n" +
                "        [MDEntryPx]270=1.1236\n" +
                "          1.[PartyID]448=MrMaker\n" +
                "            [PartyRole]452=66[MARKET_MAKER]\n" +
                "          2.[PartyID]448=Exchange\n" +
                "            [PartyRole]452=22[EXCHANGE]"
        ).asMessage(fixSpecification);


        final ToQuickFixMessageConverter toQuickFixMessageConverter = new ToQuickFixMessageConverter(fixSpecification);
        final Message quickfixMessage = toQuickFixMessageConverter.convert(fixMessage);

        final FromQuickFixMessageConverter fromQuickFixMessageConverter = new FromQuickFixMessageConverter(fixSpecification);
        final FixMessage convertedBackFixMessage = fromQuickFixMessageConverter.convert(quickfixMessage);
        println convertedBackFixMessage.toPrettyString();

        assert fixMessage == convertedBackFixMessage;
    }


    def "Convert flat message (no groups)"() {
        given:
        final MessageExpression expression = parser.parse("\
                [BeginString]8=FIX.4.4|\
                [BodyLength]9=101|\
                [MsgType]35=R[QUOTEREQUEST]|\
                [MsgSeqNum]34=85|\
                [TargetCompID]56=COBAFX|\
                [SenderCompID]49=FIXLDN1Q|\
                [SendingTime]52=20120307-09:59:56|\
                [QuoteReqID]131=ID07095956323|\
                [Side]54=1[BUY]|\
                [OrdType]40=G[FOREX_SWAP]|\
                [SettlDate]64=1W|\
                [SettlDate2]193=1M|\
                [NoRelatedSym]146=2|\
                    [Symbol]55=EUR/USD|\
                    [OrderQty]38=1000000|\
                    [Currency]15=EUR|\
                    [Symbol]55=GBP/USD|\
                    [OrderQty]38=666|\
                    [Currency]15=GBP|\
                [CheckSum]10=234|");
        final FixMessage fixMessage = expression.asMessage(fixSpecification);
        final ToQuickFixMessageConverter converter = new ToQuickFixMessageConverter(fixSpecification);
        final Message message = converter.convert(fixMessage);

        expect:
        final Message.Header header = message.getHeader();
        final Message.Trailer trailer = message.getTrailer();

        assert header.getString(BeginString.FIELD) == "FIX.4.4";
        assert header.getInt(BodyLength.FIELD) != null;
        assert header.getString(MsgType.FIELD) == "R";
        assert header.getInt(MsgSeqNum.FIELD) == 85;
        assert header.getString(TargetCompID.FIELD) == "COBAFX";
        assert header.getString(SenderCompID.FIELD) == "FIXLDN1Q";
        assert header.getUtcTimeStamp(SendingTime.FIELD) == DateUtils.parseUtcTimestamp("20120307-09:59:56");
        assert message.getString(QuoteReqID.FIELD) == "ID07095956323";
        assert message.getString(Side.FIELD) == "1";
        assert message.getString(OrdType.FIELD) == "G";
        assert message.getString(SettlDate.FIELD) == "1W";
        assert message.getString(SettlDate2.FIELD) == "1M";

        assert message.getGroupCount(NoRelatedSym.FIELD) == 2
        Group relatedSym1 = message.getGroup(1, NoRelatedSym.FIELD);
        assert relatedSym1.getString(Symbol.FIELD) == "EUR/USD";
        assert relatedSym1.getString(OrderQty.FIELD) == "1000000";
        assert relatedSym1.getString(quickfix.field.Currency.FIELD) == "EUR";

        Group relatedSym2 = message.getGroup(2, NoRelatedSym.FIELD);
        assert relatedSym2.getString(Symbol.FIELD) == "GBP/USD";
        assert relatedSym2.getString(OrderQty.FIELD) == "666";
        assert relatedSym2.getString(quickfix.field.Currency.FIELD) == "GBP";

        assert trailer.getString(CheckSum.FIELD) != null;
    }
}
