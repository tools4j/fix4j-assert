package org.fix4j.test.integration.quickfix;

import org.fix4j.test.integration.MessageConverter;
import org.fix4j.test.fixmodel.BaseFixMessageBuilder;
import org.fix4j.test.fixmodel.Field;
import org.fix4j.test.fixmodel.FixMessage;
import org.fix4j.test.fixmodel.Group;
import org.fix4j.test.fixspec.FieldType;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.plumbing.Consumer;
import quickfix.FieldMap;
import quickfix.FieldNotFound;
import quickfix.Message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * User: ben
 * Date: 14/08/2014
 * Time: 2:55 PM
 */
public class FromQuickFixMessageConverter implements MessageConverter<Message, FixMessage> {
    private final FixSpecification fixSpecification;

    public FromQuickFixMessageConverter(final FixSpecification fixSpecification) {
        this.fixSpecification = fixSpecification;
    }

    @Override
    public Consumer<Message> convertAndSendMessagesTo(final Consumer<FixMessage> messageConsumer){
        return new Consumer<Message>(){
            @Override
            public void accept(final Message quickfixMessage) {
                messageConsumer.accept(convert(quickfixMessage));
            }
        };
    }

    @Override
    public FixMessage convert(final Message message) {
        final List<Field> header = fromQuickFixFields(message.getHeader());
        final List<Field> body = fromQuickFixFields(message);
        final List<Field> trailer = fromQuickFixFields(message.getTrailer());

        final List<Field> allFields = new ArrayList<>();
        allFields.addAll(header);
        allFields.addAll(body);
        allFields.addAll(trailer);

        final BaseFixMessageBuilder builder = new BaseFixMessageBuilder(fixSpecification);
        return builder.withFields(allFields).build();
    }

    private List<Field> fromQuickFixFields(final FieldMap fieldMap) {
        final List<Field> fields = new ArrayList<>();
        final Map<Integer, Field> groupNoOfFields = new LinkedHashMap<>();

        final Iterator<quickfix.Field<?>> fieldIterator = fieldMap.iterator();
        while(fieldIterator.hasNext()) {
            final quickfix.Field<?> quickfixField = fieldIterator.next();
            final Field field = fromQuickFixField(quickfixField);
            if(field.getType().isNumInGroup()) {
                groupNoOfFields.put(field.getTag().getValue(), field);
            } else {
                fields.add(field);
            }
        }

        final Iterator<Integer> groupIterator = fieldMap.groupKeyIterator();
        while(groupIterator.hasNext()) {
            final int noOfFieldTag = groupIterator.next();
            fields.add(groupNoOfFields.get(noOfFieldTag));
            final List<quickfix.Group> repeats = fieldMap.getGroups(noOfFieldTag);
            for (final quickfix.Group repeat : repeats) {
                fields.addAll(fromQuickFixFields(repeat));
            }
        }
        return fields;
    }

    private Field fromQuickFixField(final quickfix.Field<?> quickfixField) {
        FieldType fieldType = fixSpecification.getFieldTypeByTag(quickfixField.getTag());
        if(fieldType == null){
            fieldType = FieldType.Factory.forCustomTag(quickfixField.getTag());
        }
        return new Field(fieldType, quickfixField.getObject().toString());
    }
}
