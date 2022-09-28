import java.util.Objects;
public class MyArrayList<T> {
    static final int DEFAULT_INITIAL_CAPACITY = 10;
    private Object[] elementData = new Object[DEFAULT_INITIAL_CAPACITY];
    private int size = 0;

    public void add(T element) {
        if (size == elementData.length)
            increaseCapacity();
        elementData[size] = element;
        size++;
    }

    private void increaseCapacity() {
        Object[] tempData = new Object[elementData.length * 3 / 2];
        System.arraycopy(elementData, 0, tempData,0, elementData.length);
        elementData = tempData;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        for (int i = index; i < size - 1; i++)
            elementData[i] = elementData[i + 1];
        elementData[size - 1] = null;
        size--;
        if (size * 3 / 2 < elementData.length)
            decreaseCapacity();
    }

    private void decreaseCapacity() {
        Object[] tempData = new Object[size];
        System.arraycopy(elementData, 0, tempData,0, tempData.length);
        elementData = tempData;
    }

    public void clear() {
        elementData = new Object[DEFAULT_INITIAL_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }
    public Object get(int index) {
        return elementData[index];
    }
}