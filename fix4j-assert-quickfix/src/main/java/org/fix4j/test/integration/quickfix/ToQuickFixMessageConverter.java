package org.fix4j.test.integration.quickfix;

import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.GroupType;
import org.fix4j.test.integration.MessageConverter;
import org.fix4j.test.fixmodel.Field;
import org.fix4j.test.fixmodel.FieldsAndGroups;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixspec.FieldClass;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.plumbing.Consumer;
import org.fix4j.test.util.DateUtils;
import org.fix4j.test.util.Utils;
import quickfix.FieldMap;
import quickfix.Group;
import quickfix.Message;

/**
 * User: ben
 * Date: 14/08/2014
 * Time: 2:55 PM
 */
public class ToQuickFixMessageConverter implements MessageConverter<FixMessage, Message> {
    private final FixSpecification fixSpecification;

    public ToQuickFixMessageConverter(final FixSpecification fixSpecification) {
        this.fixSpecification = fixSpecification;
    }

    @Override
    public Consumer<FixMessage> convertAndSendMessagesTo(final Consumer<Message> messageConsumer) {
        return new Consumer<FixMessage>() {
            @Override
            public void accept(final FixMessage message) {
                messageConsumer.accept(convert(message));
            }
        };
    }

    @Override
    public Message convert(final FixMessage fixTestMessage) {
        final quickfix.Message quickfixMessage = new quickfix.Message();
        convertAndPopulateFieldMap(quickfixMessage.getHeader(), fixTestMessage.getHeader());
        convertAndPopulateFieldMap(quickfixMessage, fixTestMessage.getBody());
        convertAndPopulateFieldMap(quickfixMessage.getTrailer(), fixTestMessage.getTrailer());
        return quickfixMessage;
    }

    private void convertAndPopulateFieldMap(final FieldMap fieldMap, final FieldsAndGroups fieldsAndGroups){
        for (final Field field : fieldsAndGroups.getFields()) {
            addFieldToQuickfixFieldMap(field, fieldMap);
        }

        for (final org.fix4j.test.fixmodel.Group group : fieldsAndGroups.getGroups()) {
            addGroupToQuickfixFieldMap(group, fieldMap);
        }
    }

    private void addGroupToQuickfixFieldMap(final org.fix4j.test.fixmodel.Group fixTestGroup, final FieldMap fieldMap) {
        for (final FieldsAndGroups fixTestGroupRepeat : fixTestGroup.getRepeats()) {
            final GroupType groupType = fixTestGroup.getType();

            final Group group = new Group(
                    groupType.getNoOfFieldType().getTag().getValue(),
                    groupType.getFirstChildTypeOfRepeatingGroup().getTag().getValue(),
                    Utils.toIntArray(groupType.getFieldOrder()));
            convertAndPopulateFieldMap(group, fixTestGroupRepeat);
            fieldMap.addGroup(group);
        }
    }

    private void addFieldToQuickfixFieldMap(final Field field, final FieldMap fieldMap) {
        final FieldType fieldType = fixSpecification.getFieldTypeByTag(field.getTag());
        if(fieldType == null){
            fieldMap.setString(field.getTag().getValue(), field.getValue());
            return;
        }

        final FieldClass fieldClass = fieldType.getFieldClass();

        switch (fieldClass) {
            case TZTIMESTAMP:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            case PRICE:
                fieldMap.setDouble(field.getTag().getValue(), Double.parseDouble(field.getValue())); break;
            case UTCTIMESTAMP:
                fieldMap.setUtcTimeStamp(field.getTag().getValue(), DateUtils.parseUtcTimestamp(field.getValue())); break;
            case AMT:
                fieldMap.setDouble(field.getTag().getValue(), Double.parseDouble(field.getValue())); break;
            case LOCALMKTDATE:
                if(isAcceptableDateAbbreviation(field.getValue())){
                    fieldMap.setString(field.getTag().getValue(), field.getValue()); break;
                } else {
                    fieldMap.setUtcDateOnly(field.getTag().getValue(), DateUtils.parseDate(field.getValue())); break;
                }
            case NUMINGROUP:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            case CHAR:
                fieldMap.setChar(field.getTag().getValue(), field.getValue().charAt(0)); break;
            case UTCDATEONLY:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            case MULTIPLECHARVALUE:
                fieldMap.setString(field.getTag().getValue(), field.getValue()); break;
            case MULTIPLESTRINGVALUE:
                fieldMap.setString(field.getTag().getValue(), field.getValue()); break;
            case INT:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            case FLOAT:
                fieldMap.setDouble(field.getTag().getValue(), Double.parseDouble(field.getValue())); break;
            case MONTHYEAR:
                fieldMap.setString(field.getTag().getValue(), field.getValue()); break;
            case QTY:
                fieldMap.setDouble(field.getTag().getValue(), Double.parseDouble(field.getValue())); break;
            case PERCENTAGE:
                fieldMap.setDouble(field.getTag().getValue(), Double.parseDouble(field.getValue())); break;
            case LENGTH:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            case PRICEOFFSET:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            case UTCTIMEONLY:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            case LANGUAGE:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            case BOOLEAN:
                fieldMap.setBoolean(field.getTag().getValue(), Boolean.parseBoolean(field.getValue())); break;
            case COUNTRY:
                fieldMap.setString(field.getTag().getValue(), field.getValue()); break;
            case TZTIMEONLY:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            case EXCHANGE:
                fieldMap.setString(field.getTag().getValue(), field.getValue()); break;
            case CURRENCY:
                fieldMap.setString(field.getTag().getValue(), field.getValue()); break;
            case XMLDATA:
                fieldMap.setString(field.getTag().getValue(), field.getValue()); break;
            case SEQNUM:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            case DATA:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            case STRING:
                fieldMap.setString(field.getTag().getValue(), field.getValue()); break;
            case DAYOFMONTH:
                fieldMap.setInt(field.getTag().getValue(), Integer.parseInt(field.getValue())); break;
            default:
                throw new IllegalArgumentException("Unknown field class: " + fieldClass);
        }
    }

    private boolean isAcceptableDateAbbreviation(final String value) {
        return value.equals("SP")
                || value.equals("1W")
                || value.equals("1M");
    }
}
