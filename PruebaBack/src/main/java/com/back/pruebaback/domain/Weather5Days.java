package com.back.pruebaback.domain;

import java.util.List;
import lombok.Data;

@Data
public class Weather5Days {
    private City city;
    private List<Weather5DaysList> list;
}
