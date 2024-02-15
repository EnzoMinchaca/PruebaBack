package com.back.pruebaback.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class Weather5DaysList {
    @JsonProperty("main")
    private Main main;
    @JsonProperty("weather")
    private List<DescriptionWeather> weather;
    @JsonProperty("dt_txt")
    private String dt_txt;
}
