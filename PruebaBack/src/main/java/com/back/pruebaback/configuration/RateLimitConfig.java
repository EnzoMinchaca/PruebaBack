package com.back.pruebaback.configuration;

import com.back.pruebaback.service.RateLimitService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class RateLimitConfig {
    
    private final RateLimitService rateLimitService;

    public RateLimitConfig(RateLimitService rateLimitService) {
        this.rateLimitService = rateLimitService;
    }

    // Programar una tarea para restablecer los recuentos de solicitud periódicamente
    @Scheduled(fixedRate = 3600000) // cada hora
    public void resetCounts() {
        rateLimitService.resetCounts();
    }
}
