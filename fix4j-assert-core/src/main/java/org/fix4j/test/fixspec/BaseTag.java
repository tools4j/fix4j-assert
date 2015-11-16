package org.fix4j.test.fixspec;

/**
 * User: ben
 * Date: 12/09/2014
 * Time: 5:18 AM
 */
public class BaseTag<T> implements Tag<T> {
    private final T value;

    public static BaseTag<Integer> create(int value){
        return new BaseTag<>(value);
    }

    public static BaseTag<String> create(String value){
        return new BaseTag<>(value);
    }

    public BaseTag(final T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        final Tag<?> baseTag = (Tag<?>) o;
        if (!value.equals(baseTag.getValue())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
