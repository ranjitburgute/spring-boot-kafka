package com.weather.weatherapp.entities.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherReport {

    private String date;
    private double temp_min;
    private double temp_max;
    private String notification;

}
