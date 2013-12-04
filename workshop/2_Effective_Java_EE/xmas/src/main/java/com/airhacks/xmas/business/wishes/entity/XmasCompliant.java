/*
 */
package com.airhacks.xmas.business.wishes.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author adam-bien.com
 */
@Documented
@Constraint(validatedBy = {XmasCompliantValidator.class})
@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface XmasCompliant {

    boolean atMidnight();

    String message() default "Give it to someone else";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
