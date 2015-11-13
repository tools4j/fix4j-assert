package org.fix4j.test.expression;

import org.fix4j.test.fixmodel.Field;
import org.fix4j.test.fixmodel.PrettyStripper;
import org.fix4j.test.fixmodel.RegexMatchingField;
import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.properties.PropertyKeysAndDefaultValues;
import org.fix4j.test.util.Consts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: ben
 * Date: 2/09/2014
 * Time: 4:55 PM
 */
public class RawFixMessageExpressionParser {
    private final FixSpecification fixSpecification;
    private final String fixFieldDelimiter;
    public static final Pattern FIELD_TAG_AND_VALUE_PATTERN = Pattern.compile("(\\d+)\\" + Consts.FIX_FIELD_EQUALS + "(.*)\\s*");


    public RawFixMessageExpressionParser(final FixSpecification fixSpecification) {
        this(fixSpecification, ApplicationProperties.Singleton.instance().getAsString(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM));
    }

    public RawFixMessageExpressionParser(final FixSpecification fixSpecification, final String fixFieldDelimiter) {
        this.fixSpecification = fixSpecification;
        this.fixFieldDelimiter = fixFieldDelimiter;
    }

    public MessageExpression parse(final String expression) {
        final List<Field> fixFields = new ArrayList<Field>();
        final String strippedExpression = PrettyStripper.stripPrettiness(expression);

        final String[] parts = strippedExpression.split(fixFieldDelimiter);
        final List<String> partsList = new ArrayList<String>();
        for (String part : parts) {
            part = part.trim();
            if (part.length() != 0) {
                partsList.add(part);
            }
        }

        for (final String part : partsList) {
            final Field field;
            try {
                field = parseField(part);
            } catch (Exception e) {
                throw new IllegalArgumentException("Cannot parse field '" + part + "' in expression:" + expression, e);
            }
            fixFields.add(field);
        }
        return new MessageExpression(fixFields);
    }

    public Field parseField(String fieldStr) {
        if(fieldStr == null){
            throw new IllegalArgumentException("Null string not allowed for field");
        }
        fieldStr = fieldStr.trim();
        if(fieldStr.isEmpty()){
            throw new IllegalArgumentException("Empty string not allowed for field");
        } else if(fieldStr.startsWith(Consts.FIX_FIELD_EQUALS)){
            throw new IllegalArgumentException("Field not allowed to start with equals sign '" + Consts.FIX_FIELD_EQUALS + "'");
        } else if(!fieldStr.contains(Consts.FIX_FIELD_EQUALS)){
            throw new IllegalArgumentException("Field expression must contain equals sign '" + Consts.FIX_FIELD_EQUALS + "'");
        }

        final Matcher matcher = FIELD_TAG_AND_VALUE_PATTERN.matcher(fieldStr);
        final boolean matchesExpression = matcher.find();
        if(!matchesExpression){
            throw new IllegalArgumentException("Field str '" + fieldStr + " does not match expression '" + FIELD_TAG_AND_VALUE_PATTERN + "'");
        }
        final String fieldTypeStr = matcher.group(1);
        final FieldType fieldType = parseFieldType(fieldTypeStr);

        final String fieldValue;
        if(matcher.groupCount() > 1){
            fieldValue = matcher.group(2);
        } else {
            fieldValue = "";
        }
        return new Field(fieldType, fieldValue);
    }

    public FieldType parseFieldType(final String tagNumberStr) {
        final int tag;
        try {
            tag = Integer.parseInt(tagNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Tag not a number: " + tagNumberStr);
        }
        final FieldType fieldType = fixSpecification.getFieldTypeByTag(tag);
        if(fieldType != null){
            return fieldType;
        } else {
            return FieldType.Factory.forCustomTag(tag);
        }
    }
}
