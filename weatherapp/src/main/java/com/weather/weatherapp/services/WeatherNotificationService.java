package com.weather.weatherapp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.weatherapp.entities.reports.CityWeatherReport;
import com.weather.weatherapp.entities.reports.WeatherReport;
import com.weather.weatherapp.entities.weather.Temperature;
import com.weather.weatherapp.entities.weather.Weather;
import com.weather.weatherapp.entities.weather.WeatherDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherNotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherNotificationService.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${endpoint.apiKey}")
    private String apiKey;

    @Value("${endpoint.url}")
    private String endpoint;

    public String getWeatherReport(String city, int country) throws JsonProcessingException, HttpClientErrorException {

        String url = getWeatherEndpoint(city, country);
        WeatherDetails weatherDetails = restTemplate.getForObject(url, WeatherDetails.class);
        return generateWeatherNotification(weatherDetails);
    }

    private String generateWeatherNotification(WeatherDetails weatherDetails) throws JsonProcessingException {
        List<Weather> weatherList = weatherDetails.getList();
        CityWeatherReport cityWeatherReport = new CityWeatherReport();
        cityWeatherReport.setCity(weatherDetails.getCity().getName());
        List<WeatherReport> temperatureList = new ArrayList<>();
        for (Weather weather : weatherDetails.getList()) {
            WeatherReport weatherReport = new WeatherReport();
            Temperature temperature = weather.getMain();
            weatherReport.setTemp_max(temperature.getTemp_max());
            weatherReport.setTemp_min(temperature.getTemp_min());
            weatherReport.setDate(weather.getDt_txt());
            temperatureList.add(weatherReport);
            if (temperature.getTemp_max() > 295) {
                weatherReport.setNotification("Use sunscreen lotion!");
            } else if (weather.getWeather().size() > 0 && weather.getWeather().get(0).getDescription().equalsIgnoreCase("broken clouds")) {
                weatherReport.setNotification("Don't step out! A storm is brewing!");
            } else if (weather.getWeather().size() > 0 && weather.getWeather().get(0).getDescription().equalsIgnoreCase("overcast clouds")) {
                weatherReport.setNotification("Carry Umbrella!");
            } else if (weather.getWind().getSpeed() > 10) {
                weatherReport.setNotification("Its too windy, watch out!");
            }
        }
        cityWeatherReport.setWeatherReports(temperatureList);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(cityWeatherReport);
    }

    public String getWeatherEndpoint(String city, int country) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(endpoint)
                .path("/").query("q={city}&cnt={cnt}&appid={apikey}").buildAndExpand(city, country, apiKey);

        return uriComponents.toUriString();
    }
}
