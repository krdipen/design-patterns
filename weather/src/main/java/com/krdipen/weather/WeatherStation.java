package com.krdipen.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private final List<Observer> observers;
    private String weather;

    public WeatherStation(String weather) {
        this.weather = weather;
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void updateWeather(String weather) {
        this.weather = weather;
        notifyObservers(this.weather);
    }

    public void notifyObservers(String weather) {
        observers.forEach(observer -> observer.update(weather));
    }
}
