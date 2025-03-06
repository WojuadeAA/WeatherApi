package com.phoenixspring.WeatherApi.models;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.io.Serializable;
import java.util.List;

public record Hour(
        String datetime,
        long datetimeEpoch,
        double tempmax,
        double tempmin,
        double temp,

        double feelslike,
        double humidity,
        double dew,
        double precip,
        double precipprob,
        double snow,
        double snowdepth,

        double windgust,
        double windspeed,
        double winddir,
        double pressure,
        Double visibility,  // Use wrapper class for null handling
        double cloudcover,
        double solarradiation,
        double solarenergy,
        double uvindex,
        String conditions,
        String icon,
        List<String> stations,
        String source) implements Serializable {
    @JsonGetter("tempmaxC")
    public double tempmaxC() {
        return convertFToC(tempmax);
    }

    @JsonGetter("tempminC")
    public double tempminC() {
        return convertFToC(tempmin);
    }

    @JsonGetter("tempC")
    public double tempC() {
        return convertFToC(temp);
    }

    @JsonGetter("feelslikeC")
    public double feelslikeC() {
        return convertFToC(feelslike);
    }
    private double convertFToC(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}