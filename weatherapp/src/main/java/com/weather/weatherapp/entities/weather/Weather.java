package com.weather.weatherapp.entities.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    private long dt;
    private String dt_txt;
    private List<Description> weather;
    private Temperature main;
    private Clouds clouds;
    private Wind wind;
    private int visibility;
    private int pop;
    private System pod;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class System {

        private String pod;
    }

}

