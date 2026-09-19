class Node {

    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (map.containsKey(key)) {

            Node res = map.get(key);

            // Remove res from its current position
            Node bef = res.prev;
            Node aft = res.next;

            bef.next = aft;
            aft.prev = bef;

            // Put res right after head
            Node afthead = head.next;

            head.next = res;
            res.prev = head;
            res.next = afthead;
            afthead.prev = res;

            return res.value;
        }

        return -1;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node res = map.get(key);

            // Update value
            res.value = value;

            // Remove from current position
            Node bef = res.prev;
            Node aft = res.next;

            bef.next = aft;
            aft.prev = bef;

            // Move to front
            Node afthead = head.next;

            head.next = res;
            res.prev = head;
            res.next = afthead;
            afthead.prev = res;

        }

        // Key doesn't exist
        else {

            // Cache is full
            if (map.size() == capacity) {

                // Remove least recently used node
                Node del = tail.prev;

                Node bforedel = del.prev;

                bforedel.next = tail;
                tail.prev = bforedel;

                // IMPORTANT: remove from HashMap too
                map.remove(del.key);

                del.next = null;
                del.prev = null;
            }

            // Create new node
            Node res = new Node(key, value);

            // Insert at front
            Node aft = head.next;

            head.next = res;
            res.prev = head;
            res.next = aft;
            aft.prev = res;

            // Add to map
            map.put(key, res);
        }
    }
}