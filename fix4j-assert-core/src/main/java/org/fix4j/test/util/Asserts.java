package org.fix4j.test.util;

/**
 * User: ben
 * Date: 25/08/2014
 * Time: 4:54 PM
 */

public class Asserts {
    private Asserts() {
    }

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

    public static void assertEquals(final String message, final Object o1, final Object o2) {
        if(o1 == o2) return;
        boolean notEqual = (o1 == null || o2 == null || !o1.equals(o2));
        if(notEqual){
            final String formattedMessage = "Objects are not equal.  o1:" + o1 + " o2:" + o2 + (message == null ? "": ": " + message);
            throw new IllegalArgumentException(formattedMessage);
        }
    }

    public static void assertEquals(final Object o1, final Object o2) {
        assertEquals(null, o1, o2);
    }
}
