/*
 */
package com.airhacks.xmas.business.wishes.boundary;

import com.airhacks.xmas.business.wishes.control.BudgetController;
import com.airhacks.xmas.business.wishes.control.RudolphTransporter;
import com.airhacks.xmas.business.wishes.entity.Wish;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author adam-bien.com
 */
@Stateless
public class SantaClause {

    @Inject
    private BudgetController bc;

    @Inject
    private RudolphTransporter rt;

    public void save(Wish wish) {
        if (!bc.isInBudget(wish)) {
            throw new IllegalStateException("I'm really sad!");
        }
        rt.makeItHappen(wish);
    }
}
