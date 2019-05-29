package com.todo1.meetup;

import com.google.common.collect.ImmutableMap;

public class Hello {

    public String sayHello(String name) {
        LoggingLogger logger = LoggingLogger.getLogger(Hello.class);
        logger.info("Mensaje de saludo a usuario", ImmutableMap.of(
                "userId", name,
                "sessionId", "6B0599873030B5115BC0A839A641494F"
        ));
        return String.format("Hello %s", name);
    }

}
