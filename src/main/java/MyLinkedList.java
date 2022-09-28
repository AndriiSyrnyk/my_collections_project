import java.util.Objects;

public class MyLinkedList<T>{
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;
    private class Node<T> {
        private T element;
        private Node<T> previousElement;
        private Node<T> nextElement;

        private Node(Node<T> previousElement, T element, Node<T> nextElement) {
            this.previousElement = previousElement;
            this.element = element;
            this.nextElement = nextElement;
        }
    }
    public void add(T e) {
        if (size == 0) {
            firstNode = new Node<T>(null, e, null);
        }
        else {
            Node<T> elementToAdd = new Node<T>(null, e, null);
            if (size == 1)
                linkTwoNodes(firstNode, elementToAdd);
            else
                linkTwoNodes(lastNode, elementToAdd);
            lastNode = elementToAdd;
        }

        size++;
    }
    private void linkTwoNodes(Node<T> firstNode, Node<T> secondNode) {
        firstNode.nextElement = secondNode;
        secondNode.previousElement = firstNode;
    }
    public T get(int index) {
        return getNode(index).element;
    }

    private Node<T> getNode(int index) {
        Objects.checkIndex(index, size);
        Node<T> nodeToGet;

        if (index <= size / 2) {
            nodeToGet = firstNode;
            for (int i = 0; i < index; i++)
                nodeToGet = nodeToGet.nextElement;
        }
        else {
            nodeToGet = lastNode;
            for (int i = size - 1; i > index; i--)
                nodeToGet = nodeToGet.previousElement;
        }

        return nodeToGet;
    }

    public void remove(int index) {
        Node<T> nodeToRemove = getNode(index);

        if (index == 0) removeFirst();
        else if (index == size - 1) removeLast();
        else {
            linkTwoNodes(nodeToRemove.previousElement, nodeToRemove.nextElement);
            nodeToRemove = null;
            size--;
        }
    }
    private void removeFirst() {
        if (firstNode.nextElement != null) {
            firstNode.nextElement.previousElement = null;
            firstNode = firstNode.nextElement;
        }
        else firstNode = null;
        size--;
    }
    private void removeLast() {
        lastNode.previousElement.nextElement = null;
        lastNode = lastNode.previousElement;
        size--;
    }
    public void clear() {
        while (size > 0) removeFirst();
        if (lastNode != null) lastNode = null;
    }

    public int size() {
        return size;
    }
}
