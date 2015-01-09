package org.fix4j.test.acceptance;

import org.fix4j.spec.fix50sp2.MsgTypes;
import org.fix4j.test.DefaultContextFactory;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.session.BlockingSession;
import org.fix4j.test.session.FixConnectionMode;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.session.TestSessionHelper;
import org.junit.AfterClass
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test
import spock.lang.Specification;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.fail;

/**
 * User: ben
 * Date: 13/08/2014
 * Time: 8:57 PM
 */
public class BlockingSessionTimeoutTest extends Specification{
    private static BlockingSession server;
    private static BlockingSession client;

    public void setup() throws InterruptedException {
        final TestSessionHelper helper = new TestSessionHelper(new DefaultContextFactory());
        server = helper.createBlockingSession(new FixSessionId("FIX.4.4", "SERVER_COMP_ID", "CLIENT_COMP_ID"), FixConnectionMode.ACCEPTOR);
        client = helper.createBlockingSession(new FixSessionId("FIX.4.4", "CLIENT_COMP_ID", "SERVER_COMP_ID"), FixConnectionMode.INITIATOR);

        //Consume up the logon messages
        while(!client.getNextMessage().getTypeOfMessage().equals(MsgTypes.Logon));
        while(!server.getNextMessage().getTypeOfMessage().equals(MsgTypes.Logon));
    }

    public void cleanup() throws InterruptedException {
        client.shutdown();
        server.shutdown();
    }

    public void testServerDoesNotTimeOut() {
        expect:
        final AtomicReference<FixMessage> fixMessageHolder = new AtomicReference<>();

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                fixMessageHolder.set(server.getNextMessage());
            }
        });
        Thread.sleep(3000);
        assert fixMessageHolder.get() == null;
        thread.interrupt();
    }

    public void testClientDoesNotTimeOut() throws InterruptedException {
        expect:
        final AtomicReference<FixMessage> fixMessageHolder = new AtomicReference<>();

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                fixMessageHolder.set(client.getNextMessage());
            }
        });
        Thread.sleep(3000);
        assert fixMessageHolder.get() == null;
        thread.interrupt();
    }
}
