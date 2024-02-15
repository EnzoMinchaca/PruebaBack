package com.back.pruebaback.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Main {
    @JsonProperty("temp")
    private double temp;
    @JsonProperty("temp_min")
    private double temp_min;
    @JsonProperty("temp_max")
    private double temp_max;
}
