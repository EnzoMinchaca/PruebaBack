package com.back.pruebaback.service;

import com.back.pruebaback.domain.AirPollution;
import com.back.pruebaback.domain.Weather5Days;
import com.back.pruebaback.domain.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {
    
    @Autowired  
    private RestTemplate restTemplate;
    
    @Value("${spring.external.service.base-url-weather}")
    private String basePathWeather;
    
    @Value("${spring.external.service.base-url-forecast}")
    private String basePathForecast;
    
    @Value("${spring.external.service.base-url-airpollution}")
    private String basePathAirPollution;
    
    @Cacheable("weather")
    public WeatherData getWeatherByCityName(String city) {
        WeatherData weatherData = restTemplate.getForObject(basePathWeather + city, WeatherData.class);
        System.out.println("Llamada sin caché");
        return weatherData;
    }
    
    @Cacheable("forecast")
    public Weather5Days getForecastByCityName(String city) {
        Weather5Days weather5Days = restTemplate.getForObject(basePathForecast + city, Weather5Days.class);
        return weather5Days;
    }
    
    @Cacheable("airpollution")
    public AirPollution getAirPollutionByCityName(String city) {
        WeatherData wd = getWeatherByCityName(city);
        AirPollution air = restTemplate.getForObject(basePathAirPollution + "lat=" + wd.getCoord().getLat() + "&lon=" + wd.getCoord().getLon(), AirPollution.class);
        return air;
    }
    
}
