package com.phoenixspring.WeatherApi;

import com.phoenixspring.WeatherApi.config.VisualCrossingConfig;
import com.phoenixspring.WeatherApi.error.WeatherServiceException;

import com.phoenixspring.WeatherApi.models.WeatherResponseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final VisualCrossingConfig visualCrossingConfig;
    private  final  RestTemplate restTemplate;
    private static final Logger log = LoggerFactory.getLogger(WeatherApiApplication.class);


    @Cacheable(value = "weather", key = "{#location, #date}")
    public WeatherResponseDTO getWeather(String location, String date){
        log.info("Getting weather for location: " + location + " and date: " + date);
        log.info("VisualCrossingConfig base url: " + visualCrossingConfig.getBaseUrl());
        String url = UriComponentsBuilder.fromHttpUrl(visualCrossingConfig.getBaseUrl())
                .path("/" + location + "/" + date)
                .queryParam("key", visualCrossingConfig.getApiKey())
                .toUriString();
      ResponseEntity<WeatherResponseDTO> response = restTemplate.getForEntity(url,
              WeatherResponseDTO.class);

      if (response.getStatusCode().is2xxSuccessful()){
          return response.getBody();
      }else{
          throw new WeatherServiceException("Failed to fetch weather data");
      }

    }


}
