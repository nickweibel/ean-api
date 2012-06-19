/**
 * Created with IntelliJ IDEA.
 * User: ejelinek
 * Date: 6/11/12
 * Time: 9:09 PM
 * To change this template use File | Settings | File Templates.
 */
package com.ean.xml.util;

import org.apache.log4j.Logger;

public final class EanLogger {
    private static Logger logger = Logger.getLogger(EanLogger.class);
    private static EanLogger instance;

    public static EanLogger getInstance() {
        if (instance == null) {
            instance = new EanLogger();
        }

        return instance;
    }

    public void logException(Exception ex) {
        logger.error(ex.getMessage());

    }
}
