package com.krdipen.weather;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation("Cloudy");
        weatherStation.addObserver(new Phone("Alice"));
        weatherStation.addObserver(new Phone("Bob"));
        weatherStation.updateWeather("Sunny");
        weatherStation.updateWeather("Rainy");
    }
}
