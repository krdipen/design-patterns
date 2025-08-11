package com.krdipen.limiter;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimit {
    private Lock lock;
    private int perMinuteMaxRequests;
    private Queue<LocalDateTime> requestTimes;

    public RateLimit(int perMinuteMaxRequests) {
        this.perMinuteMaxRequests = perMinuteMaxRequests;
        this.requestTimes = new ArrayDeque<>();
        this.lock = new ReentrantLock();
    }

    public boolean isRequestAllowed(LocalDateTime localDateTime) {
        lock.lock();
        while(requestTimes.peek() != null && requestTimes.peek().isBefore(localDateTime.minusMinutes(1))) {
            requestTimes.poll();
        }
        if (requestTimes.size() < perMinuteMaxRequests) {
            requestTimes.add(localDateTime);
            lock.unlock();
            return true;
        }
        lock.unlock();
        return false;
    }

    public void updateRateLimit(int perMinuteMaxRequests) {
        lock.lock();
        this.perMinuteMaxRequests = perMinuteMaxRequests;
        lock.unlock();
        return;
    }

    public int getRemainingQuota() {
        lock.lock();
        int remainingQuota = perMinuteMaxRequests - requestTimes.size();
        lock.unlock();
        return remainingQuota;
    }
}
