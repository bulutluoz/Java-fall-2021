package systemdesign;

import java.util.*;

/**
 * SYSTEM DESIGN: URL SHORTENER (TinyURL, bit.ly)
 *
 * PROBLEM STATEMENT:
 * Design a URL shortening service like TinyURL that converts long URLs into short URLs.
 *
 * REQUIREMENTS:
 * Functional:
 * - Given a URL, generate a shorter unique URL
 * - Redirect short URL to original long URL
 * - Custom short URLs (optional)
 * - Expiration time (optional)
 * - Analytics (click tracking)
 *
 * Non-Functional:
 * - High availability (URL redirection must always work)
 * - Low latency (redirection should be fast)
 * - Scalable (handle billions of URLs)
 * - URLs should not be predictable
 *
 * CAPACITY ESTIMATION:
 * - 100 million new URLs per month
 * - Read:Write ratio = 100:1 (more reads than writes)
 * - 10 billion reads per month
 * - Storage: 100M URLs × 10 years × 12 months = 12 billion URLs
 * - Storage per URL: ~500 bytes → 6 TB total
 * - QPS: 100M / (30 days × 24 hrs × 3600 sec) ≈ 40 writes/sec
 * - QPS: 10B / (30 × 24 × 3600) ≈ 4000 reads/sec
 *
 * DESIGN DECISIONS:
 * 1. Short URL length: 6-7 characters
 *    - Base62 encoding (a-z, A-Z, 0-9) = 62 characters
 *    - 62^6 = 56 billion unique URLs
 *    - 62^7 = 3.5 trillion unique URLs
 *
 * 2. Database:
 *    - NoSQL (Cassandra/DynamoDB) for scalability
 *    - Schema: {shortURL: string, longURL: string, createdAt: timestamp, clicks: int}
 *
 * 3. Approach:
 *    - Hash-based (MD5, SHA-256 with collision handling)
 *    - Counter-based (Base62 encoding of auto-increment ID)
 *    - Random generation with collision check
 */
public class URLShortener {

    private Map<String, URLMapping> shortToLong;  // Short → Full mapping
    private Map<String, String> longToShort;      // Full → Short mapping
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 7;
    private long counter;  // For counter-based approach

    static class URLMapping {
        String longURL;
        long createdAt;
        int clicks;
        Long expiresAt;  // Optional expiration

        URLMapping(String longURL) {
            this.longURL = longURL;
            this.createdAt = System.currentTimeMillis();
            this.clicks = 0;
        }
    }

    public URLShortener() {
        this.shortToLong = new HashMap<>();
        this.longToShort = new HashMap<>();
        this.counter = 1000000;  // Start from a random number for security
    }

    /**
     * APPROACH 1: Counter-based with Base62 encoding
     * Pros: No collisions, predictable length
     * Cons: Sequential URLs (predictable), requires distributed counter
     */
    public String shortenURL(String longURL) {
        // Check if already exists
        if (longToShort.containsKey(longURL)) {
            return longToShort.get(longURL);
        }

        // Generate short URL from counter
        String shortURL = encodeBase62(counter++);

        // Store mapping
        URLMapping mapping = new URLMapping(longURL);
        shortToLong.put(shortURL, mapping);
        longToShort.put(longURL, shortURL);

        return "http://tiny.url/" + shortURL;
    }

    /**
     * Convert number to Base62 string
     */
    private String encodeBase62(long num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int remainder = (int) (num % 62);
            sb.append(BASE62.charAt(remainder));
            num /= 62;
        }

        // Pad to fixed length
        while (sb.length() < SHORT_URL_LENGTH) {
            sb.append('a');
        }

