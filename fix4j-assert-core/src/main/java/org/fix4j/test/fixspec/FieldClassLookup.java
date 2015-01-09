package org.fix4j.test.fixspec;

/**
 * User: ben
 * Date: 17/09/2014
 * Time: 5:42 AM
 */
public class FieldClassLookup {
    private FieldClassLookup() {}

    public static FieldClass lookup(final String fieldClass){
        if(fieldClass.equals("DAY-OF-MONTH")) {
            return FieldClass.DAYOFMONTH;

        } else if(fieldClass.equals("NUMINGRP")) {
            return FieldClass.NUMINGROUP;

        } else {
            return FieldClass.valueOf(fieldClass);
        }
    }
}
