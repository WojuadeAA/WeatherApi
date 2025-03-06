package com.phoenixspring.WeatherApi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "visualcrossing")
@Data
public class VisualCrossingConfig {
    private  String apiKey;
    private String baseUrl;

}
