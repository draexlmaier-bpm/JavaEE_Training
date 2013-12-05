/*
 */
package com.airhacks.xmas;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 *
 * @author adam-bien.com
 */
@Startup
@Singleton
public class WishDemon {

    @Resource
    TimerService ts;

    private Timer timer;

    @PostConstruct
    public void init() {
        ScheduleExpression se = new ScheduleExpression();
        se.hour("*").minute("*").second("*/2");
        this.timer = ts.createCalendarTimer(se);

    }

    @Timeout
    public void loadWishes() {
        System.out.println("Expired: " + new Date());
    }

}
