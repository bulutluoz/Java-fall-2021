package systemdesign;

import java.util.*;

/**
 * SYSTEM DESIGN: LRU CACHE (Least Recently Used Cache)
 *
 * PROBLEM STATEMENT:
 * Design and implement a data structure for LRU cache with O(1) operations.
 *
 * REQUIREMENTS:
 * - get(key): Get value from cache in O(1)
 * - put(key, value): Put key-value pair in O(1)
 * - When cache is full, evict least recently used item
 * - Both get and put count as "using" the key
 *
 * APPROACH:
 * - HashMap: O(1) key lookup
 * - Doubly Linked List: O(1) add/remove, maintains access order
 * - HashMap stores key → Node reference
 * - Doubly linked list: Head = most recent, Tail = least recent
 *
 * OPERATIONS:
 * GET:
 * 1. Look up key in HashMap → O(1)
 * 2. Move node to head (most recent) → O(1)
 * 3. Return value
 *
 * PUT:
 * 1. If key exists: update value, move to head → O(1)
 * 2. If key doesn't exist:
 *    a. If cache full: remove tail (LRU), remove from HashMap
 *    b. Add new node to head, add to HashMap
 *
 * USE CASES:
 * - Browser cache
 * - Database query cache
 * - CDN caching
 * - CPU cache
 * - API response caching
 */
public class LRUCache<K, V> {

    // Doubly linked list node
    private class Node {
        K key;
        V value;
        Node prev;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node> cache;
    private Node head;  // Most recently used
    private Node tail;  // Least recently used
    private int size;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.size = 0;

        // Dummy head and tail nodes (simplifies edge cases)
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get value by key - O(1)
     */
    public V get(K key) {
        Node node = cache.get(key);

        if (node == null) {
            return null;  // Cache miss
        }

        // Move to head (most recently used)
        moveToHead(node);

        return node.value;
    }

    /**
     * Put key-value pair - O(1)
     */
    public void put(K key, V value) {
        Node node = cache.get(key);

        if (node != null) {
            // Key exists - update value and move to head
            node.value = value;
            moveToHead(node);
        } else {
            // New key - create new node
            Node newNode = new Node(key, value);

            // Add to cache
            cache.put(key, newNode);
            addToHead(newNode);
            size++;

            // Check capacity
            if (size > capacity) {
                // Remove LRU (tail)
                Node removed = removeTail();
                cache.remove(removed.key);
                size--;
            }
        }
    }

    /**
     * Remove and return least recently used item
     */
    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    /**
     * Move node to head (most recent position)
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * Remove node from list
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Add node to head (most recent)
     */
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * Get current cache size
     */
    public int size() {
        return size;
    }

