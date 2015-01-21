package org.fix4j.test.fixspec

import spock.lang.Specification

import static org.fix4j.test.fixspec.ExampleTypes.*;

/**
 * User: ben
 * Date: 15/01/15
 * Time: 5:24 PM
 */
class BaseMsgTypeTest extends Specification {

    def "GetName"() {
        expect:
        assert myMsgType.getName() == "MyVeryOwnMessageType"
    }

    def "GetFieldTypes"() {
        expect:
        assert myMsgType.getFieldTypes() == [fieldType1, fieldType2]
    }

    def "GetGroupTypes"() {
        expect:
        assert myMsgType.getGroupTypes() == [group1, group3]

    }

    def "GetGroupType"() {
        expect:
        assert myMsgType.getGroupType(group1.noOfFieldType.getTag().getValue()) == group1;
    }

    def "GetTag"() {
        expect:
        assert myMsgType.getTag() == new BaseTag("B")
    }

    def "ToPrettyString"() {
        expect:
        assert ExampleTypes.myMsgType.toPrettyString() ==
                "******************************************************\n" +
                "MyVeryOwnMessageType\n" +
                "******************************************************\n" +
                "    [fieldType1]1\n" +
                "    [fieldType1]2\n" +
                "    [fieldTypeNoOfGroup1]3\n" +
                "        [fieldTypeGroup1Field1]4\n" +
                "        [fieldTypeGroup1Field2]5\n" +
                "        [fieldTypeNoOfGroup2]6\n" +
                "            [fieldTypeGroup2Field1]7\n" +
                "            [fieldTypeGroup2Field2]8\n" +
                "    [fieldTypeNoOfGroup3]9\n" +
                "        [fieldTypeGroup3Field1]10\n" +
                "        [fieldTypeGroup3Field2]11\n";
    }

    def "ContainsChild"() {
        expect:
        assert myMsgType.containsChild(fieldType1) == true
        assert myMsgType.containsChild(fieldType2) == true
        assert myMsgType.containsChild(group1.noOfFieldType) == true
        assert myMsgType.containsChild(group2.noOfFieldType) == false
        assert myMsgType.containsChild(fieldTypeGroup2Field2) == false
    }

    def "ContainsRecursively"() {
        expect:
        assert myMsgType.containsRecursively(fieldType1) == true
        assert myMsgType.containsRecursively(fieldType2) == true
        assert myMsgType.containsRecursively(group1.noOfFieldType) == true
        assert myMsgType.containsRecursively(group2.noOfFieldType) == true
        assert myMsgType.containsRecursively(fieldTypeGroup2Field2) == true
    }

    def "GetFieldOrder"() {
        expect:
        assert myMsgType.getFieldOrder() == [1,2,3,9];
    }

    def "Equals"() {
        when:
        final BaseMsgType msgTypeEqual = new BaseMsgType(
                "MyVeryOwnMessageType",
                "B",
                "app",
                fieldType1.required(true),
                fieldType2.required(false),
                group1,
                group3
        );

        then:
        assert myMsgType.equals(msgTypeEqual);

        when:
        final BaseMsgType msgTypeNotEqual1 = new BaseMsgType(
                "MyVeryOwnMessageType",
                "C",  //<--Different tag
                "app",
                fieldType1.required(true),
                fieldType2.required(false),
                group1,
                group3);

        then:
        assert !myMsgType.equals(msgTypeNotEqual1)

        when:
        final BaseMsgType msgTypeNotEqual2 = new BaseMsgType(
                "MyVeryOwnMessageType",
                "C",  //<--Different tag
                "app",
                fieldType1.required(true),
                fieldType2.required(false),
                group1,);  //<!--Missing group 3

        then:
        assert !myMsgType.equals(msgTypeNotEqual2)
    }


    def "GetAllFieldTypesRecursively"() {
        expect:
        myMsgType.getAllFieldTypesRecursively() == new HashSet<? extends FieldType>(
                [fieldType1,
                 fieldType2,
                 fieldTypeGroup1Field1,
                 fieldTypeGroup1Field2,
                 fieldTypeGroup2Field1,
                 fieldTypeGroup2Field2,
                 fieldTypeGroup3Field1,
                 fieldTypeGroup3Field2,
                 fieldTypeNoOfGroup1,
                 fieldTypeNoOfGroup2,
                 fieldTypeNoOfGroup3]);
    }
}
