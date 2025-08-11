package com.krdipen.notification;

public class PushNotification implements Notification {
    public void notifyUser(String message) {
        System.out.println("Sending PUSH: " + message);
    }
}
