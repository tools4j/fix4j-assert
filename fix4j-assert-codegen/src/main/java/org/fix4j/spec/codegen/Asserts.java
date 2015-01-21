package org.fix4j.spec.codegen;

/**
 * User: ben
 * Date: 25/08/2014
 * Time: 4:54 PM
 */

public class Asserts {
    public static void assertTrue(final boolean condition){
        if(!condition) throw new IllegalArgumentException("Condition is not true.");
    }

    public static void assertFalse(final boolean condition){
        if(condition) throw new IllegalArgumentException("Condition is not false.");
    }

    public static void assertNull(final Object shouldBeNull){
        if( shouldBeNull != null) throw new IllegalArgumentException("Object is not null.");
    }

    public static void assertNotNull(final Object shouldNotBeNull){
        if( shouldNotBeNull == null) throw new IllegalArgumentException("Object is null.");
    }

    public static void assertTrue(final String message, final boolean condition){
        if(!condition) throw new IllegalArgumentException(message);
    }

    public static void assertFalse(final String message, final boolean condition){
        if(condition) throw new IllegalArgumentException(message);
    }

    public static void assertNull(final String message, final Object shouldBeNull){
        if( shouldBeNull != null) throw new IllegalArgumentException(message);
    }

    public static void assertNotNull(final String message, final Object shouldNotBeNull){
        if( shouldNotBeNull == null) throw new IllegalArgumentException(message);
    }
}
