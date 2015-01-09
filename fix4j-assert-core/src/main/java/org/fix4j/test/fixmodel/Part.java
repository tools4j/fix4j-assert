package org.fix4j.test.fixmodel;

import org.fix4j.test.fixspec.Tag;
import org.fix4j.test.fixspec.Type;

/**
 * User: ben
 * Date: 25/08/2014
 * Time: 8:52 PM
 */
public interface Part<T extends Type> {
    Tag<?> getTag();
    T getType();
}
