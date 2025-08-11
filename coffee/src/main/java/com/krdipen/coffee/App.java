package com.krdipen.coffee;

public class App {
    public static void main(String[] args) {
        Coffee order = new SimpleCoffee();
        System.out.println(order.getDescription() + " $" + order.getCost());

        order = new MilkDecorator(order);
        System.out.println(order.getDescription() + " $" + order.getCost());

        order = new CaramelDecorator(order);
        System.out.println(order.getDescription() + " $" + order.getCost());
    }
}
