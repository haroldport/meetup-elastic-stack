package com.todo1.meetup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;

class HelloShould {

    @Test
    void greetWithAHelloMessageAndContextToTheNameItReceives() {
        LoggingLogger logger = LoggingLogger.getLogger(HelloShould.class);
        logger.warn("El usuario o password no son correctos", ImmutableMap.of(
                "userId", "haroldport",
                "sessionId", "6B0499873030B5115BC0A839A641494E"
        ));

        Hello hello = new Hello();
        assertEquals("Hello haroldport", hello.sayHello("haroldport"));
    }

    @Test
    void greetWithAHelloMessageAndExceptionAndContextToTheNameItReceives() {
        LoggingLogger logger = LoggingLogger.getLogger(HelloShould.class);
        RuntimeException error = new RuntimeException("Thrown exception");
        logger.error("Se produjo un error al insertar usuario", error, ImmutableMap.of(
                "userId", "ironman",
                "sessionId", "6B0599873030B5115BC0A839A641494F",
                "correlationId", "GTTTHHYYY5554"
        ));

        Hello hello = new Hello();
        assertEquals("Hello ironman", hello.sayHello("ironman"));
    }

}
