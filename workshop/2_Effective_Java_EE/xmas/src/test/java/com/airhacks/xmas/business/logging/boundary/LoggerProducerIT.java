/*
 */
package com.airhacks.xmas.business.logging.boundary;

import java.util.logging.Logger;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author adam-bien.com
 */
@RunWith(Arquillian.class)
public class LoggerProducerIT {

    @Inject
    LoggerTarget cut;

    @Deployment
    public static WebArchive create() {
        return ShrinkWrap.create(WebArchive.class).
                addClasses(LoggerProducer.class, LoggerTarget.class).
                addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void logInjection() {
        Logger logger = cut.getLogger();
        assertTrue(logger.getName().equalsIgnoreCase(cut.getClass().getName()));
    }

}
