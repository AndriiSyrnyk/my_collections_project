import java.util.EmptyStackException;
import java.util.Objects;

public class MyStack<T> {
    private Node<T> firstNode;
    private int size = 0;
    private class Node<T> {
        private T element;
        private Node<T> previousElement;

        private Node(T element, Node<T> previousElement) {
            this.element = element;
            this.previousElement = previousElement;
        }
    }

    public void push(T e) {
        if (size == 0)
            firstNode = new Node<T>(e, null);
        else
            firstNode = new Node<T>(e, firstNode);
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);

        if (size == 1) {
            firstNode = null;
            size = 0;
        }
        else {
            if (index == size - 1) firstNode = firstNode.previousElement;
            else
            {
                Node<T> previousNode = firstNode;
                Node<T> nodeToRemove = firstNode;

                for (int i = size - 1; i > index; i--) {
                    previousNode = nodeToRemove;
                    nodeToRemove = nodeToRemove.previousElement;
                }

                previousNode.previousElement = nodeToRemove.previousElement;
                nodeToRemove = null;
            }
        }
        size--;
    }

    public void clear() {
        while (firstNode != null)
            firstNode = firstNode.previousElement;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (firstNode != null)
            return firstNode.element;
        else {
            throw new EmptyStackException();
        }
    }

    public T pop() {
        Node<T> result = firstNode;
        if (firstNode != null) {
            firstNode = firstNode.previousElement;
            size--;
            return result.element;
        }
        else
            throw new EmptyStackException();
    }
}
