package com.back.pruebaback.domain;

import java.util.List;
import lombok.Data;

@Data
public class WeatherData {
    private Coord coord;
    private List<DescriptionWeather> weather;
    private Main main;
    private Long id;
    private String name;
}
