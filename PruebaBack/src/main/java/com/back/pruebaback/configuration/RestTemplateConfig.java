package com.back.pruebaback.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  //es para que apenas se levante el servidor Spring ejecute todo lo de esta clase primero antes que todo el resto
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
//con esto ya debe funcionar resttemplate porque ya creamos la instancia de nuestro bean RestTemplate
//disponibilizandolo para nuestrra aplicacion entonces ahora cualquier clase que quiera inyectar RestTEmplata podra hacerlo libremente
