package org.fix4j.test.fixmodel;

import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.properties.PropertyKeysAndDefaultValues;
import org.fix4j.test.util.Consts;

/**
 * User: ben
 * Date: 31/10/2014
 * Time: 7:49 PM
 */
public class PrettyStripper {

    public static String stripPrettiness(final String prettyMessage) {
        final String fixDelim = ApplicationProperties.Singleton.instance().getAsString(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM);

        String str = prettyMessage.replaceAll("(?s)" + BaseFixMessage.BANNER_STR + ".*" + BaseFixMessage.BANNER_STR, "");
        str = str.replaceAll("(?m)^\\s*" + BaseFixMessage.PRETTY_HEADER_TITLE + "\\s*$", "");
        str = str.replaceAll("(?m)^\\s*" + BaseFixMessage.PRETTY_BODY_TITLE + "\\s*$", "");
        str = str.replaceAll("(?m)^\\s*" + BaseFixMessage.PRETTY_TRAILER_TITLE + "\\s*$", "");

        //Strip space from start of string
        str = str.replaceAll("(?m)^\\s+", "");

        //Strip space from start of field after delimiter
        str = str.replaceAll("(?m)" + fixDelim + "\\s+", Consts.FIX_FIELD_DISPLAY_DELIM);

        //Strip space from end of string (not including carriage returns)
        str = str.replaceAll("(?m)[\\t ]+$", "");

        //Strip space from end of field up to next delimiter
        str = str.replaceAll("(?m)[\\t ]+" + fixDelim, Consts.FIX_FIELD_DISPLAY_DELIM);

        //Strip group repeat prefixes (lines starting with digits then a dot
        str = str.replaceAll("(?m)^\\d+\\.\\s*", "");

        //Strip group repeat prefixes (fields starting with digits then a dot
        str = str.replaceAll("(?m)" + fixDelim + "\\d+\\.\\s*", Consts.FIX_FIELD_DISPLAY_DELIM);

        //Replace any remaining fix delims
        str = str.replaceAll("(?m)" + fixDelim, Consts.FIX_FIELD_DISPLAY_DELIM);

        //Strip line feeds
        str = str.replaceAll("\\r", "");

        //Strip lines containing just whitespace
        str = str.replaceAll("(?m)^\\s+$\\n", "");

        //String empty lines
        str = str.replaceAll("\\n\\1+", "\\n");

        //Replace all carriage returns with a delimiter
        str = str.replaceAll("\\n", Consts.FIX_FIELD_DISPLAY_DELIM);

        //Strip off delimiter at end of string if there is one
        str = str.replaceAll("(?m)" + Consts.FIX_FIELD_DISPLAY_DELIM_REGEX + "$", "");

        return str;
    }
}
