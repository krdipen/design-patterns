package com.krdipen.broker;

public class App {
    public static void main(String[] args) {
        Broker broker = new Broker();
        MyConsumer myConsumerA = new MyConsumer((message) -> System.out.println("Consumer A consumed message: " + message));
        MyConsumer myConsumerB = new MyConsumer((message) -> System.out.println("Consumer B consumed message: " + message));
        broker.subscribe("sports", myConsumerA);
        broker.subscribe("politics", myConsumerB);
        broker.publish("sports", "India won the T20 world cup");
        broker.publish("politics", "BJP forms government in Delhi");
        broker.publish("fashion", "Rihana launches new skin care brand");
    }
}
