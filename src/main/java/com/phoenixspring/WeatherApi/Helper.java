package com.phoenixspring.WeatherApi;

public class Helper {
    public static double convertFToC(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
