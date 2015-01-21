package org.fix4j.test.util;

import java.util.ArrayList;
import java.util.List;

/**
 * User: ben
 * Date: 15/01/15
 * Time: 7:17 AM
 */
public class ExceptionUtils {
    private ExceptionUtils() {
    }

    public static void assertExceptionMessagesContain(Throwable exception, final String str){
        final List<String> messages = new ArrayList<>();
        while(true){
            messages.add(exception.getMessage());
            if(exception.getMessage().contains(str)){
                return;
            } else if(exception.getCause() != null && exception.getCause() != exception && !exception.getCause().equals(exception)){
                exception = exception.getCause();
            } else {
                throw new AssertionError("Exception, and 'chain' of causes, do not have messages which contain text '" + str + "'.  All messages: " + messages);
            }
        }
    }
}
