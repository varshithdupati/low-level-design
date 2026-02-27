package Problems.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private int capacity;
    private DoublyLinkedList<K, V> list;
    private Map<K, Node<K, V>> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new DoublyLinkedList<>();
        this.map = new HashMap<>();
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node<K, V> node = map.get(key);
        list.removeNode(node);
        list.addToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            list.removeNode(node);
            list.addToHead(node);
        } else {
            if (map.size() >= capacity) {
                Node<K, V> tail = list.getLastNode();
                list.removeNode(tail);
                map.remove(tail.key);
            }
            Node<K, V> newNode = new Node<>(key, value);
            list.addToHead(newNode);
            map.put(key, newNode);
        }
    }
    
}
