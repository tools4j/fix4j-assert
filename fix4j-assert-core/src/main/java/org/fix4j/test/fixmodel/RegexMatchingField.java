package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.Tag;
import org.fix4j.test.util.Consts;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * User: ben
 * Date: 2/09/2014
 * Time: 4:51 PM
 */
public class RegexMatchingField extends Field {
    private Pattern cachedPattern;

    public RegexMatchingField(final FieldType fieldType, final String regex) {
        super(fieldType, regex);
        if(!containsRegexForwardSlashes(regex)){
            throw new IllegalArgumentException("regex must begin and end with forward slashes.  e.g. /.*/");
        }
    }

    public static String unescapeRegexForwardSlashes(final String value){
        if(!containsEscapedRegexForwardSlashes(value)) return value;
        else return value.replaceAll("\\\\/", "/");
    }

    public static boolean containsRegexForwardSlashes(final String value){
        return value != null && value.startsWith("/") && value.endsWith("/");
    }

    public static boolean containsEscapedRegexForwardSlashes(final String value){
        return value != null && value.startsWith("\\/") && value.endsWith("\\/");
    }

    public static String removeRegexForwardSlashes(final String value){
        if(!containsRegexForwardSlashes(value)){
            throw new IllegalArgumentException("Value is not a regex!  Regex must start and end with a foward slash '/'.  e.g. /.*/  Actual value:" + value);
        }
        return value.substring(1,value.length() - 1);
    }

    @Override
    public boolean matchesValueOf(final Field actual) {
        //If both values are null or zero length
        if(this.getValue() == null && actual.getValue() == null){
            return true;

            //If only one of the values is null or zero length
        } else if(this.getValue() == null || actual.getValue() == null) {
            return false;

        } else {
            if(cachedPattern == null){
                final String regexStr = removeRegexForwardSlashes(getValue());
                cachedPattern = Pattern.compile(regexStr);
            }
            return cachedPattern.matcher(actual.getValue()).matches();
        }
    }
}
