package com.back.pruebaback.domain;

import java.util.List;
import lombok.Data;

@Data
public class AirPollution {
    private Coord coord;
    private List<AirPollutionList> list;
}
