package Problems.LRUCache;

public class DoublyLinkedList<K, V> {
    private Node<K, V> head;
    private Node<K, V> tail;

    public DoublyLinkedList() {
        head = new Node<K, V>(null, null);
        tail = new Node<K, V>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void addToHead(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(Node<K, V> node) {
        if (node == null) return;

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node<K, V> getLastNode() {
        if(tail.prev == head) {
            return null;
        }
        return tail.prev;
    }
    
}
