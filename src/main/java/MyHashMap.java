import java.util.Arrays;

public class MyHashMap<T, V> {
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size = 0;
    private Node[] table = new Node[DEFAULT_INITIAL_CAPACITY];

    public void put(T key, V value) {
        int hash = hash(key);
        int indexToAddNewElement = (table.length - 1) & hash;

        if (table[indexToAddNewElement] == null) {
            table[indexToAddNewElement] = new Node(hash, key, value, null);
            size++;
        }
        else {
            Node<T, V> currentNode = table[indexToAddNewElement];
            boolean equalKeyElementPresent = false;

            if (currentNode.key.equals(key)) {
                currentNode.value = value;
                equalKeyElementPresent = true;
            }
            else {
                while (currentNode.nextElement != null) {
                    currentNode = currentNode.nextElement;

                    if (currentNode.key.equals(key)) {
                        currentNode.value = value;
                        equalKeyElementPresent = true;
                    }
                }

                if (!equalKeyElementPresent) {
                    currentNode.nextElement = new Node(hash, key, value, null);
                    size++;
                }
            }
        }

        if (size > table.length * DEFAULT_LOAD_FACTOR)
            resize();
    }

    public void resize() {
        int oldCapacity = table.length;
        int newCapacity = table.length << 1;
        Node<T, V>[] oldTable = table;
        table = (Node<T,V>[]) new Node[newCapacity];
        size = 0;

        for (int i = 0 ; i < oldCapacity; i++) {
            Node<T, V> currentNode = oldTable[i];

            if (currentNode != null) {
                Node<T, V> nextNode = currentNode.nextElement;
                put(currentNode.key, currentNode.value);
                while (nextNode != null) {
                    put(nextNode.key, nextNode.value);
                    currentNode = nextNode;
                    nextNode = nextNode.nextElement;
                }
            }
        }
    }

    public V get(T key) {
        Node<T, V> nodeToFind = find(key);
        return nodeToFind == null ? null : nodeToFind.value;
    }

    public boolean remove(T key) {
        boolean result = false;
        int hashOfKeyToRemove = hash(key);
        int bucketIndexToFind = (table.length - 1) & hashOfKeyToRemove;
        Node<T, V> currentNode = table[bucketIndexToFind];

        if (currentNode != null) {
            if (currentNode.key.equals(key) && currentNode.hash == hashOfKeyToRemove) {
                table[bucketIndexToFind] = currentNode.nextElement;
                size--;
                result = true;
            }
            else {
                Node<T, V> next = currentNode.nextElement;

                while (next != null) {
                    if (next.key.equals(key) && next.hash == hashOfKeyToRemove) {
                        currentNode.nextElement = next.nextElement;
                        size--;
                        result = true;
                    }
                    next = next.nextElement;
                }
            }
        }

        return result;
    }

    private Node<T, V> find(T key) {
        Node<T, V> nodeToFind = null;

        if (key != null) {
            int hashOfKeyToGet = hash(key);
            int bucketIndexToFind = (table.length - 1) & hashOfKeyToGet;
            Node<T, V> bucketToFind = table[bucketIndexToFind];

            if (bucketToFind != null) {
                Node<T, V> currentNode = bucketToFind;

                if (currentNode.key.equals(key) && currentNode.hash == hashOfKeyToGet)
                    nodeToFind = currentNode;
                else
                    while (currentNode.nextElement != null) {
                        currentNode = currentNode.nextElement;

                        if (currentNode.key.equals(key) && currentNode.hash == hashOfKeyToGet) {
                            nodeToFind = currentNode;
                            break;
                        }
                    }
            }

        }

        return nodeToFind;
    }
    private int hash(Object key) {
        int h = key.hashCode();
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    public int size() {
        return size;
    }

    public void clear() {
        if (size > 0) {
            size = 0;
            for (int i = 0; i < table.length; i++)
                table[i] = null;
        }
    }
    private class Node<T, V> {
        private int hash;
        private T key;
        private V value;
        private Node<T, V> nextElement;

        private Node(int hash, T key, V value, Node nextElement) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.nextElement = nextElement;
        }
    }
}
