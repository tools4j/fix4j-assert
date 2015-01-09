package org.fix4j.test.codegen;

import java.util.Iterator;

/**
 * User: ben
 * Date: 9/09/2014
 * Time: 5:41 AM
 */
public class CompositeContentHelper {

    public static final String INDENT = "    "

    private CompositeContentHelper() {}

    public static void buildGroupChildrenForClass(final children, final StringBuilder sb, final String indent) {
        if(children == null) return;
        final Iterator it = children.iterator();
        final String newIndent = indent + INDENT;

        while(it.hasNext()){
            final def child = it.next();
            if (child.type == "field") {
                sb.append("${newIndent}FieldTypes.${child.name}.required(${(child.required == 'Y'? 'true': 'false')})");

            } else if (child.type == "group") {
                sb.append("${newIndent}new BaseGroupType(\n");
                sb.append("${newIndent}${INDENT}FieldTypes.${child.name}.required(${(child.required == 'Y' ? 'true': 'false')}),\n");
                buildGroupChildrenForClass(child.children.values(), sb, newIndent);
                sb.append("${newIndent})");

            } else {
                throw new IllegalArgumentException("child of unknown type:" + child);
            }

            if(it.hasNext()){
                sb.append(",");
            }
            sb.append("\n");
        }
    }
}
