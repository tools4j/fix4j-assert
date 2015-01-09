package org.fix4j.test.expression;

import org.fix4j.test.fixmodel.BaseFixMessageBuilder;
import org.fix4j.test.fixmodel.Field;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.RegexMatchingField;
import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.fixspec.Tag;
import org.fix4j.test.matching.FixFieldMatchResult;
import org.fix4j.test.matching.matchers.BaseMatchResult;
import org.fix4j.test.matching.matchers.FixMessageMatcher;
import org.fix4j.test.matching.matchers.MatchResult;
import org.fix4j.test.util.CompositeReport;
import org.fix4j.test.util.Consts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Is a representation of a fix message, to be used either to build a FixMessage to send, or to
 * assert against incoming fix messages.
 *
 *
 */
public class MessageExpression implements FixMessageMatcher {
    private final List<Field> fieldExpressions;

    public MessageExpression(final Field ... fields) {
        this.fieldExpressions = Collections.unmodifiableList(Arrays.asList(fields));
    }

    public MessageExpression(final List<Field> fields) {
        this.fieldExpressions = Collections.unmodifiableList(fields);
    }

    public static MessageExpression forAnyValueOfField(final FieldType fieldType){
        return new MessageExpression(new RegexMatchingField(fieldType, "/.*/"));
    }

    public FixMessage asMessage(final FixSpecification fixSpecification){
        return (new BaseFixMessageBuilder(fixSpecification)).withFields(this.fieldExpressions).build();
    }

    public List<Field> toFields(){
        return Collections.unmodifiableList(fieldExpressions);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof FixMessageMatcher)) return false;
        final MessageExpression that = (MessageExpression) o;
        if (!fieldExpressions.equals(that.fieldExpressions)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return fieldExpressions.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for(final Field field: fieldExpressions){
            sb.append(field).append(Consts.FIX_FIELD_DISPLAY_DELIM);
        }
        return sb.toString();
    }

    @Override
    public MatchResult getMatchResult(final FixMessage message) {
        final List<FixFieldMatchResult> matchReports = new ArrayList<>();
        final List<Field> unusedExpectedFields = new ArrayList<>(fieldExpressions);
        boolean matchesOverall = true;

        //For fields in message
        for (final Field actual : message.getAllFieldsRecursively()) {
            final Field expected = getAndRemoveFirstOccurrenceOf(actual.getTag(), unusedExpectedFields);

            if (expected != null) {
                final FieldType fieldType = actual.getFieldType();
                final boolean matches = expected.matchesValueOf(actual);

                if(!matches) matchesOverall = false;
                matchReports.add(new FixFieldMatchResult(matches, fieldType, actual.getValue(), expected.getValue()));
            }
        }

        //For any expected fields that were NOT found
        for (final Field unusedExpectedField : unusedExpectedFields) {
            matchReports.add(new FixFieldMatchResult(false, unusedExpectedField.getFieldType(), null, unusedExpectedField.getValue()));
            matchesOverall = false;
        }

        return new BaseMatchResult(matchesOverall, new CompositeReport(matchReports));
    }

    private Field getAndRemoveFirstOccurrenceOf(final Tag tag, final List<Field> unusedExpectedFields) {
        Field found = null;
        for (final Field field : unusedExpectedFields) {
            if (field.isOfTag(tag)) {
                found = field;
                break;
            }
        }
        if (found != null) {
            unusedExpectedFields.remove(found);
        }
        return found;
    }


    public List<Field> getFieldExpressions() {
        return fieldExpressions;
    }
}