        return sb.reverse().toString();
    }

    /**
     * Convert Base62 string back to number
     */
    private long decodeBase62(String shortURL) {
        long num = 0;
        for (char c : shortURL.toCharArray()) {
            num = num * 62 + BASE62.indexOf(c);
        }
        return num;
    }

    /**
     * APPROACH 2: Hash-based (MD5/SHA-256)
     * Pros: Distributed generation, same URL → same hash
     * Cons: Collision handling needed, variable length
     */
    public String shortenURLHash(String longURL) {
        if (longToShort.containsKey(longURL)) {
            return longToShort.get(longURL);
        }

        String shortURL = null;
        int attempt = 0;

        while (shortURL == null || shortToLong.containsKey(shortURL)) {
            // Generate hash (simplified - in production use MD5/SHA-256)
            int hash = (longURL + attempt).hashCode();
            shortURL = encodeBase62(Math.abs(hash));

            // Take first 7 characters
            if (shortURL.length() > SHORT_URL_LENGTH) {
                shortURL = shortURL.substring(0, SHORT_URL_LENGTH);
            }

            attempt++;
        }

        URLMapping mapping = new URLMapping(longURL);
        shortToLong.put(shortURL, mapping);
        longToShort.put(longURL, shortURL);

        return "http://tiny.url/" + shortURL;
    }

    /**
     * APPROACH 3: Random generation
     * Pros: Unpredictable, distributed
     * Cons: Collision check needed, multiple DB queries
     */
    public String shortenURLRandom(String longURL) {
        if (longToShort.containsKey(longURL)) {
            return longToShort.get(longURL);
        }

        Random random = new Random();
        String shortURL = null;

        // Keep trying until we find unused short URL
        while (shortURL == null || shortToLong.containsKey(shortURL)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < SHORT_URL_LENGTH; i++) {
                sb.append(BASE62.charAt(random.nextInt(62)));
            }
            shortURL = sb.toString();
        }

        URLMapping mapping = new URLMapping(longURL);
        shortToLong.put(shortURL, mapping);
        longToShort.put(longURL, shortURL);

        return "http://tiny.url/" + shortURL;
    }

    /**
     * Redirect: Get original URL from short URL
     */
    public String getLongURL(String shortURL) {
        // Remove domain if present
        if (shortURL.contains("/")) {
            shortURL = shortURL.substring(shortURL.lastIndexOf("/") + 1);
        }

        URLMapping mapping = shortToLong.get(shortURL);

        if (mapping == null) {
            return null;  // Not found
        }

        // Check expiration
        if (mapping.expiresAt != null && System.currentTimeMillis() > mapping.expiresAt) {
            return null;  // Expired
        }

        // Increment click counter (analytics)
        mapping.clicks++;

        return mapping.longURL;
    }

    /**
     * Create short URL with expiration
     */
    public String shortenURLWithExpiration(String longURL, long expirationHours) {
        String shortURL = shortenURL(longURL);
        String key = shortURL.substring(shortURL.lastIndexOf("/") + 1);

        URLMapping mapping = shortToLong.get(key);
        mapping.expiresAt = System.currentTimeMillis() + (expirationHours * 3600 * 1000);

        return shortURL;
    }

    /**
     * Get analytics for a short URL
     */
    public int getClickCount(String shortURL) {
        if (shortURL.contains("/")) {
            shortURL = shortURL.substring(shortURL.lastIndexOf("/") + 1);
        }

        URLMapping mapping = shortToLong.get(shortURL);
        return mapping != null ? mapping.clicks : 0;
    }

    /**
     * Custom short URL (if available)
     */
    public String customShortURL(String longURL, String customAlias) {
        if (shortToLong.containsKey(customAlias)) {
            throw new IllegalArgumentException("Custom alias already taken");
        }

        URLMapping mapping = new URLMapping(longURL);
        shortToLong.put(customAlias, mapping);
        longToShort.put(longURL, customAlias);

        return "http://tiny.url/" + customAlias;
    }

    /**
     * PRODUCTION CONSIDERATIONS:
     *
     * 1. DATABASE DESIGN:
     *    Table: url_mappings
     *    - id: BIGINT PRIMARY KEY AUTO_INCREMENT
     *    - short_url: VARCHAR(7) UNIQUE INDEX
     *    - long_url: TEXT
     *    - created_at: TIMESTAMP
     *    - expires_at: TIMESTAMP (nullable)
     *    - clicks: INT DEFAULT 0
     *    - user_id: BIGINT (if user accounts exist)
     *
     * 2. CACHING:
     *    - Use Redis for frequently accessed URLs
     *    - Cache popular URLs (80-20 rule)
     *    - Write-through cache for new URLs
     *    - LRU eviction policy
     *
     * 3. LOAD BALANCING:
     *    - Multiple application servers
     *    - Round-robin or least connections
     *    - Session-less design (stateless)
     *
     * 4. DATABASE SHARDING:
     *    - Shard by hash of short URL
     *    - Consistent hashing for even distribution
     *    - Replicas for high availability
     *
     * 5. RATE LIMITING:
     *    - Prevent abuse (spam URL creation)
     *    - IP-based or user-based limits
     *    - Token bucket algorithm
     *
     * 6. ANALYTICS:
     *    - Async processing (don't block redirect)
     *    - Stream to analytics service (Kafka)
     *    - Track: timestamp, IP, user-agent, referrer
     *
     * 7. SECURITY:
     *    - Validate URLs (prevent malicious sites)
     *    - Rate limiting per user/IP
     *    - CAPTCHA for suspicious activity
     *    - Blacklist known malicious domains
     *
     * 8. DISTRIBUTED COUNTER:
     *    - Zookeeper for distributed counter
     *    - Pre-allocate ranges to servers
     *    - Server 1: 1-1000000, Server 2: 1000001-2000000
     */

    // Test the URL shortener
    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

        System.out.println("=== URL Shortener Demo ===\n");

        // Shorten URLs
        String url1 = "https://www.example.com/very/long/url/path/to/resource?param=value";
        String short1 = shortener.shortenURL(url1);
        System.out.println("Original: " + url1);
        System.out.println("Shortened: " + short1);
        System.out.println();

        // Retrieve original URL
        String retrieved = shortener.getLongURL(short1);
        System.out.println("Retrieved: " + retrieved);
        System.out.println("Match: " + url1.equals(retrieved));
        System.out.println();

        // Same URL should get same short URL
        String short2 = shortener.shortenURL(url1);
        System.out.println("Same URL shortened again: " + short2);
        System.out.println("Same short URL: " + short1.equals(short2));
        System.out.println();

        // Custom alias
        String custom = shortener.customShortURL("https://www.example.com/custom", "mylink");
        System.out.println("Custom short URL: " + custom);
        System.out.println();

        // Analytics
        shortener.getLongURL(short1);  // Access again
        shortener.getLongURL(short1);  // And again
        System.out.println("Click count for " + short1 + ": " + shortener.getClickCount(short1));
        System.out.println();

        // Expiration
        String expiring = shortener.shortenURLWithExpiration(
            "https://www.example.com/temporary", 24);
        System.out.println("URL with 24hr expiration: " + expiring);
    }
}
