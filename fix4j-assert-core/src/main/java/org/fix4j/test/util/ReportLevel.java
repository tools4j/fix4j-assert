package org.fix4j.test.util;

/**
 * User: ben
 * Date: 19/11/14
 * Time: 4:49 PM
 */
public enum ReportLevel {
    FAIL(3), WARN(2), INFO(1), EMPTY(0);

    private final int index;

    private ReportLevel(final int index) {
        this.index = index;
    }

    public static ReportLevel getLowestLevel() {
        return EMPTY;
    }

    public boolean isAtLeast(final ReportLevel reportLevel){
        return this.index >= reportLevel.index;
    }

    public static ReportLevel highestOf(final ReportLevel ... levels) {
        ReportLevel highest = null;
        for (final ReportLevel level : levels) {
            if(highest == null || level.index > highest.index){
                highest = level;
            }
        }
        return highest;
    }

    public boolean isFail() {
        return this == FAIL;
    }
}
