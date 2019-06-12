package com.todo1.meetup;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Helper {

    static String getRandomUsername() {
        List<String> usersList = Arrays.asList(
                "spiderman", "ironMan", "blackPanter", "captainAmerica", "antMan", "captainMarvel",
                "lukeCage", "thanos", "thor", "hulk", "warMachine", "doctorStrange",
                "blackWidow", "bucky", "calypso", "venom", "hawkEye", "scarletWitch"
        );
        Random rand = new Random();
        return usersList.get(rand.nextInt(usersList.size()));
    }

    static int getRandomNumberStatus() {
        List<Integer> statusList = Arrays.asList(200, 202, 204, 100, 201, 150, 250, 400, 404, 500);
        Random rand = new Random();
        return statusList.get(rand.nextInt(statusList.size()));
    }

    static double getRandomTime() {
        Random r = new Random();
        return (double) r.nextInt(8000) / 1000;
    }

    static String getRandomNameStatus() {
        List<String> statusList = Arrays.asList("SUCCESS", "FAILURE");
        Random rand = new Random();
        return statusList.get(rand.nextInt(statusList.size()));
    }

    static String getRandomIp() {
        Random r = new Random();
        return String.format("%d.%d.%d.%d", r.nextInt(256), r.nextInt(256),
                r.nextInt(256), r.nextInt(256));
    }

    static String getRandomAction() {
        List<String> actionList = Arrays.asList(
                "LOGIN", "EXPORT DATA", "DOWNLOAD DOCUMENT", "SEND EMAIL", "CREATE USER", "DELETE USER"
        );
        Random rand = new Random();
        return actionList.get(rand.nextInt(actionList.size()));
    }

    static String getRandomMessage() {
        List<String> messageList = Arrays.asList(
                "Error creating user",
                "Lazy Loading is not allowed in this context",
                "User can not be null. Can not fetch information from the database",
                "Error connecting to database",
                "Current user is not able to perform this action",
                "Document not found",
                "User not found",
                "Email error: can not connect to SMTP Server",
                "Invalid credentials. User will be flag as inactive",
                "Number expected",
                "Form can not be validated due to some database issue"
        );
        Random rand = new Random();
        return messageList.get(rand.nextInt(messageList.size()));
    }

}
