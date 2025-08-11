package com.krdipen.notification;

import java.util.Map;

public class NotificationFactory {
    private static Map<String, Notification> notificationMap = Map.of("EMAIL", new EmailNotification(),
            "SMS", new SMSNotification(), "PUSH", new SMSNotification());

    public static Notification getNotification(String name) {
        return notificationMap.get(name);
    }
}
