package com.krdipen.broker;

import java.util.function.Consumer;

public class MyConsumer {
    private final Consumer<String> consumer;

    public MyConsumer(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    public void send(String message) {
        consumer.accept(message);
    }
}
