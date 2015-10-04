package org.fix4j.test.properties;

import org.fix4j.test.util.Keyable;

/**
 * User: ben
 * Date: 4/12/14
 * Time: 10:32 AM
 */
public interface ApplicationProperties {
    public static class Singleton{
        private static ApplicationProperties instance;

        public static ApplicationProperties instance(){
            if(instance == null) {
                instance = new ApplicationPropertiesFactory().createApplicationProperties();
            }
            return instance;
        }

        public static void setInstance(final ApplicationProperties applicationProperties){
            instance = applicationProperties;
        }
    }

    public String getAsString(final String key);
    public String getAsString(final String key, final String defaultValue);

    public String getAsString(final Keyable<String> key);
    public String getAsString(final Keyable<String> key, final String defaultValue);

    public Boolean getAsBoolean(final String key);
    public Boolean getAsBoolean(final String key, final Boolean defaultValue);

    public Boolean getAsBoolean(final Keyable<String> key);
    public Boolean getAsBoolean(final Keyable<String> key, final Boolean defaultValue);

    public Integer getAsInt(final String key);
    public Integer getAsInt(final String key, final Integer defaultValue);

    public Integer getAsInt(final Keyable<String> key);
    public Integer getAsInt(final Keyable<String> key, final Integer defaultValue);

    public Double getAsDouble(final String key);
    public Double getAsDouble(final String key, final Double defaultValue);

    public Double getAsDouble(final Keyable<String> key);
    public Double getAsDouble(final Keyable<String> key, final Double defaultValue);

    public Long getAsLong(final String key);
    public Long getAsLong(final String key, final Long defaultValue);

    public Long getAsLong(final Keyable<String> key);
    public Long getAsLong(final Keyable<String> key, final Long defaultValue);
}
