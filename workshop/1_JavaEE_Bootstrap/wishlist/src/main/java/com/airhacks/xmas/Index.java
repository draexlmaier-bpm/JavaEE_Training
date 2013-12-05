/*
 */
package com.airhacks.xmas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.validation.constraints.Size;

/**
 *
 * @author adam-bien.com
 */
@Model
public class Index {

    @Inject
    WishListService service;

    @Size(min = 3, max = 5)
    private String candidate;

    @PostConstruct
    public void initialize() {
        System.out.println("Created CDI POJO");
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public Object save() {
        List<Future<Boolean>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(service.validate(candidate + i));
        }
        for (Future<Boolean> future : futures) {
            try {
                System.out.println("--- " + future.get());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @PreDestroy
    public void destroyed() {
        System.out.println("Destroying POJO");
    }

}
