package com.krdipen.coffee;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + " + Milk";
    }

    @Override
    public Double getCost() {
        return this.coffee.getCost() + 50.0;
    }
}
