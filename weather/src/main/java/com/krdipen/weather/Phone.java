package com.krdipen.weather;

public class Phone implements Observer {
    private String owner;

    public Phone(String owner) {
        this.owner = owner;
    }

    @Override
    public void update(String weather) {
        System.out.println(owner + "'s Phone: " + weather);
    }
}
