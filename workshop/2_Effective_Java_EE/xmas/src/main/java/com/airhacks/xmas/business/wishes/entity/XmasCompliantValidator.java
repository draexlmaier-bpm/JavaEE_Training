/*
 */
package com.airhacks.xmas.business.wishes.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author adam-bien.com
 */
public class XmasCompliantValidator implements ConstraintValidator<XmasCompliant, Wish> {

    @Override
    public void initialize(XmasCompliant constraintAnnotation) {
    }

    @Override
    public boolean isValid(Wish value, ConstraintValidatorContext context) {
        return value.isValid();
    }
}
