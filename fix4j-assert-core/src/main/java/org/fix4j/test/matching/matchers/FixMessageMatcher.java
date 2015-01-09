package org.fix4j.test.matching.matchers;

import org.fix4j.test.fixmodel.FixMessage;

/**
 * User: ben
 * Date: 29/09/2014
 * Time: 5:46 AM
 */
public interface FixMessageMatcher {
    MatchResult getMatchResult(FixMessage message);
}
