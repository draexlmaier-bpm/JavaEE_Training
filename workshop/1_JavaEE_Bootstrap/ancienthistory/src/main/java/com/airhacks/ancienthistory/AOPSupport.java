/*
 */
package com.airhacks.ancienthistory;

import java.lang.reflect.Proxy;

/**
 *
 * @author adam-bien.com
 */
public class AOPSupport {

    public static Object aop(Object input) {
        Class<? extends Object> clazz = input.getClass();
        Class<?>[] interfaces = clazz.getInterfaces();
        ClassLoader classLoader = clazz.getClassLoader();
        return Proxy.newProxyInstance(classLoader, interfaces, new Audit(input));
    }
}
