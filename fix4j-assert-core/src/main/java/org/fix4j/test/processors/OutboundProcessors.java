package org.fix4j.test.processors;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.plumbing.AbstractChainedConsumer;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.plumbing.Processor;
import org.fix4j.test.util.Report;

import java.util.List;

/**
 * User: ben
 * Date: 22/11/14
 * Time: 5:00 AM
 */
public class OutboundProcessors extends AbstractChainedConsumer<FixMessage> implements OnFailureReporter {
    private final FixMessageProcessors processors;

    public OutboundProcessors(final Consumer<FixMessage> source, final List<Processor<FixMessage>> processors) {
        super(source);
        this.processors = new FixMessageProcessors(processors);
    }

    @SafeVarargs
    public OutboundProcessors(final Consumer<FixMessage> source, final Processor<FixMessage> ... processors) {
        super(source);
        this.processors = new FixMessageProcessors(processors);
    }

    @Override
    public FixMessage process(final FixMessage entity) {
        return processors.process(entity);
    }

    @Override
    public Report getReportOnFailure() {
        return processors.getReportOnFailure();
    }
}
