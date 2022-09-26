package adts;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V>  {

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public V put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size += 1;
            return null;
        }

        Node node = root;
        Node prev = null;

        while(node != null){
            if (key.compareTo(node.key) < 0) {
                prev = node;
                node = node.left;}
            else if (key.compareTo(node.key) > 0) {
                prev = node;
                node = node.right;}
            else {
                V val = node.value;
                node.value = value;
                return val;
            }
        }
        if(prev.key.compareTo(key) > 0){
            prev.left = new Node(key, value);
        } else {
            prev.right = new Node(key, value);
        }

        size += 1;
        return null;
    }

    public V get(K key) {
        Node node = this.root;

        while (node != null) {

            if (key.compareTo(node.key) == 0) {
                return node.value;
            }
            if (key.compareTo(node.key) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        Node node = this.root;

        while (node != null) {
            if (key.equals(node.key)) {
                return true;
            }
            else if (key.compareTo(node.key) < 0) {
                node = node.left;
            }
            else {
                node = node.right;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.root = null;
        this.size = 0;
    }

    private Node root;

    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }
}


