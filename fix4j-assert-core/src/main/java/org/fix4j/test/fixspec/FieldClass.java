package org.fix4j.test.fixspec;

/**
 * Descriptions sourced from: http://www.onixs.biz/fix-dictionary/5.0.SP2/index.html
 */
public enum FieldClass {
    /**
     * TZTimestamp - representing a time/date combination representing local time with an offset to UTC to allow identification
     * of local time and timezone offset of that time. The representation is based on ISO 8601.
     * Format is YYYYMMDD-HH:MM:SS[Z | [ + | - hh[:mm]]] where YYYY = 0000 to 9999, MM = 01-12, DD = 01-31 HH = 00-23 hours,
     * MM = 00-59 minutes, SS = 00-59 seconds, hh = 01-12 offset hours, mm = 00-59 offset minutes
     * Example: 20060901-07:39Z is 07:39 UTC on 1st of September 2006 Example: 20060901-02:39-05 is five hours
     * behind UTC, thus Eastern Time on 1st of September 2006 Example: 20060901-15:39+08 is eight hours ahead of UTC,
     * Hong Kong/Singapore time on 1st of September 2006 Example: 20060901-13:09+05:30 is 5.5 hours ahead of UTC,
     * India time on 1st of September 2006
     */
    TZTIMESTAMP("20140727-10:00:00.000"),

    /**
     * Price - value representing a price. Note the number of decimal places may vary. For certain asset classes prices
     * may be negative values. For example, prices for options strategies can be negative under certain market conditions.
     * Refer to Volume 7: FIX Usage by Product for asset classes that support negative price values.
    */
    PRICE("1.2345"),

    /**
     * UTCTimestamp - representing Time/date combination represented in UTC (Universal Time Coordinated, also known
     * as "GMT") in either YYYYMMDD-HH:MM:SS (whole seconds) or YYYYMMDD-HH:MM:SS.sss (milliseconds) format, colons,
     * dash, and period required. Valid values: * YYYY = 0000-9999, MM = 01-12, DD = 01-31, HH = 00-23, MM = 00-59,
     * SS = 00-60 (60 only if UTC leap second) (without milliseconds). * YYYY = 0000-9999, MM = 01-12, DD = 01-31,
     * HH = 00-23, MM = 00-59, SS = 00-60 (60 only if UTC leap second), sss=000-999 (indicating milliseconds).
     * Leap Seconds: Note that UTC includes corrections for leap seconds, which are inserted to account for slowing
     * of the rotation of the earth. Leap second insertion is declared by the International Earth Rotation
     * Service (IERS) and has, since 1972, only occurred on the night of Dec. 31 or Jun 30. The IERS considers
     * March 31 and September 30 as secondary dates for leap second insertion, but has never utilized these dates.
     * During a leap second insertion, a UTCTimestamp field may read "19981231-23:59:59", "19981231-23:59:60",
     * "19990101-00:00:00". (see http://tycho.usno.navy.mil/leapsec.html)
     */
    UTCTIMESTAMP("20140727-10:00:00.000"),

    /**
     * Amt value typically representing a Price times a Qty
     */
    AMT("2000000"),

    /**
     * LocalMktDate - represening a Date of Local Market (vs. UTC) in YYYYMMDD format. This is the "normal"
     * date field used by the FIX protocol. Valid values: YYYY = 0000-9999, MM = 01-12, DD = 01-31.
     */
    LOCALMKTDATE("20140727"),

    /**
     * NumInGroup - value that represents the number of repeating values in a group
     */
    NUMINGROUP("3"),

    /**
     * char value, can include any alphanumeric character or punctuation except the delimiter.
     * All char fields are case sensitive (i.e. m != M).
     */
    CHAR("a"),

    /**
     * UTCDateOnly - Date represented in UTC (Universal Time Coordinated, also known as "GMT")
     * in YYYYMMDD format. This special-purpose field is paired with UTCTimeOnly to form a proper UTCTimestamp
     * for bandwidth-sensitive messages. Valid values: YYYY = 0000-9999, MM = 01-12, DD = 01-31.
     */
    UTCDATEONLY("20140727"),

    /**
     * MultipleCharValue - field containing one or more single character space delimited values.
     */
    MULTIPLECHARVALUE("a b c"),

    /**
     * MultipleStringValue - field containing one or more space delimited values.
     */
    MULTIPLESTRINGVALUE("multiple string value"),

    /**
     * int - Sequence of digits without commas or decimals and optional sign character (ASCII characters "-"
     * and "0" - "9" ). The sign character utilizes one byte (i.e. positive int is "99999" while negative
     * int is "-99999"). Note that int values may contain leading zeros (e.g. "00023" = "23").
     * Examples: 723 in field 21 would be mapped int as |21=723|. -723 in field 12 would be mapped int as |12=-723|
     */
    INT("1234"),

