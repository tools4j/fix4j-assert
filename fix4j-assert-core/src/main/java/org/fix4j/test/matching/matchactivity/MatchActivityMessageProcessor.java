package org.fix4j.test.matching.matchactivity;

import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.util.Report;

/**
 * User: ben
 * Date: 5/11/2014
 * Time: 5:10 PM
 */
public interface MatchActivityMessageProcessor {
    MatchActivityDirectiveAndReport processMessage(FixMessage message);
    Report handleTimeout();
}
