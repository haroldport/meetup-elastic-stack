package com.todo1.meetup;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String COMMAND_DELAY = "-d";
    private static final String COMMAND_ITERATIONS = "-i";
    private static long timeDelay;
    private static int numberOfIterations;

    public static void main(String[] args) throws InterruptedException {
        List<String> parameters = Arrays.asList(args);
        boolean hasDelayParam = parameters.stream().anyMatch(x -> x.equals(COMMAND_DELAY));
        boolean hasIterationParam = parameters.stream().anyMatch(x -> x.equals(COMMAND_ITERATIONS));
        if(!hasDelayParam && !hasIterationParam) {
            setDefaultValues();
            System.out.println("The delay (-d) configuration and number of iterations (-i) were not indicated, the default values will be used.");
        }
        if(args.length > 4) throw new IndexOutOfBoundsException("Many arguments were sent");
        if(args.length == 0) setDefaultValues();
        if(args.length > 0) {
            if(args[0].equals(COMMAND_DELAY)) timeDelay = Long.parseLong(args[1]);
            if(args[0].equals(COMMAND_ITERATIONS)) numberOfIterations = Integer.parseInt(args[1]);
            if(args[2].equals(COMMAND_ITERATIONS)) numberOfIterations = Integer.parseInt(args[3]);
            if(args[2].equals(COMMAND_DELAY)) timeDelay = Long.parseLong(args[3]);
            if(timeDelay <= 0 && numberOfIterations <= 0) setDefaultValues();
            generateTraces();
        }
    }

    private static void setDefaultValues() {
        timeDelay = 1000;
        numberOfIterations = 50;
    }

    private static void generateTraces() throws InterruptedException {
        int count = 0;
        while(count <= numberOfIterations) {
            if (count % 5 == 0) LoggingLogger.generateLoginTrace();
            if (count % 2 == 0) LoggingLogger.generatePerformanceTrace();
            if (count % 20 == 0) LoggingLogger.generateExceptionTrace();
            count++;
            Thread.sleep(timeDelay);
        }
    }

}
