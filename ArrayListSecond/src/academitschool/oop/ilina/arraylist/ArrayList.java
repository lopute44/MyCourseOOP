package academitschool.oop.ilina.arraylist;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private Object[] items;
    private int length;

    public ArrayList() {
        items = new Object[10];
        length = 0;
    }

    public ArrayList(int capacity) {
        items = new Object[capacity];
        length = 0;
    }

    private void validateIndex(int index) {
        if (index > length || index < 0) {
            throw new IllegalArgumentException("Индекс за пределами массива!");
        }
    }

    public void increaseCapacity() {
        items = Arrays.copyOf(items, length * 2);
        length = length * 2;
    }

    public void trimToSize() {
        items = Arrays.copyOf(items, length);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public T get(int index) {
        validateIndex(index);

        return (T) items[index];
    }

    @Override
    public void set(int index, T element) {
        validateIndex(index);
        items[index] = element;
    }

    @Override
    public void add(T element) {
        if (length >= items.length){
            increaseCapacity();
        }
        items[length] = element;
        length++;
    }

    @Override
    public String toString() {
        if (length == 0) {
            return "null";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');

        for (int i = 0; i < length - 1; i++) {
            b.append(items[i]);
            b.append(", ");
        }

        return b.append(items[length - 1]).append(']').toString();
    }

    @Override
    public void remove(int index) {
        validateIndex(index);
        if (index < length - 1) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        }

        length--;
    }

    @Override
    public void add(int index, T element) {
        validateIndex(index);

        if (length >= items.length){
            increaseCapacity();
        }

        if (index < length - 1) {
            System.arraycopy(items, index, items, index + 1, length - index);
            items[index] = element;
        } else  {
            items[length - 1] = element;
        }

        length++;
    }
}
