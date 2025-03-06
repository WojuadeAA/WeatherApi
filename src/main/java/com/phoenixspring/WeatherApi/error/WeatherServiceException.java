package com.phoenixspring.WeatherApi.error;



public class WeatherServiceException extends RuntimeException {
    public WeatherServiceException(String message) {
        super(message);
    }
}