package org.fix4j.test;

/**
 * User: ben
 * Date: 19/12/14
 * Time: 5:06 AM
 */
public class TestMessages {
    public static final String EXECUTION_REPORT = 
        "[MsgType]35=8[EXECUTIONREPORT]|" +
        "[Symbol]55=CVS|" +
        "[OrderID]37=ORD10001/03232009|" +
        "[ClOrdID]11=ORD10001|" +
        "[ExecID]17=12345678|" +
        "[ExecType]150=2|" +
        "[OrdStatus]39=2[FILLED]|" +
        "[Side]54=1[BUY]|" +
        "[OrderQty]38=1000|" +
        "[OrdType]40=1[MARKET]|" +
        "[TimeInForce]59=1[GOOD_TILL_CANCEL_GTC]|" +
        "[LastPx]31=1.12355|" +
        "[LastQty]32=1000|" +
        "[CumQty]14=0|" +
        "[AvgPx]6=0|" +
        "[LeavesQty]151=0|" +
        "[TransactTime]60=20070123-19:01:17|" +
        "[Text]58=Fill|" +
        "[LastMkt]30=N|" +
        "[SecurityExchange]207=N|" +
        "[SettlType]63=0[REGULAR__FX_SPOT_SETTLEMENT_T1_OR_T2_DEPENDING_ON_CURRENCY]";

    
    public final static String MARKET_DATA_REQUEST_1 =
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

    public final static String MARKET_DATA_REQUEST_2 =
        "[MsgType]35=V[MARKETDATAREQUEST]|" +
        "[MDReqID]262=AASDJKG799|" +
        "[SubscriptionRequestType]263=0[SNAPSHOT]|" +
        "[MarketDepth]264=20|" +
        "[NoMDEntryTypes]267=2|" +
            "[MDEntryType]269=0[BID]|" +
            "[MDEntryType]269=1[OFFER]|" +
        "[NoRelatedSym]146=2|" +
            "[Symbol]55=AUD/GBP|" +
            "[Symbol]55=AUD/USD|";

    public final static String NEW_ORDER_SINGLE =
        "[MsgType]35=D[NEWORDERSINGLE]|" +
        "[OrderQty]38=1000|" +
        "[TimeInForce]59=1[GOOD_TILL_CANCEL_GTC]|" +
        "[ExDestination]100=N|" +
        "[OrdType]40=1[MARKET]|" +
        "[ClOrdID]11=ORD10001|" +
        "[TransactTime]60=20070123-19:01:17|" +
        "[Symbol]55=HPQ|" +
        "[Side]54=1[BUY]|" +
        "[HandlInst]21=2[AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK]|";

    public final static String MARKET_DATA_INCREMENTAL_REFRESH =
        "[MsgType]35=X[MARKETDATAINCREMENTALREFRESH]|" +
        "[MDReqID]262=requestABCD|" +
        "[NoMDEntries]268=4|" +
            "[MDUpdateAction]279=0[NEW]|" +
            "[MDEntryType]269=0[BID]|" +
            "[Symbol]55=AUD/USD|" +
            "[MDEntryPx]270=1.12345|" +
            "[MDUpdateAction]279=0[NEW]|" +
            "[MDEntryType]269=1[OFFER]|" +
            "[Symbol]55=AUD/USD|" +
            "[MDEntryPx]270=1.12355|" +
            "[MDUpdateAction]279=0[NEW]|" +
            "[MDEntryType]269=0[BID]|" +
            "[Symbol]55=AUD/USD|" +
            "[MDEntryPx]270=1.12335|" +
            "[MDUpdateAction]279=0[NEW]|" +
            "[MDEntryType]269=1[OFFER]|" +
            "[Symbol]55=AUD/USD|" +
            "[MDEntryPx]270=1.12365|";
}
