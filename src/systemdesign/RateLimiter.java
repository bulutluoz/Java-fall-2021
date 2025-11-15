package systemdesign;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * SYSTEM DESIGN: RATE LIMITER
 *
 * PROBLEM STATEMENT:
 * Design a rate limiter to prevent abuse and ensure fair usage of APIs.
 *
 * REQUIREMENTS:
 * - Limit number of requests per time window
 * - Support different limits per user/API key
 * - Low latency (don't slow down requests)
 * - Distributed system support
 * - Handle burst traffic
 *
 * COMMON ALGORITHMS:
 * 1. Token Bucket - Allows bursts, smooth rate limiting
 * 2. Leaky Bucket - Constant rate, no bursts
 * 3. Fixed Window - Simple but has boundary issues
 * 4. Sliding Window Log - Accurate but memory intensive
 * 5. Sliding Window Counter - Good balance
 *
 * USE CASES:
 * - API rate limiting (GitHub, Twitter, Stripe)
 * - DDoS protection
 * - Resource throttling
 * - Fair usage enforcement
 * - Cost control (cloud APIs)
 */
public class RateLimiter {

    /**
     * ALGORITHM 1: TOKEN BUCKET
     *
     * Concept:
     * - Bucket has max capacity of tokens
     * - Tokens added at constant rate
     * - Each request consumes 1 token
     * - If no tokens available, request denied
     *
     * Pros:
     * - Allows bursts (if bucket has tokens)
     * - Smooth rate limiting
     * - Memory efficient
     *
     * Cons:
     * - Allows bursts (can be pro or con)
     * - Requires timestamp tracking
     */
    public static class TokenBucketRateLimiter {
        private final long capacity;        // Max tokens
        private final long refillRate;      // Tokens per second
        private long tokens;                // Current tokens
        private long lastRefillTime;        // Last refill timestamp

        public TokenBucketRateLimiter(long capacity, long refillRatePerSecond) {
            this.capacity = capacity;
            this.refillRate = refillRatePerSecond;
            this.tokens = capacity;  // Start full
            this.lastRefillTime = System.currentTimeMillis();
        }

        public synchronized boolean allowRequest() {
            refillTokens();

            if (tokens > 0) {
                tokens--;
                return true;  // Request allowed
            }

            return false;  // Rate limit exceeded
        }

        private void refillTokens() {
            long now = System.currentTimeMillis();
            long timePassed = now - lastRefillTime;

            // Calculate tokens to add
            long tokensToAdd = (timePassed * refillRate) / 1000;

            if (tokensToAdd > 0) {
                tokens = Math.min(capacity, tokens + tokensToAdd);
                lastRefillTime = now;
            }
        }

        public synchronized long getAvailableTokens() {
            refillTokens();
            return tokens;
        }
    }

    /**
     * ALGORITHM 2: LEAKY BUCKET
     *
     * Concept:
     * - Requests added to queue (bucket)
     * - Processed at constant rate (leak)
     * - If queue full, reject request
     *
     * Pros:
     * - Smooth, constant output rate
     * - Handles bursts by queueing
     *
     * Cons:
     * - Adds latency (queuing)
     * - Queue can fill up
     */
    public static class LeakyBucketRateLimiter {
        private final Queue<Long> bucket;
        private final int capacity;
        private final long leakRateMs;  // Time between processing requests

        public LeakyBucketRateLimiter(int capacity, long leakRateMs) {
            this.bucket = new LinkedList<>();
            this.capacity = capacity;
            this.leakRateMs = leakRateMs;
        }

        public synchronized boolean allowRequest() {
            long now = System.currentTimeMillis();

            // Remove leaked requests (older than leak rate)
            while (!bucket.isEmpty() && now - bucket.peek() > leakRateMs) {
                bucket.poll();
            }

            if (bucket.size() < capacity) {
                bucket.offer(now);
                return true;
            }

            return false;  // Bucket full
        }

        public synchronized int getCurrentSize() {
            return bucket.size();
        }
    }

    /**
     * ALGORITHM 3: FIXED WINDOW COUNTER
     *
     * Concept:
     * - Divide time into fixed windows (e.g., every minute)
     * - Count requests in current window
     * - Reset counter when window changes
     *
     * Pros:
     * - Simple to implement
     * - Memory efficient
     *
     * Cons:
     * - Boundary issue (2x requests at window boundary)
     * - Unfair for users at different times
     */
    public static class FixedWindowRateLimiter {
        private final int maxRequests;
        private final long windowSizeMs;
        private int counter;
        private long windowStart;

        public FixedWindowRateLimiter(int maxRequests, long windowSizeMs) {
            this.maxRequests = maxRequests;
            this.windowSizeMs = windowSizeMs;
            this.counter = 0;
            this.windowStart = System.currentTimeMillis();
        }

        public synchronized boolean allowRequest() {
            long now = System.currentTimeMillis();

            // Check if new window
            if (now - windowStart >= windowSizeMs) {
                counter = 0;
                windowStart = now;
            }

            if (counter < maxRequests) {
                counter++;
                return true;
            }

            return false;
        }

        public synchronized int getRequestCount() {
            return counter;
        }
    }

    /**
     * ALGORITHM 4: SLIDING WINDOW LOG
     *
     * Concept:
     * - Keep timestamp log of all requests
     * - Count requests in last N seconds
     * - Remove old timestamps
     *
     * Pros:
     * - Most accurate
     * - No boundary issues
     *
     * Cons:
     * - Memory intensive (stores all timestamps)
     * - Slower (must iterate log)
     */
    public static class SlidingWindowLogRateLimiter {
        private final int maxRequests;
        private final long windowSizeMs;
        private final Queue<Long> requestLog;

        public SlidingWindowLogRateLimiter(int maxRequests, long windowSizeMs) {
            this.maxRequests = maxRequests;
            this.windowSizeMs = windowSizeMs;
            this.requestLog = new LinkedList<>();
        }

        public synchronized boolean allowRequest() {
            long now = System.currentTimeMillis();
            long windowStart = now - windowSizeMs;

            // Remove requests outside current window
            while (!requestLog.isEmpty() && requestLog.peek() < windowStart) {
                requestLog.poll();
            }

            if (requestLog.size() < maxRequests) {
                requestLog.offer(now);
                return true;
            }

            return false;
        }

        public synchronized int getRequestCount() {
            long now = System.currentTimeMillis();
            long windowStart = now - windowSizeMs;

            while (!requestLog.isEmpty() && requestLog.peek() < windowStart) {
                requestLog.poll();
            }

            return requestLog.size();
        }
    }

    /**
     * ALGORITHM 5: SLIDING WINDOW COUNTER (HYBRID)
     *
     * Concept:
     * - Combine fixed window + sliding window
     * - Estimate requests in current window using previous window
     * - Formula: currentWindowCount + (prevWindowCount * overlapPercentage)
     *
     * Pros:
     * - Good accuracy
     * - Memory efficient
     * - Smooth rate limiting
     *
     * Cons:
     * - Slightly more complex
     * - Approximate (not exact)
     */
    public static class SlidingWindowCounterRateLimiter {
        private final int maxRequests;
        private final long windowSizeMs;
        private int prevCounter;
        private int currCounter;
        private long currWindowStart;

        public SlidingWindowCounterRateLimiter(int maxRequests, long windowSizeMs) {
            this.maxRequests = maxRequests;
            this.windowSizeMs = windowSizeMs;
            this.prevCounter = 0;
            this.currCounter = 0;
            this.currWindowStart = System.currentTimeMillis();
        }

        public synchronized boolean allowRequest() {
            long now = System.currentTimeMillis();

            // Check if we're in a new window
            if (now - currWindowStart >= windowSizeMs) {
                prevCounter = currCounter;
                currCounter = 0;
                currWindowStart = now;
            }

            // Calculate weighted count
            long timeSinceWindowStart = now - currWindowStart;
            double overlapPercentage = 1.0 - (double) timeSinceWindowStart / windowSizeMs;
            double weightedCount = prevCounter * overlapPercentage + currCounter;

            if (weightedCount < maxRequests) {
                currCounter++;
                return true;
            }

            return false;
        }
    }

    /**
     * DISTRIBUTED RATE LIMITER (Redis-based concept)
     *
     * For distributed systems across multiple servers.
     *
     * Approaches:
     * 1. Redis with Lua script (atomic operations)
     * 2. Redis sorted set (sliding window log)
     * 3. Redis hash (fixed window)
     *
     * Example with Redis:
     *
     * // Token Bucket in Redis
     * local key = KEYS[1]
     * local capacity = tonumber(ARGV[1])
     * local rate = tonumber(ARGV[2])
     * local now = tonumber(ARGV[3])
     *
     * local bucket = redis.call('HMGET', key, 'tokens', 'last_refill')
     * local tokens = tonumber(bucket[1]) or capacity
     * local last_refill = tonumber(bucket[2]) or now
     *
     * local elapsed = now - last_refill
     * local new_tokens = math.min(capacity, tokens + elapsed * rate)
     *
     * if new_tokens >= 1 then
     *     redis.call('HMSET', key, 'tokens', new_tokens - 1, 'last_refill', now)
     *     return 1
     * else
     *     return 0
     * end
     */

    /**
     * MULTI-USER RATE LIMITER
     *
     * Rate limit per user/API key.
     */
    public static class MultiUserRateLimiter {
        private final Map<String, TokenBucketRateLimiter> limiters;
        private final long capacity;
        private final long refillRate;

        public MultiUserRateLimiter(long capacity, long refillRate) {
            this.limiters = new ConcurrentHashMap<>();
            this.capacity = capacity;
            this.refillRate = refillRate;
        }

        public boolean allowRequest(String userId) {
            TokenBucketRateLimiter limiter = limiters.computeIfAbsent(
                userId,
                k -> new TokenBucketRateLimiter(capacity, refillRate)
            );

            return limiter.allowRequest();
        }

        public void removeUser(String userId) {
            limiters.remove(userId);
        }

        public int getUserCount() {
            return limiters.size();
        }
    }

    /**
     * PRODUCTION CONSIDERATIONS:
     *
     * 1. STORAGE:
     *    - In-memory: Fast but lost on restart
     *    - Redis: Distributed, persistent, fast
     *    - Database: Persistent but slower
     *
     * 2. GRANULARITY:
     *    - Per user/API key
     *    - Per IP address
     *    - Per endpoint
     *    - Combination (user + endpoint)
     *
     * 3. RESPONSE:
     *    - Return 429 Too Many Requests
     *    - Include headers:
     *      * X-RateLimit-Limit: 100
     *      * X-RateLimit-Remaining: 42
     *      * X-RateLimit-Reset: 1609459200
     *    - Optionally: Retry-After header
     *
     * 4. BYPASS:
     *    - Whitelist for internal services
     *    - Premium users (higher limits)
     *    - Admin override
     *
     * 5. MONITORING:
     *    - Track rate limit hits
     *    - Alert on unusual patterns
     *    - Identify potential attacks
     *
     * 6. TESTING:
     *    - Load testing
     *    - Burst testing
     *    - Boundary condition testing
     *
     * 7. COST CONSIDERATIONS:
     *    - Redis: Memory usage per user
     *    - Network calls to Redis
     *    - Cleanup old entries
     */

    // Demo and testing
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Rate Limiter Demo ===\n");

        // Test Token Bucket
        System.out.println("1. TOKEN BUCKET (5 requests/second, burst=10)");
        TokenBucketRateLimiter tokenBucket = new TokenBucketRateLimiter(10, 5);

        System.out.println("Sending 12 requests rapidly...");
        int allowed = 0;
        for (int i = 1; i <= 12; i++) {
            if (tokenBucket.allowRequest()) {
                System.out.println("  Request " + i + ": ALLOWED");
                allowed++;
            } else {
                System.out.println("  Request " + i + ": BLOCKED");
            }
        }
        System.out.println("Result: " + allowed + "/12 allowed (burst capability)\n");

        // Test Fixed Window
        System.out.println("2. FIXED WINDOW (5 requests per second)");
        FixedWindowRateLimiter fixedWindow = new FixedWindowRateLimiter(5, 1000);

        for (int i = 1; i <= 7; i++) {
            if (fixedWindow.allowRequest()) {
                System.out.println("  Request " + i + ": ALLOWED");
            } else {
                System.out.println("  Request " + i + ": BLOCKED");
            }
        }

        System.out.println("\nWaiting 1 second for new window...");
        Thread.sleep(1100);

        System.out.println("After window reset:");
        for (int i = 1; i <= 3; i++) {
            if (fixedWindow.allowRequest()) {
                System.out.println("  Request " + i + ": ALLOWED");
            }
        }
        System.out.println();

        // Test Sliding Window Log
        System.out.println("3. SLIDING WINDOW LOG (3 requests per 2 seconds)");
        SlidingWindowLogRateLimiter slidingLog = new SlidingWindowLogRateLimiter(3, 2000);

        for (int i = 1; i <= 5; i++) {
            boolean allowed2 = slidingLog.allowRequest();
            System.out.println("  Request " + i + ": " +
                             (allowed2 ? "ALLOWED" : "BLOCKED") +
                             " (count: " + slidingLog.getRequestCount() + ")");
            Thread.sleep(300);
        }
        System.out.println();

        // Test Multi-User
        System.out.println("4. MULTI-USER RATE LIMITER");
        MultiUserRateLimiter multiUser = new MultiUserRateLimiter(3, 1);

        String[] users = {"Alice", "Bob", "Alice", "Bob", "Alice", "Alice"};
        for (int i = 0; i < users.length; i++) {
            boolean allowed3 = multiUser.allowRequest(users[i]);
            System.out.println("  Request " + (i+1) + " from " + users[i] + ": " +
                             (allowed3 ? "ALLOWED" : "BLOCKED"));
        }

        System.out.println("\n=== Performance Test ===");
        testPerformance();
    }

    private static void testPerformance() {
        int requests = 1_000_000;
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(1000, 100);

        long startTime = System.nanoTime();

        int allowed = 0;
        for (int i = 0; i < requests; i++) {
            if (limiter.allowRequest()) {
                allowed++;
            }
        }

        long endTime = System.nanoTime();
        double seconds = (endTime - startTime) / 1_000_000_000.0;

        System.out.println("Requests: " + requests);
        System.out.println("Allowed: " + allowed);
        System.out.println("Blocked: " + (requests - allowed));
        System.out.println("Time: " + String.format("%.3f", seconds) + " seconds");
        System.out.println("Throughput: " + String.format("%.0f", requests / seconds) + " req/sec");
    }
}
