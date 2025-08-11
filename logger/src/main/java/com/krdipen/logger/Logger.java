package com.krdipen.logger;

// thread-safe singleton with double-checked locking
public class Logger {
    private static volatile Logger instance;

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    private Logger() {

    }

    public void log(String level, String message) {
        System.out.println("[" + level + "] " + message);
    }
}
