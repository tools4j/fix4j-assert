package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.MsgType;
import org.fix4j.test.session.FixSessionId;
import org.fix4j.test.util.Asserts;
import org.fix4j.test.util.Consts;
import org.fix4j.test.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * User: ben
 * Date: 23/09/2014
 * Time: 6:11 AM
 */
public class BaseFixMessage implements FixMessage {
    public static final String BANNER_STR = "------------------------------------------------------";
    public static final String PRETTY_HEADER_TITLE = "Header";
    public static final String PRETTY_BODY_TITLE = "Body";
    public static final String PRETTY_TRAILER_TITLE = "Trailer";

    private final int MSG_TYPE_TAG = 35;
    private final int BEGIN_STRING_TAG = 8;
    private final int SENDER_COMP_TAG = 49;
    private final int TARGET_COMP_TAG = 56;

    private final FieldsAndGroups header;
    private final FieldsAndGroups trailer;
    private final FieldsAndGroups body;
    private final List<Field> allFields;
    private final MsgType typeOfMessage;

    public BaseFixMessage(
            final MsgType typeOfMessage,
            final FieldsAndGroups header,
            final FieldsAndGroups body,
            final FieldsAndGroups trailer) {

        this.header = header;
        this.trailer = trailer;
        this.body = body;
        this.typeOfMessage = typeOfMessage;

        Asserts.assertEquals(typeOfMessage.getTag().getValue(), header.getField(MSG_TYPE_TAG).getValue());

        final List<Field> allFields = new ArrayList<>();
        allFields.addAll(header.getAllFieldsRecursively());
        allFields.addAll(body.getAllFieldsRecursively());
        allFields.addAll(trailer.getAllFieldsRecursively());
        this.allFields = Collections.unmodifiableList(allFields);
    }

    @Override
    public boolean isOfType(MsgType msgType) {
        return getTypeOfMessage().equals(msgType);
    }

    @Override
    public MsgType getTypeOfMessage() {
        return typeOfMessage;
    }

    @Override
    public List<Field> getAllFieldsRecursively() {
        return allFields;
    }

    @Override
    public String toDelimitedMessageWithDescriptors() {
        final StringBuilder sb = new StringBuilder();
        for (final Field field : allFields) {
            if(sb.length() > 0){
                sb.append(Consts.FIX_FIELD_DISPLAY_DELIM);
            }
            sb.append(field.toStringWithDescriptors());
        }
        return sb.toString();
    }

    @Override
    public String toDelimitedMessage() {
        final StringBuilder sb = new StringBuilder();
        for (final Field field : allFields) {
            if(sb.length() > 0){
                sb.append(Consts.FIX_FIELD_DISPLAY_DELIM);
            }
            sb.append(field.toStringWithRawValues());
        }
        return sb.toString();
    }

    @Override
    public FixSessionId getSessionId() {
        final Field beginString = header.getField(BEGIN_STRING_TAG);
        final Field senderCompId = header.getField(SENDER_COMP_TAG);
        final Field targetCompId = header.getField(TARGET_COMP_TAG);

        return new FixSessionId(beginString.getValue(), senderCompId.getValue(), targetCompId.getValue());
    }

    @Override
    public Field getField(final FieldType fieldType) {
        return getField(fieldType.getTag().getValue());
    }

    @Override
    public List<Field> getFields(final FieldType fieldType) {
        return getFields(fieldType.getTag().getValue());
    }

    @Override
    public Field getField(final int tag) {
        final List<Field> matchingFields = getFields(tag);
        if(matchingFields.size() == 0){
            return null;
        } else if(matchingFields.size() == 1){
            return matchingFields.get(0);
        } else {
            throw new IllegalStateException(matchingFields.size() + " fields of tag " + tag + " found, but only 1 was expected. Matching fields:" + matchingFields);
        }
    }

    @Override
    public List<Field> getFields(final int tag) {
        final List<Field> matchingFields = new ArrayList<>();
        for (final Field field : allFields) {
            if(field.isOfTag(tag)){
                matchingFields.add(field);
            }
        }
        return matchingFields;
    }

    @Override
    public Field getField(final String reference) {
        final Map<String, Field> referenceMap = getFieldReferenceMap();
        final Field field = referenceMap.get(reference);
        if(field == null){
            throw new IllegalArgumentException("Cannot find field with reference:" + reference + "\nAvailable references:\n" + StringUtils.indentAllLines(getReferenceMapAsPrettyString(referenceMap)));

        }
        return field;
    }

    private String getReferenceMapAsPrettyString(final Map<String, Field> referenceMap) {
        final StringBuilder sb = new StringBuilder();
        for (final String key : referenceMap.keySet()) {
            sb.append(key).append("=").append(referenceMap.get(key).getFormattedValue()).append(Consts.EOL);
        }
        return sb.toString();
    }

    @Override
    public Map<String, Field> getFieldReferenceMap() {
        Map<String,Field> map = new LinkedHashMap<>();
        map.putAll(header.getFieldReferenceMap());
        map.putAll(body.getFieldReferenceMap());
        map.putAll(trailer.getFieldReferenceMap());
        return map;
    }

    @Override
    public FieldsAndGroups getHeader() {
        return header;
    }

    @Override
    public FieldsAndGroups getTrailer() {
        return trailer;
    }

    @Override
    public FieldsAndGroups getBody() {
        return body;
    }

    @Override
    public String toString() {
        return this.toDelimitedMessageWithDescriptors();
    }

    @Override
    public String toPrettyString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(BANNER_STR).append(Consts.EOL);
        sb.append(this.typeOfMessage.getName()).append(Consts.EOL);
        sb.append(BANNER_STR).append(Consts.EOL);
        sb.append(PRETTY_HEADER_TITLE).append(Consts.EOL);
        sb.append(StringUtils.indentAllLines(header.toPrettyString()));
        sb.append(PRETTY_BODY_TITLE).append(Consts.EOL);
        sb.append(StringUtils.indentAllLines(body.toPrettyString()));
        sb.append(PRETTY_TRAILER_TITLE).append(Consts.EOL);
        sb.append(StringUtils.indentAllLines(trailer.toPrettyString()));
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseFixMessage)) return false;
        final BaseFixMessage that = (BaseFixMessage) o;
        if (allFields != null ? !allFields.equals(that.allFields) : that.allFields != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return allFields != null ? allFields.hashCode() : 0;
    }
}
