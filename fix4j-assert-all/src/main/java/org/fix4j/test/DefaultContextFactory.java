package org.fix4j.test;

import org.fix4j.spec.fix50sp2.FixSpec;
import org.fix4j.test.fixspec.FixSpecification;
import org.fix4j.test.integration.FixEngineSessionFactory;
import org.fix4j.test.integration.quickfix.QuickFixTestSessionFactory;
import org.fix4j.test.properties.ApplicationProperties;
import org.fix4j.test.session.AbstractContextFactory;

import java.util.Map;
import java.util.Properties;

/**
 * User: ben
 * Date: 9/12/14
 * Time: 4:50 PM
 */
public class DefaultContextFactory extends AbstractContextFactory {

    public DefaultContextFactory() {
        super(FixSpec.INSTANCE);
    }

    @Override
    protected FixEngineSessionFactory createFixEngineSessionFactory(final FixSpecification fixSpecification) {
        return new QuickFixTestSessionFactory(fixSpecification);
    }
}
