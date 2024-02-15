package com.back.pruebaback.domain;

import lombok.Data;

@Data
public class AirPollutionList {
    private MainAir main;
    private Components components;
    private Long dt;
}
