import java.util.Objects;
public class MyQueue<T> {
    private Node<T> firstNode;
    private int size = 0;
    private class Node<T> {
        private T element;
        private Node<T> nextElement;

        private Node(T element, Node<T> nextElement) {
            this.element = element;
            this.nextElement = nextElement;
        }
    }
    public void add(T e) {
        if (size == 0)
            firstNode = new Node<T>(e, null);
        else {
            Node<T> currentNode = firstNode;
            Node<T> lastNode = firstNode.nextElement;
            while (lastNode != null) {
                currentNode = lastNode;
                lastNode = lastNode.nextElement;
            }
            currentNode.nextElement = new Node<T>(e, null);
        }
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (size == 1) {
            firstNode = null;
            size = 0;
        }
        else {
            if (index == 0) firstNode = firstNode.nextElement;
            else {
                Node<T> previousNode = firstNode;
                Node<T> nodeToRemove = firstNode;

                for (int i = 0; i < index; i++) {
                    previousNode = nodeToRemove;
                    nodeToRemove = nodeToRemove.nextElement;
                }

                previousNode.nextElement = nodeToRemove.nextElement;
                nodeToRemove = null;
            }
        }
        size--;
    }

    public void clear() {
        while (firstNode != null)
            firstNode = firstNode.nextElement;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return firstNode != null ? firstNode.element : null;
    }

    public T poll() {
        Node<T> result = firstNode;
        if (firstNode != null) {
            firstNode = firstNode.nextElement;
            size--;
            return result.element;
        }
        else
            return null;
    }
}