    /**
     * int - Sequence of digits with optional decimal point and sign character (ASCII characters "-", "0" - "9"
     * and "."); the absence of the decimal point within the string will be interpreted as the float representation
     * of an integer value. All float fields must accommodate up to fifteen significant digits. The number of
     * decimal places used should be a factor of business/market needs and mutual agreement between counterparties.
     * Note that float values may contain leading zeros (e.g. "00023.23" = "23.23") and may contain or omit trailing
     * zeros after the decimal point (e.g. "23.0" = "23.0000" = "23" = "23."). Note that fields which are derived
     * from float may contain negative values unless explicitly specified otherwise.
     */
    FLOAT("1234.1234"),

    /**
     * MonthYear 	String field representing month of a year. An optional day of the month can be appended or
     * an optional week code. Valid formats: YYYYMM YYYYMMDD YYYYMMWW YYYY = 0000-9999, MM = 01-12, DD = 01-31,
     * WW = w1, w2, w3, w4, w5.
     */
    MONTHYEAR("201407"),

    /**
     * Qty - value capable of storing either a whole number (no decimal places) of "shares" (securities denominated
     * in whole units) or a decimal value containing decimal places for non-share quantity asset classes (securities
     * denominated in fractional units).
     */
    QTY("11000000"),

    /**
     * Percentage - value representing a percentage (e.g. .05 represents 5% and .9525 represents 95.25%).
     * Note the number of decimal places may vary.
     */
    PERCENTAGE("0.95"),

    /**
     * Length - representing the length in bytes. Value must be positive.
     */
    LENGTH("11"),

    /**
     * PriceOffset - value representing a price offset, which can be mathematically added to a "Price".
     * Note the number of decimal places may vary and some fields such as LastForwardPoints may be negative.
     */
    PRICEOFFSET("600000"),

    /**
     * UTCTimeOnly - Time-only represented in UTC (Universal Time Coordinated, also known as "GMT") in
     * either HH:MM:SS (whole seconds) or HH:MM:SS.sss (milliseconds) format, colons, and period required.
     * This special-purpose field is paired with UTCDateOnly to form a proper UTCTimestamp for bandwidth-sensitive
     * messages.
     * Valid values: HH = 00-23, MM = 00-60 (60 only if UTC leap second), SS = 00-59. (without milliseconds)
     * HH = 00-23, MM = 00-59, SS = 00-60 (60 only if UTC leap second), sss=000-999 (indicating milliseconds).
     */
    UTCTIMEONLY("10:00:00.000"),

    /**
     *  Language - Identifier for a national language - uses ISO 639-1 standard
     */
    LANGUAGE("language"),


    /**
     * char field containing one of two values: 'Y' = True/Yes 'N' = False/No
     */
    BOOLEAN("true"),

    /**
     * string field representing a country using ISO 3166 Country code (2 character) values (see Appendix 6-B).
     */
    COUNTRY("Australia"),

    /**
     * string field representing the time represented based on ISO 8601. This is the time with a UTC offset to allow identification of local time and timezone of that time.
     * Format is HH:MM[:SS][Z | [ + | - hh[:mm]]] where HH = 00-23 hours, MM = 00-59 minutes, SS = 00-59 seconds, hh = 01-12 offset hours, mm = 00-59 offset minutes.
     * Example: 07:39Z is 07:39 UTC
     * Example: 02:39-05 is five hours behind UTC, thus Eastern Time
     * Example: 15:39+08 is eight hours ahead of UTC, Hong Kong/Singapore time
     * Example: 13:09+05:30 is 5.5 hours ahead of UTC, India time
     */
    TZTIMEONLY("08:30+10"),

    /**
     * string field representing a market or exchange using ISO 10383 Market Identifier Code (MIC) values (see"Appendix 6-C).
     */
    EXCHANGE("XASX"),

    /**
     * string field representing a currency type using ISO 4217 Currency code (3 character) values (see Appendix 6-A).
     */
    CURRENCY("AUD"),

    /**
     * XMLData 	Contains an XML document raw data with no format or content restrictions. XMLData fields are
     * always immediately preceded by a length field. The length field should specify the number of bytes of
     * the value of the data field (up to but not including the terminating SOH).
     */
    XMLDATA("<myxml>hello</myxml>"),

    /**
     * int field representing a message sequence number. Value must be positive.
     */
    SEQNUM("2"),

    /**
     * string field containing raw data with no format or content restrictions. Data fields are always immediately
     * preceded by a length field. The length field should specify the number of bytes of the value of the data field
     * (up to but not including the terminating SOH).
     * Caution: the value of one of these fields may contain the delimiter (SOH) character. Note that the
     * value specified for this field should be followed by the delimiter (SOH) character as all fields are
     * terminated with an "SOH".
     */
    DATA("data"),

    /**
     * Alpha-numeric free format strings, can include any character or punctuation except the delimiter.
     * All String fields are case sensitive (i.e. morstatt != Morstatt).
     */
    STRING("string"),

    /**
     * int field representing a day during a particular monthy (values 1 to 31).
     */
    DAYOFMONTH("27");

    private final String exampleValue;

    FieldClass(final String exampleValue) {
        this.exampleValue = exampleValue;
    }

    public boolean isOneOf(final FieldClass ... fieldClasses){
        for(final FieldClass fieldClass: fieldClasses){
            if(this == fieldClass){
                return true;
            }
        }
        return false;
    }

    public String getExampleValue() {
        return exampleValue;
    }
}
