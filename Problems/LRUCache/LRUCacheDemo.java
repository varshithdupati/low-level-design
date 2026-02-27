package Problems.LRUCache;

public class LRUCacheDemo {
    
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "One");
        cache.put(2, "Two");
        System.out.println(cache.get(1)); // Output: One
        cache.put(3, "Three"); // Evicts key 2
        System.out.println(cache.get(2)); // Output: null
        cache.put(4, "Four"); // Evicts key 1
        System.out.println(cache.get(1)); // Output: null
        System.out.println(cache.get(4)); // Output: Four
    }

}
