package com.weather.weatherapp.entities.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Description {

    private int id;
    private String main;
    private String description;
    private String icon;
}
