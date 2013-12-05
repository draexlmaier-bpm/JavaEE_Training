/*
 */
package com.airhacks.xmas;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author adam-bien.com
 */
public class Configurator {

    @Produces
    public String configurator(InjectionPoint ip) {
        String className = ip.getMember().getDeclaringClass().getName();
        String fieldName = ip.getMember().getName();

        return "merry christmas !" + className + "." + fieldName;
    }
}
