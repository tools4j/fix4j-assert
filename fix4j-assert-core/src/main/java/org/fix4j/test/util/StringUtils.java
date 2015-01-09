package org.fix4j.test.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: ben
 * Date: 25/08/2014
 * Time: 6:11 AM
 */
public class StringUtils {
    //Replace all start of lines (which are not immediately followed by an end-of-line), with an INDENT
    private static final Pattern indentRegex = Pattern.compile("(?m)^(?!$)");

    private StringUtils() {}


    // pad with String s to the right to the given length (n)
    public static String padRight(String s, int n) {
        Asserts.assertNotNull("Given string cannot be null", s);
        if(n <= s.length()) return s;
        else return String.format("%1$-" + n + "s", s);
    }

    // pad with String s to the left to the given length (n)
    public static String padLeft(String s, int n) {
        Asserts.assertNotNull("Given string cannot be null", s);
        if(n <= s.length()) return s;
        else return String.format("%1$" + n + "s", s);
    }

    // pad with given char to the right to the given length (n)
    public static String padRight(String s, String pad, int n) {
        Asserts.assertTrue("Given pad String must be of length 1", pad.length() == 1);
        return padRight(s, n).replace(" ", String.valueOf(pad));
    }

    // pad with given char to the left to the given length (n)
    public static String padLeft(String s, String pad, int n) {
        Asserts.assertTrue("Given pad String must be of length 1", pad.length() == 1);
        return padLeft(s, n).replace(" ", String.valueOf(pad));
    }

    /**
     * @param s
     * @param n
     * @return the left hand portion of the given String up to n characters in length.
     * @throws java.lang.IllegalArgumentException if the given String is null. Or
     * if n is negative.
     */
    public static String left(String s, int n) {
        Asserts.assertNotNull("Given String cannot be null. [n=" + n + "]", s);
        Asserts.assertTrue("n must be greater than or equal to zero. [n=" + n + ", s=" + s + "]", n >= 0);
        if(s.length() <= n) return s;
        else return s.substring(0, n);
    }

    /**
     * @param s
     * @param n
     * @return the right hand portion of the given String up to n characters in length.
     * @throws java.lang.IllegalArgumentException if the given String is null. Or
     * if n is negative.
     */
    public static String right(String s, int n) {
        Asserts.assertNotNull("Given String cannot be null. [n=" + n + "]", s);
        Asserts.assertTrue("n must be greater than or equal to zero. [n=" + n + ", s=" + s + "]", n >= 0);

        if(s.length() <= n) return s;
        else return s.substring(s.length() - n);
    }

    public static String niceIfNull(final Object obj, final String strIfNull) {
        if(obj == null) return strIfNull;
        else return obj.toString();
    }

    public static String indentAllLines(final int indentLevel, final String str){
        final String indent = repeat(indentLevel, Consts.INDENT);
        return indentRegex.matcher(str).replaceAll(indent);
    }

    public static String indentAllLines(final String str){
        final String indent = repeat(1, Consts.INDENT);
        return indentRegex.matcher(str).replaceAll(indent);
    }

    public static String indentAllLinesWithFirstLinesIndentEndingIn(final String indentEndingIn, String str){
        final String firstIndent = getIndentEndingIn(indentEndingIn);
        final String subsequentIndents = Consts.INDENT;

        final Matcher matcher = indentRegex.matcher(str);
        StringBuffer sb = new StringBuffer();

        //Find the first line, if no first line, then just return
        if(!matcher.find()){
            return str;
        }

        //Replace the first line with the 'special' first indent
        matcher.appendReplacement(sb, firstIndent);

        //Replace subsequent lines with 'standard' indent.
        while (matcher.find()) {
            matcher.appendReplacement(sb, subsequentIndents);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String repeat(final int times, final String str) {
        final StringBuilder sb = new StringBuilder();
        for(int i=0; i<times; i++){
            sb.append(str);
        }
        return sb.toString();
    }

    public static <V> Map<String, V> prefixAllKeysWith(final String prefix, final Map<String, V> map) {
        final Map<String, V> returnMap = new LinkedHashMap<>();
        for (final String key : map.keySet()) {
            returnMap.put(prefix + key, map.get(key));
        }
        return returnMap;
    }

    public static final Pattern VARIABLE_MATCHER = Pattern.compile("(?<!\\\\)\\$\\{([^}]*)\\}", Pattern.DOTALL | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.MULTILINE);
    public static final Pattern ESCAPED_VARIABLE_MATCHER = Pattern.compile("\\\\(\\$\\{[^}]*\\})", Pattern.DOTALL | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.MULTILINE);

    public static boolean containsAtLeastOneVariable(final String input){
        return VARIABLE_MATCHER.matcher(input).find();
    }

    public static String substituteVariables(final String input, final Map<String,String> variables){
        Matcher m = VARIABLE_MATCHER.matcher(input);
        final StringBuffer output = new StringBuffer();

        //Replace variables
        while(m.find()){
            final String variableName = m.group(1);
            if(variableName == null || variableName.length() == 0){
                continue;
            }
            final String variableValue = variables.get(variableName);
            if(variableValue == null){
                throw new IllegalArgumentException("Cannot find variable: " + variableName + "in variables:" + variables);
            }
            m.appendReplacement(output, variableValue);
        }
        m.appendTail(output);

        //Replace escaped variables
        final String outputWithEscapedVariablesRemoved = ESCAPED_VARIABLE_MATCHER.matcher(output.toString()).replaceAll("$1");
        return outputWithEscapedVariablesRemoved;
    }

    public static String getIndentEndingIn(final String endingIn){
        if(endingIn.length() > Consts.INDENT.length()){
            throw new IllegalArgumentException("Ending in '" + endingIn + "' must not be longer than the actual indent: '" + Consts.INDENT + "'");
        }
        return Consts.INDENT.substring(endingIn.length()) + endingIn;
    }

    public static Map<String, String> parseMap(final String propertiesStr){
        final String[] keyValuePairs = propertiesStr.split(",");
        final Map<String, String> map = new LinkedHashMap<>();
        for (final String keyValuePair : keyValuePairs) {
            final String[] keyValue = keyValuePair.trim().split(":");
            map.put(keyValue[0].trim(), keyValue[1].trim());
        }
        return map;
    }

    public static Map<String, String> listToMap(final String ... strings) {
        final Map<String, String> map = new LinkedHashMap<>();
        final Iterator<String> stringIterator = Arrays.asList(strings).iterator();

        while(stringIterator.hasNext()){
            final String key = stringIterator.next();
            final String value = stringIterator.next();
            map.put(key, value);
        }
        return map;
    }
}
