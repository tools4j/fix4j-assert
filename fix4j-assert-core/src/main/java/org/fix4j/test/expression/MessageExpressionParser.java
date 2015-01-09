package org.fix4j.test.expression;

import org.fix4j.test.fixmodel.Field;
import org.fix4j.test.fixmodel.RegexMatchingField;
import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixmodel.PrettyStripper;
import org.fix4j.test.fixspec.FixSpecification;
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
public class MessageExpressionParser {
    private final FixSpecification fixSpecification;
    public static final Pattern TAG_PATTERN_WITH_TEXT_THEN_NUMBER = Pattern.compile("\\[([^\\]]+)\\](\\d+)");
    public static final Pattern TAG_PATTERN_WITH_NUMBER_THEN_TEXT = Pattern.compile("(\\d+)\\[([^\\]]+)\\]");
    public static final Pattern TAG_PATTERN_WITH_JUST_NUMBER = Pattern.compile("(\\d+)");
    public static final Pattern TAG_PATTERN_WITH_JUST_TEXT = Pattern.compile("\\[?(\\w+)\\]?");
    public static final Pattern FIELD_VALUE_WITH_DESC_THEN_ENUM = Pattern.compile("\\[([^\\]]+)\\](.+)");
    public static final Pattern FIELD_VALUE_WITH_ENUM_THEN_DESC = Pattern.compile("(\\w+)\\[([^\\]]+)\\]");

    public MessageExpressionParser(final FixSpecification fixSpecification) {
        this.fixSpecification = fixSpecification;
    }

