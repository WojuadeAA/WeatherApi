package com.phoenixspring.WeatherApi.models;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.io.Serializable;
import java.util.List;

public record Day(String datetime, long dateTimeEpoch,
                  double tempmax, double tempmin,
                  double temp, double feelslike,
                  double feelslikemax, double feelslikemin,
                  double dew, double humidity,
                  double precipprob,
                  double precipcover,
                  Object preciptype,
                  double snow,
                  double snowdepth,
                  double windgust,
                  double windspeed,
                  double winddir,
                  double pressure,
                  double cloudcover,
                  double visibility,
                  double solarradiation,
                  double solarenergy,
                  double uvindex,
                  String sunrise,
                  long sunriseEpoch,
                  String sunset,
                  long sunsetEpoch,
                  double moonphase,
                  String conditions,
                  String description,
                  String icon,
                  List<String> stations,
                  String source,
                    List<Hour> hours
                  ) implements Serializable {

    @JsonGetter
    public double tempMaxCelsius(){
        return (tempmax - 32) * 5/9;
    }
}
