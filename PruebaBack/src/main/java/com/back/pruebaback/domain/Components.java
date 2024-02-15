package com.back.pruebaback.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Components {
    @JsonProperty("co")
    private double co;
    @JsonProperty("no")
    private double no;
    @JsonProperty("no2")
    private double no2;
    @JsonProperty("o3")
    private double o3;
    @JsonProperty("so2")
    private double so2;
    @JsonProperty("pm2_5")
    private double pm2_5;
    @JsonProperty("pm10")
    private double pm10;
    @JsonProperty("nh3")
    private double nh3;
}
