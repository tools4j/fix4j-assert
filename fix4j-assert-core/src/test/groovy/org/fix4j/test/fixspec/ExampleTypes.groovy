package org.fix4j.test.fixspec;

/**
 * User: ben
 * Date: 16/01/15
 * Time: 6:13 AM
 */
public class ExampleTypes {
    public static int fieldNumber = 1;
    public static final FieldType fieldType1 = new BaseFieldType("fieldType1", fieldNumber++);
    public static final FieldType fieldType2 = new BaseFieldType("fieldType1", fieldNumber++);
    public static final FieldType fieldTypeNoOfGroup1 = new BaseFieldType("fieldTypeNoOfGroup1", fieldNumber++);
    public static final FieldType fieldTypeGroup1Field1 = new BaseFieldType("fieldTypeGroup1Field1", fieldNumber++);
    public static final FieldType fieldTypeGroup1Field2 = new BaseFieldType("fieldTypeGroup1Field2", fieldNumber++);
    public static final FieldType fieldTypeNoOfGroup2 = new BaseFieldType("fieldTypeNoOfGroup2", fieldNumber++);
    public static final FieldType fieldTypeGroup2Field1 = new BaseFieldType("fieldTypeGroup2Field1", fieldNumber++);
    public static final FieldType fieldTypeGroup2Field2 = new BaseFieldType("fieldTypeGroup2Field2", fieldNumber++);
    public static final FieldType fieldTypeNoOfGroup3 = new BaseFieldType("fieldTypeNoOfGroup3", fieldNumber++);
    public static final FieldType fieldTypeGroup3Field1 = new BaseFieldType("fieldTypeGroup3Field1", fieldNumber++);
    public static final FieldType fieldTypeGroup3Field2 = new BaseFieldType("fieldTypeGroup3Field2", fieldNumber++);

    public static final BaseGroupType group3 = new BaseGroupType(
        fieldTypeNoOfGroup3.required(true),
        fieldTypeGroup3Field1.required(true),
        fieldTypeGroup3Field2.required(false)
    );

    public static final BaseGroupType group2 = new BaseGroupType(
        fieldTypeNoOfGroup2.required(true),
        fieldTypeGroup2Field1.required(true),
        fieldTypeGroup2Field2.required(false)
    );

    public static final BaseGroupType group1 = new BaseGroupType(
        fieldTypeNoOfGroup1.required(true),
        fieldTypeGroup1Field1.required(true),
        fieldTypeGroup1Field2.required(false),
        group2
    );

    public static final BaseFieldAndGroupTypes fieldAndGroupTypes1 = new BaseFieldAndGroupTypes(
        fieldTypeGroup1Field1.required(true),
        fieldTypeGroup1Field2.required(false),
        group2
    );

    /*
    Looks like this when expanded

    public static final BaseMsgType myMsgType = new BaseMsgType(
         "MyVeryOwnMessageType",
         "B",
         "app",
         fieldType1.required(true),
         fieldType2.required(false),
         new BaseGroupType(
             fieldTypeNoOfGroup1.required(true),
             fieldTypeGroup1Field1.required(true),
             fieldTypeGroup1Field2.required(false),
             new BaseGroupType(
                 fieldTypeNoOfGroup2.required(true),
                 fieldTypeGroup2Field1.required(true),
                 fieldTypeGroup2Field2.required(false)
            )
         ),
         new BaseGroupType(
             fieldTypeNoOfGroup3.required(true),
             fieldTypeGroup3Field1.required(true),
             fieldTypeGroup3Field2.required(false)
         )
    );
    */

    public static final BaseMsgType myMsgType = new BaseMsgType(
        "MyVeryOwnMessageType",
        "B",
        "app",
        fieldType1.required(true),
        fieldType2.required(false),
        group1,
        group3
    );


}
