package com.back.pruebaback.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class RateLimitService {

    private final Map<String, Integer> requestCounts = new ConcurrentHashMap<>();

    public void recordRequest(String userId) {
        requestCounts.put(userId, requestCounts.getOrDefault(userId, 0) + 1);
    }

    public boolean isAllowed(String userId, int maxRequestsPerHour) {
        int requestsThisHour = requestCounts.getOrDefault(userId, 0);
        System.out.println("Conteo: " + requestCounts.values());
        return requestsThisHour <= maxRequestsPerHour;
    }

    public void resetCounts() {
        requestCounts.clear();
    }
}
