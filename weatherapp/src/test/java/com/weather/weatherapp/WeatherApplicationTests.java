package com.weather.weatherapp;

import com.weather.weatherapp.controllers.WeatherController;
import com.weather.weatherapp.services.WeatherNotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WeatherApplicationTests {

    @Autowired
    private WeatherNotificationService weatherNotificationService;

    @Autowired
    private WeatherController weatherController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(weatherNotificationService).isNotNull();
        assertThat(weatherController).isNotNull();
    }
}
