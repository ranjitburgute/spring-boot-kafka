package com.weather.weatherapp.entities.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Temperature {

    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int sea_level;
    private int grnd_level;
    private int humidity;
    private int temp_kf;
}
