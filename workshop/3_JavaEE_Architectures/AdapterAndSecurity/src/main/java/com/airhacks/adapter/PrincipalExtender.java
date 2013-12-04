/*
 */
package com.airhacks.adapter;

import java.security.Principal;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adam-bien.com
 */
public class PrincipalExtender {

    @Inject
    Principal principal;

    @PersistenceContext
    EntityManager em;

    @Produces
    public AirhacksPrincipal expose() {
        return em.find(AirhacksPrincipal.class, principal.getName());
    }

}
