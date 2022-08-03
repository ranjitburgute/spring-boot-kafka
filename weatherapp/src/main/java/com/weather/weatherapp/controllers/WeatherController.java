package com.weather.weatherapp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weather.weatherapp.services.WeatherNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {

    @Autowired
    private WeatherNotificationService weatherNotificationService;

    @RequestMapping(value = "/notification", method = RequestMethod.GET)
    public String getWeather(@RequestParam("city") String city, @RequestParam("country") int country) throws JsonProcessingException {

        return weatherNotificationService.getWeatherReport(city, country);
    }
}
