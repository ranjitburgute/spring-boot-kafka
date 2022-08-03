package com.weather.weatherapp.entities.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    Coordinates coord;
    private int id;
    private String name;
    private String country;
    private long population;
    private int timezone;
    private long sunrise;
    private long sunset;

}
