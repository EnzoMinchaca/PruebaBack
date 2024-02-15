package com.back.pruebaback.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DescriptionWeather {
    @JsonProperty("description")
    private String description;
}
