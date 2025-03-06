package com.phoenixspring.WeatherApi;

import com.phoenixspring.WeatherApi.models.HelloResponse;
import com.phoenixspring.WeatherApi.models.WeatherResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    final WeatherService weatherService;

    @GetMapping("/hello")
    public HelloResponse hello(@RequestParam String  name){
        return new HelloResponse("Hello", name);
    }

    @GetMapping("/weather")
    public WeatherResponseDTO getWeather(@RequestParam String location){
        return weatherService.getWeather(location, LocalDate.now().toString());
    }
}
