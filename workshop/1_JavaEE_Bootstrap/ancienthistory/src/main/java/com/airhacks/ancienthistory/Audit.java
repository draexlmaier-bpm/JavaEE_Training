/*
 */
package com.airhacks.ancienthistory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author adam-bien.com
 */
public class Audit implements InvocationHandler {

    private Object target;

    public Audit(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            System.out.println("Before: " + method.getName());
            for (Object arg : args) {
                System.out.println("Argument: " + arg);
            }
            return method.invoke(target, args);
        } finally {
            System.out.println("After: " + method.getName());
        }
    }

}
