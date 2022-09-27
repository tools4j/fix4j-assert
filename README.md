[![Build Status](https://travis-ci.org/tools4j/fix4j-assert.svg?branch=master)](https://travis-ci.org/tools4j/fix4j-assert)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.fix4j/fix4j-assert-all/badge.svg)](https://search.maven.org/search?q=a:fix4j-assert-all)

# fix4j-assert 
fix4j-assert is a library to assist in testing of applications using FIX protocol.

It's written in Java and is designed to be used along side your test frameworks of choice.  e.g. JUnit, Spock, TestNG

Contact: [fix4j.assert@gmail.com](mailto:fix4j.assert@gmail.com)

Table of Contents
=================
* [Using fix4j-assert in your project](#using-fix4j-assert-in-your-project)
* [Sending a fix message to your application](#sending-a-fix-message-to-your-application)
* [Receiving a fix message from your application](#receiving-a-fix-message-from-your-application)
* [Quickstart/Example](#quickstartexample)
* [Using more descriptive message formats](#using-more-descriptive-message-formats)
* [Debugging your tests](#debugging-your-tests)
* [Project Structure](#project-structure)
* [How to use fix4j-assert modules](#how-to-use-fix4j-assert-modules)
  * [Is your application compatible with FIX 5.0 SP2?](#is-your-application-compatible-with-fix-50-sp2)
  * [Is your application compatible with a QuickFix peer?](#is-your-application-compatible-with-a-quickfix-peer)


## Using fix4j-assert in your project
via maven:
```
        <dependency>
            <groupId>org.fix4j</groupId>
            <artifactId>fix4j-assert-all</artifactId>
            <version>1.6</version>
            <scope>test</scope>
        </dependency>
```
via gradle:
```
        testCompile group: 'org.fix4j', name: 'fix4j-assert-all', version:'1.6'
```
## Sending a fix message to your application
The example below shows how to send fix messages to your application using fix4j-assert:

```java
session.send("35=V|262=AASDJKG790|263=0|264=20|267=2|269=0|269=1|146=3|55=GBP/USD|64=SP|55=AUD/USD|64=SP|55=USD/JPY|64=SP|");
```

## Receiving a fix message from your application
In the example below, ```expect``` will throw an ```AssertionError``` if the next message to arrive does not match the given pattern.  Note, the regular expression to match the requestId. Regular expressions begin and end in forward slashes.

```java
session.expect("35=X|262=/AASDJKG\d+/);
```

## Quickstart/Example
[See here for an example showing the sending and receiving of FIX messages.](https://github.com/fix4j/fix4j-assert/blob/master/fix4j-assert-examples/src/test/java/org/fix4j/test/examples/clients/MatchingSessionTest.java).

## Using more descriptive message formats
You may have noticed that the format for sending a message and matching an incoming message is quite similar.  They actually use the same underlying code base.  fix4j-assert provides more descriptive message formats to make our tests more readable.  

Below example with descriptors mixed in with fix tags and values:
```java
session.send("[MsgType]35=V[MARKETDATAREQUEST]|" +
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
```
This example has some extra syntax next to group repeats:
```java
session.expect("[MsgType]35=V[MARKETDATAREQUEST]|" +
               "[MDReqID]262=AASDJKG790|\n" +
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
 ```
For a more old school approach, you can use straight up ascii 0x0001 delimiters:
```java
session.send("35=V\u0001262=AASDJKG790\u0001263=0\u0001264=20\u0001267=2\u0001269=0\u0001269=1\u0001146=3\u000155=GBP/USD\u000164=SP\u000155=AUD/USD\u000164=SP\u000155=USD/JPY\u000164=SP");
```

Or Ctrl-A delimiters:
```java
session.send("35=V^A262=AASDJKG790^A263=0^A264=20^A267=2^A269=0^A269=1^A146=3^A55=GBP/USD^A64=SP^A55=AUD/USD^A64=SP^A55=USD/JPY^A64=SP");
```
[See here for an example showing the usage of various message formats.](https://github.com/fix4j/fix4j-assert/blob/master/fix4j-assert-examples/src/test/java/org/fix4j/test/examples/clients/VariousMessageFormatsTest.java).

## Debugging your tests
Debugging fix applications can often be difficult, given the asynchronous nature of the messaging combined with the obscure format of fix.
fix4j-assert attempts to address this issue by providing detailed error messages when a test fails.  In the example below, we were expecting a MarketDataRequest with one of the symbols being GBP/XXX.
```
FAILURE: FIX.4.4:SERVER_COMP_ID->CLIENT_COMP_ID: 
    1. Found message that matches: MsgTypeMatcher{expectedMsgType=V[MarketDataRequest]}
    2. But message does not match: [MDReqID]262=AASDJKG790|[SubscriptionRequestType]263=0[SNAPSHOT]|[NoRelatedSym]146=3|[Symbol]55=GBP/XXX|[Symbol]55=AUD/USD|[Symbol]55=USD/JPY|
    MATCH DETAILS::
        OK   [MDReqID]262: AASDJKG790 == AASDJKG790
        OK   [SubscriptionRequestType]263: 0[SNAPSHOT] == 0[SNAPSHOT]
        OK   [NoRelatedSym]146: 3 == 3
        FAIL [Symbol]55: GBP/USD != GBP/XXX
        OK   [Symbol]55: AUD/USD == AUD/USD
        OK   [Symbol]55: USD/JPY == USD/JPY
    MESSAGE RECEIVED::
        ------------------------------------------------------
        MarketDataRequest
        ------------------------------------------------------
        Header
            [BeginString]8=FIX.4.4
            [BodyLength]9=156
            [MsgSeqNum]34=2
            [MsgType]35=V[MARKETDATAREQUEST]
            [SenderCompID]49=CLIENT_COMP_ID
            [SendingTime]52=20141222-22:28:57.286
            [TargetCompID]56=SERVER_COMP_ID
        Body
            [MDReqID]262=AASDJKG790
            [SubscriptionRequestType]263=0[SNAPSHOT]
            [MarketDepth]264=20
            [NoRelatedSym]146=3
              1.[Symbol]55=GBP/USD
              2.[Symbol]55=AUD/USD
              3.[Symbol]55=USD/JPY
            [NoMDEntryTypes]267=2
              1.[MDEntryType]269=0[BID]
              2.[MDEntryType]269=1[OFFER]
        Trailer
            [CheckSum]10=156
RECENT INBOUND MESSAGES
    1. [BeginString]8=FIX.4.4|[BodyLength]9=83|[MsgSeqNum]34=1|[MsgType]35=A[LOGON]|[SenderCompID]49=CLIENT_COMP_ID|[SendingTime]52=20141222-22:28:57.230|[TargetCompID]56=SERVER_COMP_ID|[EncryptMethod]98=0[NONE__OTHER]|[HeartBtInt]108=10|[CheckSum]10=134|
    2. [BeginString]8=FIX.4.4|[BodyLength]9=156|[MsgSeqNum]34=2|[MsgType]35=V[MARKETDATAREQUEST]|[SenderCompID]49=CLIENT_COMP_ID|[SendingTime]52=20141222-22:28:57.286|[TargetCompID]56=SERVER_COMP_ID|[MDReqID]262=AASDJKG790|[SubscriptionRequestType]263=0[SNAPSHOT]|[MarketDepth]264=20|[NoRelatedSym]146=3|[Symbol]55=GBP/USD|[Symbol]55=AUD/USD|[Symbol]55=USD/JPY|[NoMDEntryTypes]267=2|[MDEntryType]269=0[BID]|[MDEntryType]269=1[OFFER]|[CheckSum]10=156|
RECENT OUTBOUND MESSAGES
    1. [MsgType]35=X[MARKETDATAINCREMENTALREFRESH]|[MDReqID]262=requestABCD|[NoMDEntries]268=4|[MDUpdateAction]279=0[NEW]|[MDEntryType]269=0[BID]|[Symbol]55=AUD/USD|[MDEntryPx]270=1.12345|[MDUpdateAction]279=0[NEW]|[MDEntryType]269=1[OFFER]|[Symbol]55=AUD/USD|[MDEntryPx]270=1.12355|[MDUpdateAction]279=0[NEW]|[MDEntryType]269=0[BID]|[Symbol]55=AUD/USD|[MDEntryPx]270=1.12335|[MDUpdateAction]279=0[NEW]|[MDEntryType]269=1[OFFER]|[Symbol]55=AUD/USD|[MDEntryPx]270=1.12365|
    2. [MsgType]35=8[EXECUTIONREPORT]|[Symbol]55=CVS|[OrderID]37=ORD10001/03232009|[ClOrdID]11=ORD10001|[ExecID]17=12345678|[ExecType]150=2|[OrdStatus]39=2[FILLED]|[Side]54=1[BUY]|[OrderQty]38=1000|[OrdType]40=1[MARKET]|[TimeInForce]59=1[GOOD_TILL_CANCEL_GTC]|[LastPx]31=1.12355|[LastQty]32=1000|[CumQty]14=0|[AvgPx]6=0|[LeavesQty]151=0|[TransactTime]60=20070123-19:01:17|[Text]58=Fill|[LastMkt]30=N|[SecurityExchange]207=N|[SettlType]63=0[REGULAR__FX_SPOT_SETTLEMENT_T1_OR_T2_DEPENDING_ON_CURRENCY]|
```

## Project Structure

module | description
:------|:-----------------------------------
fix4j-assert-core | Contains the core fix4j-assert code
fix4j-assert-all | Include this artifact if you wish to use the 'default' fix4j-assert setup (QuickFix4j engine with FIX-5.0SP2)
fix4j-assert-examples | Examples to browse at your lesuire.
fix4j-assert-acceptance | Acceptance tests.  These tests will attempt to bind to ports on the test machine.
fix4j-assert-integration | Integration tests. Will not attempt to listen to any ports on the test machine.
fix4j-assert-quickfix | Provides the QuickFix integration for fix4j-assert.
fix4j-assert-codegen | Generates fix4j-assert FIX spec code from FIX xml specs/data-dictionaries.
fix4j-assert-fixspec-50sp2 | fix4j-assert FIX spec code for the FIX-5.0SP2 data-dictionary.
fix4j-assert-testcommon | Common library that fix4j-assert's own tests use.  (You don't need to include this directly
