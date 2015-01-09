package org.fix4j.test.properties;

import org.fix4j.test.util.Keyable;
import org.fix4j.test.util.StringUtils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: ben
 * Date: 3/12/14
 * Time: 5:00 PM
 */
public class CompositePropertyMap implements PropertySource, ApplicationProperties{
    private final Map<String, PropertyAndSource> properties;
    private final String sourceName;

    private CompositePropertyMap(Map<String, PropertyAndSource> properties, final String sourceName) {
        this.properties = Collections.unmodifiableMap(properties);

        this.sourceName = sourceName;
    }

    @Override
    public String getAsString(final Keyable<String> key){
        return getAsString(key.getKey());
    }

    @Override
    public String getAsString(final Keyable<String> key, final String defaultValue){
        return getAsString(key.getKey(), defaultValue);
    }

    @Override
    public Boolean getAsBoolean(final Keyable<String> key){
        return getAsBoolean(key.getKey());
    }

    @Override
    public Boolean getAsBoolean(final Keyable<String> key, final Boolean defaultValue){
        return getAsBoolean(key.getKey(), defaultValue);
    }

    @Override
    public Integer getAsInt(final Keyable<String> key){
        return getAsInt(key.getKey());
    }

    @Override
    public Integer getAsInt(final Keyable<String> key, final Integer defaultValue){
        return getAsInt(key.getKey(), defaultValue);
    }

    @Override
    public Double getAsDouble(final Keyable<String> key){
        return getAsDouble(key.getKey());
    }

    @Override
    public Double getAsDouble(final Keyable<String> key, final Double defaultValue){
        return getAsDouble(key.getKey(), defaultValue);
    }

    @Override
    public Long getAsLong(final Keyable<String> key){
        return getAsLong(key.getKey());
    }

    @Override
    public Long getAsLong(final Keyable<String> key, final Long defaultValue){
        return getAsLong(key.getKey(), defaultValue);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final String key : properties.keySet()) {
            sb.append(key).append("=").append(properties.get(key)).append("\n");
        }
        return StringUtils.indentAllLines(sb.toString());
    }

    @Override
    public String getAsString(final String key) {
        if(!properties.containsKey(key)) return null;
        else return properties.get(key).value;
    }

    @Override
    public String getAsString(final String key, final String defaultValue) {
        final String value = getAsString(key);
        if(value != null) return value;
        else return defaultValue;
    }

    @Override
    public Boolean getAsBoolean(final String key) {
        if(!properties.containsKey(key)) return null;
        final String value = properties.get(key).value;
        if(!(value.equalsIgnoreCase("true") || value.contentEquals("false"))){
            throw new IllegalArgumentException("Value does not equal 'true' or 'false'.  Value:" + value);
        }
        return Boolean.valueOf(properties.get(key).value);
    }

    @Override
    public Boolean getAsBoolean(final String key, final Boolean defaultValue) {
        final Boolean value = getAsBoolean(key);
        if(value != null) return value;
        else return defaultValue;
    }

    @Override
    public Integer getAsInt(final String key) {
        if(!properties.containsKey(key)) return null;
        else return Integer.valueOf(properties.get(key).value);
    }

    @Override
    public Integer getAsInt(final String key, final Integer defaultValue) {
        final Integer value = getAsInt(key);
        if(value != null) return value;
        else return defaultValue;
    }

    @Override
    public Double getAsDouble(final String key) {
        if(!properties.containsKey(key)) return null;
        else return Double.valueOf(properties.get(key).value);
    }

    @Override
    public Double getAsDouble(final String key, final Double defaultValue) {
        final Double value = getAsDouble(key);
        if(value != null) return value;
        else return defaultValue;
    }

    @Override
    public Long getAsLong(final String key) {
        if(!properties.containsKey(key)) return null;
        else return Long.valueOf(properties.get(key).value);
    }

    @Override
    public Long getAsLong(final String key, final Long defaultValue) {
        final Long value = getAsLong(key);
        if(value != null) return value;
        else return defaultValue;
    }

    @Override
    public String getSourceName() {
        return sourceName;
    }

    @Override
    public Map<String, String> getProperties() {
        final Map<String, String> properties = new LinkedHashMap<>();
        for (final String key : this.properties.keySet()) {
            properties.put(key, this.properties.get(key).value);
        }
        return properties;
    }

    public static class Builder{
        private final Map<String, PropertyAndSource> properties = new LinkedHashMap<>();
        private final String sourceName;

        public static Builder create(final String sourceName){
            return new Builder(sourceName);
        }

        private Builder(final String sourceName) {
            this.sourceName = sourceName;
        }

        /**
         * Add the given property source object with lowest precedence of all sources added
         * so far.
         *
         * @param propertySource
         * @return this
         */
        public Builder addLast(final PropertySource propertySource){
            if(propertySource != null) {
                for (final String key : propertySource.getProperties().keySet()) {
                    if (!this.properties.containsKey(key)) {
                        this.properties.put(key, new PropertyAndSource(propertySource.getProperties().get(key), propertySource.getSourceName()));
                    }
                }
            }
            return this;
        }

        public CompositePropertyMap build(){
            return new CompositePropertyMap(properties, sourceName);
        }
    }

    private static class PropertyAndSource {
        public final String value;
        public final String source;

        public PropertyAndSource(final String value, final String source) {
            this.value = value;
            this.source = source;
        }

        @Override
        public String toString() {
            return value + " [" + source + "]";
        }
    }
}
