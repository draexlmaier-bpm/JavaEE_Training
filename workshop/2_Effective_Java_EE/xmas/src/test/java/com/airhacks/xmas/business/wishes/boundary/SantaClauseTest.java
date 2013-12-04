/*
 */
package com.airhacks.xmas.business.wishes.boundary;

import com.airhacks.xmas.business.wishes.control.BudgetController;
import com.airhacks.xmas.business.wishes.control.RudolphTransporter;
import com.airhacks.xmas.business.wishes.entity.Wish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author adam-bien.com
 */
@RunWith(MockitoJUnitRunner.class)
public class SantaClauseTest {

    @InjectMocks
    SantaClause cut;

    @Mock
    BudgetController bc;

    @Mock
    RudolphTransporter rt;

    @Test(expected = IllegalStateException.class)
    public void saveWithPessimisticController() {
        this.cut.save(new Wish());
    }

    @Test
    public void saveWithSufficientBudget() {
        Wish wish = new Wish();
        when(this.bc.isInBudget(wish)).thenReturn(true);
        this.cut.save(wish);
        verify(this.rt, times(1)).makeItHappen(wish);
    }

}
