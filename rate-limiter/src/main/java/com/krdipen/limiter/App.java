package com.krdipen.limiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class App {

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter();
        rateLimiter.addRateLimit("user1", 10);
        rateLimiter.addRateLimit("user2", 50);

        final AtomicLong user1RequestsServed = new AtomicLong();
        final AtomicLong user2RequestsServed = new AtomicLong();
        final AtomicLong user1RequestsRejected = new AtomicLong();
        final AtomicLong user2RequestsRejected = new AtomicLong();

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int j = 0; j < 10; j++) {
            executorService.submit(() -> {
                for (long i = 0; i < 100000000; i++) {
                    if (rateLimiter.isRequestAllowed("user1")) {
                        user1RequestsServed.incrementAndGet();
                    } else {
                        user1RequestsRejected.incrementAndGet();
                    }
                }
            });
        }

        for (int j = 0; j < 10; j++) {
            executorService.submit(() -> {
                for (long i = 0; i < 100000000; i++) {
                    if (rateLimiter.isRequestAllowed("user2")) {
                        user2RequestsServed.incrementAndGet();
                    } else {
                        user2RequestsRejected.incrementAndGet();
                    }
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("User1 requests served: " + user1RequestsServed.get());
        System.out.println("User1 requests rejected: " + user1RequestsRejected.get());
        System.out.println("User2 requests served: " + user2RequestsServed.get());
        System.out.println("User2 requests rejected: " + user2RequestsRejected.get());
    }
}
