/*
 */
package com.airhacks.xmas.business.logging.boundary;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author adam-bien.com
 */
public class LoggerProducer {

    @Produces
    public Logger expose(InjectionPoint ip) {
        return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
    }

}
