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
    private final PrettyStripper prettyStripper;

    public RawFixMessageExpressionParser(final FixSpecification fixSpecification) {
        this(fixSpecification, ApplicationProperties.Singleton.instance().getAsString(PropertyKeysAndDefaultValues.FIX_FIELD_DELIM));
    }

    public RawFixMessageExpressionParser(final FixSpecification fixSpecification, final String fixFieldDelimiter) {
        this.fixSpecification = fixSpecification;
        this.fixFieldDelimiter = fixFieldDelimiter;
        this.prettyStripper = new PrettyStripper();
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

    public Field parseField(final String fieldStr) {
        final String[] fixFieldParts = fieldStr.split(Consts.FIX_FIELD_EQUALS);
        if (fixFieldParts.length > 2) {
            throw new IllegalArgumentException("Badly formatted field '" + fieldStr + "'.  More than one equals sign '" + Consts.FIX_FIELD_EQUALS + "' detected.  This could mean that there was more than one equals sign specified in the field, or, it could mean that two or more fields were not separated by a valid field delimiter.  Please ensure that fields are separated by text which matches regex: '" + fixFieldDelimiter + "'");
        } else if (fixFieldParts.length < 2) {
            throw new IllegalArgumentException("Fix field expression does not match '<tag>" + Consts.FIX_FIELD_EQUALS + "<value>' format. Field: '" + fieldStr + "'");
        }
        final String fieldTypeStr = fixFieldParts[0];
        final FieldType fieldType = parseFieldType(fieldTypeStr);
        final String fieldValue = fixFieldParts[1];
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
