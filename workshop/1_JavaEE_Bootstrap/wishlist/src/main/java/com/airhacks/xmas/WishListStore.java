/*
 */
package com.airhacks.xmas;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author adam-bien.com
 */
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
public class WishListStore {

    private List<String> wishes;

    @PostConstruct
    public void inititalize() {
        this.wishes = new CopyOnWriteArrayList<>();
        System.out.println(" ....Initialized!");
    }

    public void add(String wish) {
        this.wishes.add(wish);
    }
}
