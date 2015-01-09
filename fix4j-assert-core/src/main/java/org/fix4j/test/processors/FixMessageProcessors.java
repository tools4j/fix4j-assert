package org.fix4j.test.processors;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.plumbing.Processor;
import org.fix4j.test.util.CompositeReport;
import org.fix4j.test.util.Report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: ben
 * Date: 1/12/14
 * Time: 4:46 PM
 */
public class FixMessageProcessors implements Processor<FixMessage>, OnFailureReporter {
    private final List<Processor<FixMessage>> processors;

    public FixMessageProcessors(final List<Processor<FixMessage>> processors) {
        this.processors = processors;
    }

    public FixMessageProcessors(final Processor<FixMessage> ... processors) {
        this.processors = Arrays.asList(processors);
    }

    @Override
    public FixMessage process(final FixMessage entity) {
        FixMessage returnMessage = entity;
        for (final Processor<FixMessage> processor : processors) {
            returnMessage = processor.process(returnMessage);
            if(returnMessage == null){
                return null;
            }
        }
        return returnMessage;
    }

    @Override
    public Report getReportOnFailure() {
        final List<Report> reports = new ArrayList<>();
        for (final Processor<FixMessage> processor : processors) {
            if(processor instanceof OnFailureReporter){
                reports.add(((OnFailureReporter) processor).getReportOnFailure());
            }
        }
        return new CompositeReport(reports);
    }
}
