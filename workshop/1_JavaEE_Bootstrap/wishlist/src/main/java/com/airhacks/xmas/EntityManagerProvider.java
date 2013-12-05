/*
 */
package com.airhacks.xmas;

import java.security.Principal;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adam-bien.com
 */
public class EntityManagerProvider {

    @PersistenceContext(unitName = "prod")
    EntityManager em;

    @Inject
    Principal authenticatedUser;

    @Produces
    public EntityManager provide() {
        if ("duke".equals(this.authenticatedUser.getName())) {
            return em;
        }
        return em;
    }
}
