/*
 */
package com.airhacks.xmas;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 *
 * @author adam-bien.com
 */
@Stateless
public class WishListService {

    @PersistenceContext(unitName = "prod")
    EntityManager em;

    @Resource(mappedName = "jdbc/sample")
    DataSource ds;

    @Inject
    Event<String> events;

    @PostConstruct
    public void initialize() {
        System.out.println("Created EJB");
    }

    public String getWishList() {
        return "lego,java no puzzle";
    }

    @Resource
    SessionContext sc;

    @PreDestroy
    public void destroyed() {
        System.out.println("Destroying EJB");
    }

    @Asynchronous
    public Future<Boolean> validate(String candidate) {
        events.fire(candidate);
        try {
            if (sc.wasCancelCalled()) {
                //break here....
                System.out.println("Cancel called!");
            }

            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(WishListService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("-- " + candidate);
        sc.setRollbackOnly();
        return new AsyncResult<>(true);
    }

    public Wish save(Wish wish) {
        System.out.println("A datasource: " + this.ds);
        Wish result = this.em.merge(wish);
        this.em.flush();
        this.em.refresh(result);
        return result;
    }

    public Wish find(int id) {
        return this.em.find(Wish.class, id);
    }

}
