package com.krdipen.notification;

public class App {
    public static void main(String[] args) {
        Notification emailNotification = NotificationFactory.getNotification("EMAIL");
        emailNotification.notifyUser("notifying over email");

        Notification smsNotification = NotificationFactory.getNotification("SMS");
        smsNotification.notifyUser("notifying over sms");

        Notification pushNotification = NotificationFactory.getNotification("PUSH");
        pushNotification.notifyUser("notifying over push");
    }
}
