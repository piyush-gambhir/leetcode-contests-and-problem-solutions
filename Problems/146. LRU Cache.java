import java.util.*;

class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1; // Key not found
        }
        // Move the accessed node to the front of the list
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            // Key is not present in the cache
            node = new Node(key, value);
            cache.put(key, node);
            addToFront(node);
            if (cache.size() > capacity) {
                // Remove the least recently used item from the cache
                Node tailPrev = tail.prev;
                removeFromList(tailPrev);
                cache.remove(tailPrev.key);
            }
        } else {
            // Key is already present in the cache, update its value
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        removeFromList(node);
        addToFront(node);
    }

    private void removeFromList(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addToFront(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
}
