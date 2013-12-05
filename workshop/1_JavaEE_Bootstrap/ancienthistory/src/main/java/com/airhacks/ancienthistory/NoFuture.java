/*
 */
package com.airhacks.ancienthistory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author adam-bien.com
 */
public class NoFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService tp = Executors.newCachedThreadPool();
        Callable<Boolean> c = new Callable<Boolean>() {

            public Boolean call() throws Exception {
                return true;
            }
        };
        Future<Boolean> future = tp.submit(c);
        Boolean result = future.get();
        System.out.println("The result is: " + result);

    }

}
