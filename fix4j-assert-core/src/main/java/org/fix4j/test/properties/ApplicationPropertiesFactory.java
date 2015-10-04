package org.fix4j.test.properties;

/**
 * User: ben
 * Date: 25/09/15
 * Time: 6:44 AM
 */
public class ApplicationPropertiesFactory {
    public ApplicationProperties createApplicationProperties() {
        return createApplicationProperties(null);
    }

    public ApplicationProperties createApplicationProperties(final PropertySource sessionProperties) {
        final CompositePropertyMap.Builder builder = CompositePropertyMap.Builder.create("ALL");
        if(sessionProperties != null) builder.addLast(sessionProperties);
        builder.addLast(new SystemPropertySource());
        builder.addLast(new SystemEnvVariablePropertySource());
        builder.addLast(PropertyKeysAndDefaultValues.getDefaultProperties());
        return builder.build();
    }
}
