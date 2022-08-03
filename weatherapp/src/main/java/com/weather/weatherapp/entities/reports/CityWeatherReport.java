package com.weather.weatherapp.entities.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityWeatherReport {

    private String city;
    private List<WeatherReport> weatherReports;
}

