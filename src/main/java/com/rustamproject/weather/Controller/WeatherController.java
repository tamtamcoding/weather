package com.rustamproject.weather.Controller;

import java.text.ParseException;
import java.util.List;

import com.rustamproject.weather.Models.Example;
import com.rustamproject.weather.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;



@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("forecast/{city}")
    public List<Example> getWeatherForFive(
            @PathVariable String city) throws ParseException {
        return this.weatherService.getWeatherForFive(city);
    }

    @RequestMapping("weather/{city}")
    public List<Example> getWeather(
            @PathVariable String city) {
        return this.weatherService.getWeather(city);
    }



}
