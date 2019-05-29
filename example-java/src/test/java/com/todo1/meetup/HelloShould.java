package com.todo1.meetup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class HelloShould {

    @Test
    void greetWithAHelloMessageToTheNameItReceives() {
        Logger logger = LogManager.getLogger(HelloShould.class);
        logger.error("Hello World!");

        Hello hello = new Hello();
        assertEquals("Hello Harold", hello.sayHello("Harold"));
    }

    @Test
    void greetWithAHelloExceptionMessageToTheNameItReceives() {
        Logger logger = LogManager.getLogger(HelloShould.class);
        RuntimeException error = new RuntimeException("Thrown exception");
        logger.error("Hello Error", error);

        Hello hello = new Hello();
        assertEquals("Hello Peter", hello.sayHello("Peter"));
    }

}
