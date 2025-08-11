package com.krdipen.broker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Broker {
    private final Map<String, List<MyConsumer>> myConsumersMap;

    public Broker() {
        this.myConsumersMap = new HashMap<>();
    }

    public void publish(String topic, String message) {
        if (myConsumersMap.containsKey(topic)) {
            myConsumersMap.get(topic).forEach( myConsumer -> {
                myConsumer.send(message);
            });
        }
    }

    public void subscribe(String topic, MyConsumer myConsumer) {
        myConsumersMap.putIfAbsent(topic, new ArrayList<>());
        myConsumersMap.get(topic).add(myConsumer);
    }
}
