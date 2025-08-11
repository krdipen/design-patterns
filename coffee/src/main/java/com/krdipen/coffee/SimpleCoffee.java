package com.krdipen.coffee;

public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public Double getCost() {
        return 100.0;
    }
}
