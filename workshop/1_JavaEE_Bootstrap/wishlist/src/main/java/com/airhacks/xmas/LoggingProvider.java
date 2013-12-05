/*
 */
package com.airhacks.xmas;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author adam-bien.com
 */
public class LoggingProvider {

    @Produces
    public Logger provide(InjectionPoint ip) {
        return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
    }

}
