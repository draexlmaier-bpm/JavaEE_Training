/*
 */
package com.airhacks.xmas.business.wishes.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author adam-bien.com
 */
public class WishIT {

    EntityManager em;
    EntityTransaction tx;

    @Before
    public void initialize() {
        this.em = Persistence.createEntityManagerFactory("integration-test").createEntityManager();
        this.tx = this.em.getTransaction();
    }

    @Test
    public void crud() {
        this.tx.begin();
        this.em.merge(new Wish("duke", 12));
        this.tx.commit();
    }

}
