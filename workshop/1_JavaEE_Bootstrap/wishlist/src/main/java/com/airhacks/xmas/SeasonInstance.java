/*
 */
package com.airhacks.xmas;

import java.lang.annotation.Annotation;

/**
 *
 * @author adam-bien.com
 */
public class SeasonInstance implements Season {

    Value value;

    public SeasonInstance(Value value) {
        this.value = value;
    }

    @Override
    public Value value() {
        return this.value;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return Season.class;
    }

}
