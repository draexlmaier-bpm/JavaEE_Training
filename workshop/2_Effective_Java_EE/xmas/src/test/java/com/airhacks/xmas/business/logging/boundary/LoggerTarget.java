/*
 */
package com.airhacks.xmas.business.logging.boundary;

import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author adam-bien.com
 */
public class LoggerTarget {

    @Inject
    Logger logger;

    public Logger getLogger() {
        return logger;
    }

}
