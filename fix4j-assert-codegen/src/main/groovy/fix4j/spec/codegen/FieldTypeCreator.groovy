package org.fix4j.spec.codegen
/**
 * User: ben
 * Date: 26/08/2014
 * Time: 5:59 AM
 */
public class FieldTypeCreator {

    public static void writeFieldTypesJavaFiles(final String packageName, final LinkedHashMap fields) {
        def it = fields.values().iterator();
        while(it.hasNext()){
            def field = it.next();
            final File parentDir = new File("fieldtype");
            if(!parentDir.exists()) parentDir.mkdir();
            final File file = new File("fieldtype/" + field.name + ".java");
            file.write(createFieldTypeClassContent(packageName, field));
        }
    }

    private static String createFieldTypeClassContent(final String packageName, final def field){
        final StringBuilder sb = new StringBuilder();
        sb.append("package ${packageName}.fieldtype;\n" +
                "\n" +
                "\n" +
                "import org.fix4j.test.fixspec.BaseFieldType;\n" +
                "import org.fix4j.test.fixspec.FieldClass;\n" +
                "import org.fix4j.test.fixspec.FieldClassLookup;\n" +
                "import org.fix4j.test.fixspec.FieldTypeValueEnum;\n" +
                "import org.fix4j.test.fixmodel.Field;\n" +
                "\n" +
                "public class ${field.name} extends BaseFieldType {\n" +
                "    public static final ${field.name} INSTANCE = new ${field.name}();\n" +
                "\n" +
                "    private ${field.name}() {\n" +
                "        super(\n" +
                "            \"${field.name}\",\n" +
                "            ${field.number},\n" +
                "            FieldClassLookup.lookup(\"${field.fieldClass}\"),\n" +
                "            Values.class\n" +
                "        );\n" +
                "    }\n" +
                "\n");

        //Static factory methods
        sb.append("    public static Field withValue(final String value){ return new Field(INSTANCE, value); }\n");
        sb.append("    public static Field withValue(final long value){ return new Field(INSTANCE, \"\"+value); }\n\n");

        //Values factory
        if(!field.enumValues.isEmpty()) {
            sb.append("    public static FieldFactory withValue(){ return new FieldFactory(); }\n\n");
            sb.append("    public static class FieldFactory{\n");
            def enumIt = field.enumValues.iterator();
            while (enumIt.hasNext()) {
                final def enumVal = enumIt.next();
                sb.append("        public final Field ${enumVal.description} = new Field(${field.name}.INSTANCE, Values.${enumVal.description}.getOrdinal());\n");
            }
            sb.append("    }\n\n");
        }

        //Values enum
        sb.append("    public enum Values implements FieldTypeValueEnum {\n");
        if(field.enumValues.isEmpty()){
            sb.append("        ; //No enum values for this FieldType.\n");
        } else {
            def enumIt = field.enumValues.iterator();
            while (enumIt.hasNext()) {
                final def enumVal = enumIt.next();
                sb.append("        ${enumVal.description}(\"${enumVal.ordinal}\")");
                if (enumIt.hasNext()) sb.append(",\n");
            }
            sb.append(";\n");
        }

        sb.append("\n" +
                "        private final String ordinal;\n" +
                "\n" +
                "        private Values(final String ordinal) {\n" +
                "            this.ordinal = ordinal;\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public String getOrdinal() {\n" +
                "            return ordinal;\n" +
                "        }\n" +
                "    }\n" +
                "}\n");
        return sb.toString();
    }
}
