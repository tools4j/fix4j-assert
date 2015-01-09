package org.fix4j.test.integration;

import org.fix4j.test.plumbing.Consumer;

/**
 * F = From
 * T = To
 *
 * User: ben
 * Date: 14/08/2014
 * Time: 2:53 PM
 */
public interface MessageConverter<F,T>  {
    Consumer<F> convertAndSendMessagesTo(Consumer<T> messageConsumer);
    T convert(F message);
}
