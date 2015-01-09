package org.fix4j.test.matching;

import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.Report;
import org.fix4j.test.util.StringUtils;

/**
* User: ben
* Date: 19/08/2014
* Time: 5:30 PM
*/
public class FixFieldMatchResult implements Report {
    private final boolean matches;
    private final FieldType type;
    private final String actualValue;
    private final String expectedExpression;

    public FixFieldMatchResult(final boolean matches, final FieldType type, final String actualValue, final String expectedExpression) {
        this.matches = matches;
        this.type = type;
        this.actualValue = actualValue;
        this.expectedExpression = expectedExpression;
    }

    public boolean matches() {
        return matches;
    }

    @Override
    public String getReportAsString() {
        final String actual = type.formatValue(actualValue);
        final String expected = type.formatValue(expectedExpression);
        return (matches ? "OK   " : "FAIL ")
                + StringUtils.niceIfNull(type + ": " + actual, "<not given>")
                + (matches ? " == " : " != ")
                + StringUtils.niceIfNull(expected, "<not given>")
                + Consts.EOL;
    }
}
