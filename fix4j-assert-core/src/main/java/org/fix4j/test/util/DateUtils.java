package org.fix4j.test.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * User: ben
 * Date: 25/09/2014
 * Time: 5:59 AM
 */
public class DateUtils {
    private DateUtils() {}

    private final static List<DateFormat> timestampFormatsInLocalTz;
    private final static List<DateFormat> timestampFormatsInUtc;
    private final static List<DateFormat> dateFormatsInLocalTz;

    public static final TimeZone UTC = TimeZone.getTimeZone("UTC");

    static{
        /*
        Add the various date and timestamp formats here that we wish to 'support'
        */
        final List<String> timestampFormatStrings = new ArrayList<>();
        timestampFormatStrings.add("yyyyMMdd-HH:mm:ss");

        final List<String> dateFormatStrings = new ArrayList<>();
        dateFormatStrings.add("yyyyMMdd");

        final List<DateFormat> _timestampFormatsInLocalTz = new ArrayList<>();
        final List<DateFormat> _dateFormatsInLocalTz = new ArrayList<>();
        final List<DateFormat> _timestampFormatsInUtc = new ArrayList<>();
        final List<DateFormat> _dateFormatsInUtc = new ArrayList<>();

        for (final String dateFormatString : dateFormatStrings) {
            _dateFormatsInLocalTz.add(new SimpleDateFormat(dateFormatString));
            final SimpleDateFormat sdf = new SimpleDateFormat(dateFormatString);
            sdf.setTimeZone(UTC);
            _dateFormatsInUtc.add(sdf);
        }

        for (final String _timestampFormatString : timestampFormatStrings) {
            _timestampFormatsInLocalTz.add(new SimpleDateFormat(_timestampFormatString));
            final SimpleDateFormat sdf = new SimpleDateFormat(_timestampFormatString);
            sdf.setTimeZone(UTC);
            _timestampFormatsInUtc.add(sdf);
        }

        timestampFormatsInLocalTz = Collections.unmodifiableList(_timestampFormatsInLocalTz);
        timestampFormatsInUtc = Collections.unmodifiableList(_timestampFormatsInUtc);
        dateFormatsInLocalTz = Collections.unmodifiableList(_dateFormatsInLocalTz);
    }

    public static Date parseTimestamp(final String value) {
        for(final DateFormat timestampFormat: timestampFormatsInLocalTz){
            try{
                return timestampFormat.parse(value);
            } catch(Exception e) {
                //nothing
            }
        }
        throw new IllegalArgumentException("Could not convert timestamp: " + value);
    }

    public static LocalDateTime parseUtcTimestamp(final String value) {
        for(final DateFormat timestampFormat: timestampFormatsInUtc){
            try{
                Date date = timestampFormat.parse(value);
                return LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC"));
            } catch(Exception e) {
                //nothing
            }
        }
        throw new IllegalArgumentException("Could not convert timestamp: " + value);
    }

    public static LocalDate parseDate(final String value) {
        for(final DateFormat dateFormat: dateFormatsInLocalTz){
            try{
                Date date = dateFormat.parse(value);
                return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            } catch(Exception e) {
                //nothing
            }
        }
        throw new IllegalArgumentException("Could not convert date: " + value);
    }

    public static long now() {
        return new Date().getTime();
    }

    public static long timeSince(final long pastTime) {
        return now() - pastTime;
    }
}
