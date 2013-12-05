/*
 */
package com.airhacks.xmas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author adam-bien.com
 */
@Qualifier
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Season {

    Value value();

    enum Value {

        WINTER, SPRING
    }
}
