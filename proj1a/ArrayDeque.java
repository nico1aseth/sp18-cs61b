public class ArrayDeque<T> {
    private T[] items;
    private int left;
    private int right;
    private int capacity = 8;

    public ArrayDeque() {
        items = (T[]) new Object[capacity];
        left = right = 0;
    }

    public int size() {
        return (right - left + capacity) % capacity;
    }

    public boolean isFull() {
        return size() == capacity - 1;
    }

    public boolean isEmpty() {
        return left == right;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        int size = size();
        int j = 0;

        for (int i = 0; i < size; i++) {
            newArray[i] = items[j];
            j++;
        }
        left = 0;
        right = size;
        items = newArray;
        capacity = newSize;
    }

    public void addFirst(T item) {
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }

        left = (left - 1 + capacity) % capacity;
        items[left] = item;
    }

    public void addLast(T item) {
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }

        items[right] = item;
        right = (right + 1 + capacity) % capacity;
    }
}