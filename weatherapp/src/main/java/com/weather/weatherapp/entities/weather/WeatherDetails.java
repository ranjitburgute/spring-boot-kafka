package com.weather.weatherapp.entities.weather;

import com.weather.weatherapp.entities.city.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDetails {

    protected int message;
    private String cod;
    private int cnt;
    private City city;
    private List<Weather> list;
}
