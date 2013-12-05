/*
 */
package com.airhacks.xmas;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 *
 * @author adam-bien.com
 */
public class BatchMonitoring {

    public void onSuccess(@Observes(during = TransactionPhase.AFTER_SUCCESS) String msg) {
        System.out.println("+++++Observed: !" + msg);
    }

    public void onError(@Observes(during = TransactionPhase.AFTER_FAILURE) String msg) {
        System.out.println("------Observed: !" + msg);
    }

}
