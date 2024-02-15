package com.back.pruebaback.security.filters;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

public class RateLimitInterceptor implements HandlerInterceptor {

    private final Map<String, Integer> requestCounts = new HashMap<>();
    private final int MAX_REQUESTS = 5; // Máximo número de solicitudes permitidas

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user = request.getRemoteUser(); // Se puede personalizar para obtener el identificador del usuario
        if (user != null) {
            int requests = requestCounts.getOrDefault(user, 0);
            if (requests >= MAX_REQUESTS) {
                response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                return false;
            }
            requestCounts.put(user, requests + 1);
        }
        return true;
    }
}
