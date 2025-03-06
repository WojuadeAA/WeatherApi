package com.phoenixspring.WeatherApi.models;

import java.io.Serializable;

public record Station(
        double distance,
        double latitude,
        double longitude,
        int useCount,
        String id,
        String name,
        int quality,
        int contribution) implements Serializable {
}
