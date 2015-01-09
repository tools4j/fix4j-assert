package org.fix4j.test.matching.matchers;

import org.fix4j.test.util.Report;

/**
 * User: ben
 * Date: 20/11/14
 * Time: 9:24 AM
 */
public interface MatchResult extends Report {
    public boolean matches();
}
