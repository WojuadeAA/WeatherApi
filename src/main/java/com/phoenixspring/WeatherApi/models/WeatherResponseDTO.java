package com.phoenixspring.WeatherApi.models;

import com.phoenixspring.WeatherApi.models.Day;

import java.io.Serializable;
import java.util.List;

public record WeatherResponseDTO(
        int queryCost,
        double latitude,
        double longitude,
        String resolvedAddress,
        String address,
        String timezone,
        List<Day> days
) implements Serializable {
}
