package org.fix4j.test.util

import spock.lang.Specification

import java.text.SimpleDateFormat

/**
 * User: ben
 * Date: 25/09/2014
 * Time: 6:03 AM
 */
class DateUtilsTest extends Specification {
    def "test parseTimestampWithLocalTimezone"() {
        when:
        final Date date = DateUtils.parseTimestamp("20070123-19:01:17");

        then:
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HH:mm:ssZ");
        assert dateFormat.format(date) == "20070123-19:01:17" + getCurrentTimezoneOffsetAtDate(date);
    }

    public static String getCurrentTimezoneOffsetAtDate(final Date date) {
        TimeZone tz = TimeZone.getDefault();
        Calendar cal = GregorianCalendar.getInstance(tz);
        double offsetInMillis = tz.getOffset(date.getTime());
        double offsetInMinutes = (offsetInMillis / 60000);
        double minutesRemainder = offsetInMinutes % 60.0

        int offsetInHours = Math.abs(offsetInMillis / 3600000.0)
        int offsetInMinutesUnderAnHour = Math.abs(minutesRemainder)

        String offset = String.format('%02d%02d', offsetInHours, offsetInMinutesUnderAnHour);
        offset = (offsetInMillis >= 0 ? "+" : "-") + offset;
        return offset;
    }
}
