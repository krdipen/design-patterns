package com.krdipen.coffee;

public class CaramelDecorator extends CoffeeDecorator {
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return this.coffee.getDescription() + " + Caramel";
    }
    @Override
    public Double getCost() {
        return this.coffee.getCost() + 30.25;
    }
}
