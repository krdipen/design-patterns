package com.krdipen.limiter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private Map<String, RateLimit> rateLimits;

    public RateLimiter() {
        rateLimits = new HashMap<>();
    }

    public boolean isRequestAllowed(String userId) {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (rateLimits.get(userId) == null) {
            System.out.println("Rate limit not found for userId: " + userId);
            return false;
        }
        return rateLimits.get(userId).isRequestAllowed(localDateTime);
    }

    public void updateRateLimit(String userId, int perMinuteMaxRequests) {
        if (rateLimits.get(userId) == null) {
            System.out.println("Rate limit not found for userId: " + userId);
            return;
        }
        rateLimits.get(userId).updateRateLimit(perMinuteMaxRequests);
    }

    public int getRemainingQuota(String userId) {
        if (rateLimits.get(userId) == null) {
            System.out.println("Rate limit not found for userId: " + userId);
            return 0;
        }
        return rateLimits.get(userId).getRemainingQuota();
    }

    public void addRateLimit(String userId, int perMinuteMaxRequests) {
        rateLimits.put(userId, new RateLimit(perMinuteMaxRequests));
    }
}