    /**
     * Get cache capacity
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Check if key exists in cache
     */
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    /**
     * Clear all entries
     */
    public void clear() {
        cache.clear();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * Get all keys in access order (most recent to least recent)
     */
    public List<K> getKeysInOrder() {
        List<K> keys = new ArrayList<>();
        Node current = head.next;

        while (current != tail) {
            keys.add(current.key);
            current = current.next;
        }

        return keys;
    }

    /**
     * ALTERNATIVE IMPLEMENTATION: Using LinkedHashMap
     *
     * Java's LinkedHashMap with accessOrder=true maintains insertion/access order
     * and can automatically remove eldest entry.
     */
    public static class LRUCacheSimple<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        public LRUCacheSimple(int capacity) {
            // Initial capacity, load factor, accessOrder=true
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    /**
     * PRODUCTION CONSIDERATIONS:
     *
     * 1. THREAD SAFETY:
     *    - Add synchronized methods or ReentrantReadWriteLock
     *    - ConcurrentHashMap + synchronized list operations
     *    - Lock striping for better concurrency
     *
     * 2. DISTRIBUTED CACHE:
     *    - Redis with TTL (Time To Live)
     *    - Memcached
     *    - Consistent hashing for multiple cache nodes
     *
     * 3. CACHE INVALIDATION:
     *    - Time-based expiration (TTL)
     *    - Event-based invalidation
     *    - Write-through vs write-back
     *
     * 4. CACHE WARMING:
     *    - Preload frequently accessed data
     *    - Background refresh before expiration
     *
     * 5. CACHE EVICTION POLICIES:
     *    - LRU (Least Recently Used) - this implementation
     *    - LFU (Least Frequently Used) - track access count
     *    - FIFO (First In First Out) - simpler, worse hit rate
     *    - Random - simple but unpredictable
     *    - ARC (Adaptive Replacement Cache) - adapts between recency and frequency
     *
     * 6. MONITORING:
     *    - Hit rate (cache hits / total requests)
     *    - Miss rate
     *    - Eviction rate
     *    - Average response time
     *
     * 7. CACHE STAMPEDE PREVENTION:
     *    - Multiple requests for same missing key
     *    - Use lock for that key
     *    - Request coalescing
     *
     * 8. MEMORY MANAGEMENT:
     *    - Set max memory limit
     *    - Estimate object sizes
     *    - Use weak references for less critical data
     */

    // Example usage and testing
    public static void main(String[] args) {
        System.out.println("=== LRU Cache Demo ===\n");

        LRUCache<String, Integer> cache = new LRUCache<>(3);

        System.out.println("Cache capacity: " + cache.capacity());
        System.out.println();

        // Add items
        System.out.println("Adding: (a, 1)");
        cache.put("a", 1);
        System.out.println("Adding: (b, 2)");
        cache.put("b", 2);
        System.out.println("Adding: (c, 3)");
        cache.put("c", 3);
        System.out.println("Keys in order: " + cache.getKeysInOrder());  // [c, b, a]
        System.out.println();

        // Get (makes 'a' most recent)
        System.out.println("Getting 'a': " + cache.get("a"));
        System.out.println("Keys in order: " + cache.getKeysInOrder());  // [a, c, b]
        System.out.println();

        // Add one more (should evict 'b' - least recently used)
        System.out.println("Adding: (d, 4) - should evict 'b'");
        cache.put("d", 4);
        System.out.println("Keys in order: " + cache.getKeysInOrder());  // [d, a, c]
        System.out.println("Getting 'b': " + cache.get("b"));  // null (evicted)
        System.out.println();

        // Update existing key
        System.out.println("Updating 'c' to 30");
        cache.put("c", 30);
        System.out.println("Keys in order: " + cache.getKeysInOrder());  // [c, d, a]
        System.out.println("Getting 'c': " + cache.get("c"));  // 30
        System.out.println();

        // Test with LinkedHashMap implementation
        System.out.println("=== LinkedHashMap-based LRU Cache ===\n");
        LRUCacheSimple<String, Integer> simpleCache = new LRUCacheSimple<>(3);

        simpleCache.put("x", 1);
        simpleCache.put("y", 2);
        simpleCache.put("z", 3);
        System.out.println("Cache: " + simpleCache);

        simpleCache.get("x");  // Access x (makes it most recent)
        simpleCache.put("w", 4);  // Should evict y
        System.out.println("After adding w: " + simpleCache);
        System.out.println("Contains y? " + simpleCache.containsKey("y"));  // false

        // Performance comparison
        System.out.println("\n=== Performance Test ===");
        testPerformance();
    }

    private static void testPerformance() {
        int capacity = 1000;
        int operations = 100000;

        LRUCache<Integer, Integer> cache = new LRUCache<>(capacity);
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < operations; i++) {
            int key = random.nextInt(capacity * 2);  // 50% hit rate

            if (random.nextBoolean()) {
                cache.put(key, i);
            } else {
                cache.get(key);
            }
        }

        long endTime = System.nanoTime();
        double seconds = (endTime - startTime) / 1_000_000_000.0;

        System.out.println("Operations: " + operations);
        System.out.println("Time: " + String.format("%.3f", seconds) + " seconds");
        System.out.println("Ops/sec: " + String.format("%.0f", operations / seconds));
    }
}

/**
 * LFU CACHE (Least Frequently Used) - For comparison
 *
 * Similar to LRU but evicts least frequently used item.
 * Requires tracking access count for each key.
 *
 * Implementation:
 * - HashMap<Key, Node> for O(1) lookup
 * - HashMap<Frequency, DoublyLinkedList> for frequency buckets
 * - Track minimum frequency
 *
 * Tradeoff: More complex, better for some workloads
 */
class LFUCache<K, V> {
    private class Node {
        K key;
        V value;
        int frequency;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    private final int capacity;
    private int minFrequency;
    private Map<K, Node> keyToNode;
    private Map<Integer, LinkedHashSet<K>> frequencyToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyToNode = new HashMap<>();
        this.frequencyToKeys = new HashMap<>();
    }

    public V get(K key) {
        if (!keyToNode.containsKey(key)) {
            return null;
        }

        Node node = keyToNode.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (capacity <= 0) return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        if (keyToNode.size() >= capacity) {
            evict();
        }

        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);
        frequencyToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFrequency = 1;
    }

    private void updateFrequency(Node node) {
        int freq = node.frequency;
        frequencyToKeys.get(freq).remove(node.key);

        if (frequencyToKeys.get(freq).isEmpty()) {
            frequencyToKeys.remove(freq);
            if (minFrequency == freq) {
                minFrequency++;
            }
        }

        node.frequency++;
        frequencyToKeys.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>()).add(node.key);
    }

    private void evict() {
        LinkedHashSet<K> keys = frequencyToKeys.get(minFrequency);
        K keyToEvict = keys.iterator().next();
        keys.remove(keyToEvict);

        if (keys.isEmpty()) {
            frequencyToKeys.remove(minFrequency);
        }

        keyToNode.remove(keyToEvict);
    }
}
