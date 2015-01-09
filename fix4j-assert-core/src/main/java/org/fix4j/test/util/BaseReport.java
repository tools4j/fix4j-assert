package org.fix4j.test.util;

/**
 * User: ben
 * Date: 19/11/14
 * Time: 4:41 PM
 */
public class BaseReport implements Report {
    private final String content;

    public BaseReport(final String content) {
        this.content = content;
    }

    public String getReportAsString(){
        if(content != null && content.length() > 0){
            return StringUtils.indentAllLines(content) + Consts.EOL;
        } else {
            return "";
        }
    }
}
