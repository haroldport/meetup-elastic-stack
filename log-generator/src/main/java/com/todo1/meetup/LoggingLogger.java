package com.todo1.meetup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.String.format;

class LoggingLogger {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private LoggingLogger() {}

    static void generateLoginTrace() {
        logger.debug("Creating Login Trace");
        int status = Helper.getRandomNumberStatus();
        String username = Helper.getRandomUsername();
        String ip = Helper.getRandomIp();
        logger.info(format("LOGIN|%s|%s|%s", status, username, ip));
    }

    static void generatePerformanceTrace() {
        logger.debug("Creating Performance Trace");
        double time = Helper.getRandomTime();
        String action = Helper.getRandomAction();
        String status = Helper.getRandomNameStatus();
        String username = Helper.getRandomUsername();
        logger.info(format("PERFORMANCE|%s|%s|%s|%s", time, action, status, username));
    }

    static void generateExceptionTrace() {
        logger.debug("Creating Error Trace");
        String message = Helper.getRandomMessage();
        try {
            throw new Exception(message);
        } catch (Exception e) {
            logger.error(format("%s|", e.getMessage()), e);
        }
    }

}
