package org.fix4j.test.session;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.plumbing.Supplier;

/**
* User: ben
* Date: 24/11/14
* Time: 5:11 PM
*/
public class SessionConnectors {
    public final Supplier<FixMessage> inboundSupplier;
    public final Consumer<FixMessage> outboundConsumer;

    public SessionConnectors(final Supplier<FixMessage> inboundSupplier, final Consumer<FixMessage> outboundConsumer) {
        this.inboundSupplier = inboundSupplier;
        this.outboundConsumer = outboundConsumer;
    }
}
