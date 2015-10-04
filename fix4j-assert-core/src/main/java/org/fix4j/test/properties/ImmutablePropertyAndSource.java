package org.fix4j.test.properties;

/**
* User: ben
* Date: 25/09/15
* Time: 5:59 PM
*/
class ImmutablePropertyAndSource implements PropertyAndSource {
    private final String value;
    private final String source;

    public ImmutablePropertyAndSource(final String value, final String source) {
        this.value = value;
        this.source = source;
    }

    @Override
    public String toString() {
        return value + " [" + source + "]";
    }

    public String getValue() {
        return value;
    }

    public String getSource() {
        return source;
    }
}
