package com.todo1.meetup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Map;

public class LoggingLogger {

    private Logger logger;

    private LoggingLogger(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public static LoggingLogger getLogger(Class<?> clazz) {
        return new LoggingLogger(clazz);
    }

    public void info(String message, Map<String, Object> context) {
        addContextParameters(context, () -> logger.info(message));
    }

    public void warn(String message, Map<String, Object> context) {
        addContextParameters(context, () -> logger.warn(message));
    }

    public void error(String message, Map<String, Object> context) {
        addContextParameters(context, () -> logger.error(message));
    }

    public void info(String message, Throwable cause) {
        logger.info(message, cause);
    }

    public void warn(String message, Throwable cause) {
        logger.warn(message, cause);
    }

    public void error(String message, Throwable cause) {
        logger.error(message, cause);
    }

    public void info(String message, Throwable cause, Map<String, Object> context) {
        addContextParameters(context, () -> logger.info(message, cause));
    }

    public void warn(String message, Throwable cause, Map<String, Object> context) {
        addContextParameters(context, () -> logger.warn(message, cause));
    }

    public void error(String message, Throwable cause, Map<String, Object> context) {
        addContextParameters(context, () -> logger.error(message, cause));
    }

    private void addContextParameters(Map<String, Object> context, Runnable customFunction) {
        context.forEach((key, value) -> MDC.put(key, value.toString()));
        customFunction.run();
        MDC.clear();
    }

}
