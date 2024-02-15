package com.back.pruebaback.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MainAir {
    @JsonProperty("aqi")
    private int aqi;
}
