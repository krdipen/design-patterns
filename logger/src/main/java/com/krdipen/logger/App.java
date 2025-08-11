package com.krdipen.logger;

public class App {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("INFO", "application started");
        logger2.log("ERROR", "something went wrong");
        System.out.println("same instance? " + (logger1 == logger2));
    }
}