    public MessageExpression parse(final String expression){
        final List<Field> fixFields = new ArrayList<Field>();
        final String strippedExpression = PrettyStripper.stripPrettiness(expression);

        final String[] parts = strippedExpression.split(Consts.FIX_FIELD_DELIM);
        final List<String> partsList = new ArrayList<String>();
        for(String part: parts){
            part = part.trim();
            if(part.length() != 0){
                partsList.add(part);
            }
        }

        for(final String part: partsList){
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
        if(fixFieldParts.length > 2) {
            throw new IllegalArgumentException("It appears that a valid delimiter was not used to separate fix fields.  Valid separators are defined by the regular expression: '" + Consts.FIX_FIELD_DELIM + "'");
        } else if(fixFieldParts.length < 2){
            throw new IllegalArgumentException("Fix field expression does not match '<tag>" + Consts.FIX_FIELD_EQUALS + "<value>' format. Field: '" + fieldStr);
        }
        final String fieldTypeStr = fixFieldParts[0];
        final FieldType fieldType = parseFieldType(fieldTypeStr);
        final String fieldValue = parseFieldValue(fieldType, fixFieldParts[1]);
        if(RegexMatchingField.containsRegexForwardSlashes(fieldValue)){
            return new RegexMatchingField(fieldType, fieldValue);
        } else {
            return new Field(fieldType, fieldValue);
        }
    }

    public String parseFieldValue(final FieldType fieldType, final String fieldValueStr) {
        //Check whether is a regex
        if(fieldValueStr.startsWith("/") && fieldValueStr.endsWith("/")){
            return fieldValueStr;
        }

        //Check whether there are escaped square brackets, if so, unescape them, and return literal
        if(fieldValueStr.contains("\\[") || fieldValueStr.contains("\\]")){
            return fieldValueStr.replace("\\]", "]").replace("\\[", "[");
        }

        //Check whether is in the format enum[desc], e.g: "D[REJECT]"
        Matcher matcher = FIELD_VALUE_WITH_DESC_THEN_ENUM.matcher(fieldValueStr);
        if(matcher.matches()){
            final String parsedDesc = matcher.group(1);
            final String parsedEnum = matcher.group(2);
            validateFieldValueEnumAndDesc(fieldType, fieldValueStr, parsedDesc, parsedEnum);
            return parsedEnum;
        }

        //Check whether is in the format [desc]enum, e.g.: "[REJECT]D"
        matcher = FIELD_VALUE_WITH_ENUM_THEN_DESC.matcher(fieldValueStr);
        if(matcher.matches()){
            final String parsedEnum = matcher.group(1);
            final String parsedDesc = matcher.group(2);
            validateFieldValueEnumAndDesc(fieldType, fieldValueStr, parsedDesc, parsedEnum);
            return parsedEnum;
        }

        return fieldValueStr;
    }

    public void validateFieldValueEnumAndDesc(final FieldType fieldType, final String fieldValueStr, final String parsedDesc, final String parsedEnum) {
        final String expectedDescription = fieldType.getDescriptionForKnownValue(parsedEnum);
        if(expectedDescription == null){
            if(fieldType.getEnumValues().size() > 0) {
                throw new IllegalArgumentException("Error when parsing value: " + fieldValueStr + ".  According to the fix specification, the value:" + parsedEnum + " is not valid for type:" + fieldType + " valid values are:" + fieldType.getEnumValues());
            } else {
                throw new IllegalArgumentException("Error when parsing value: " + fieldValueStr + ".  According to the fix specification there are no pre-defined enum values for this type.  Please remove the enum desc, i.e. instead of '" + fieldType + "=" + fieldValueStr + "' use '" + fieldType + "=" + parsedEnum + "'");
            }

        } else if(!expectedDescription.equals(parsedDesc)){
            throw new IllegalArgumentException("Error when parsing value: " + fieldValueStr + ".  Expected description:" + expectedDescription + " does not match parsed description:" + parsedDesc + " for type:" + fieldType + " valid values are:" + fieldType.getEnumValues());

        }
    }

    public FieldType parseFieldType(final String fieldTypeStr){
        Matcher matcher = TAG_PATTERN_WITH_TEXT_THEN_NUMBER.matcher(fieldTypeStr);
        if(matcher.matches()){
            final String tagText = matcher.group(1);
            final String tagNumber = matcher.group(2);

            final FieldType fieldType = fixSpecification.getFieldTypeByTag(Integer.parseInt(tagNumber));
            if(!fieldType.getName().equals(tagText)){
                throw new IllegalArgumentException("Parsed field type:" + fieldTypeStr + " contains mismatched tag number to tag name.  Expected:" + fieldType);
            } else {
                return fieldType;
            }
        }

        matcher = TAG_PATTERN_WITH_NUMBER_THEN_TEXT.matcher(fieldTypeStr);
        if(matcher.matches()){
            final String tagNumber = matcher.group(1);
            final String tagText = matcher.group(2);

            final FieldType fieldType = fixSpecification.getFieldTypeByTag(Integer.parseInt(tagNumber));
            if(!fieldType.getName().equals(tagText)){
                throw new IllegalArgumentException("Parsed field type:" + fieldTypeStr + " contains mismatched tag number to tag name.  Expected:" + fieldType);
            } else {
                return fieldType;
            }
        }

        matcher = TAG_PATTERN_WITH_JUST_NUMBER.matcher(fieldTypeStr);
        if(matcher.matches()){
            final String tagNumStr = matcher.group(1);
            final int tagNum = Integer.parseInt(tagNumStr);
            final FieldType fieldType = fixSpecification.getFieldTypeByTag(tagNum);
            if(fieldType != null){
                return fieldType;
            } else {
                return FieldType.Factory.forCustomTag(tagNum);
            }
        }

        matcher = TAG_PATTERN_WITH_JUST_TEXT.matcher(fieldTypeStr);
        if(matcher.matches()){
            final String tagText = matcher.group(1);
            final FieldType fieldTypeByName = fixSpecification.getFieldTypeByName(tagText);
            if(fieldTypeByName != null) return fieldTypeByName;
            else throw new IllegalArgumentException("Could not find tag in specification of type:" + fieldTypeStr);
        }

        throw new IllegalArgumentException("Cannot parse field type:" + fieldTypeStr);
    }
}
