/*
 */
package com.airhacks.xmas;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author adam-bien.com
 */
public class Audit {

    @AroundInvoke
    public Object auditMethod(InvocationContext ic) throws Exception {
        try {
            System.out.println("Before: " + ic.getMethod());
            return ic.proceed();
        } finally {
            System.out.println("After: " + ic.getMethod());
        }
    }
}
