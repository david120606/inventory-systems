package com.dsa.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerApp {
    private static final Logger logger = LoggerFactory.getLogger(LoggerApp.class);

    LoggerApp() {
    }

    public static void info(String var1, Object... var2) {
        logger.info(var1, var2);
    }

    public static void error(String var1, Object... var2) {
        logger.error(var1, var2);
    }
}
