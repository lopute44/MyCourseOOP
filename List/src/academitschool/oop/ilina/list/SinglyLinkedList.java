package academitschool.oop.ilina.list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(T data) {
        head = new ListItem<>(data);
        count = 1;
    }

    public SinglyLinkedList() {
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        ListItem<T> listItem = head;

        for (int i = 1; i < count; i++) {
            stringBuilder.append(listItem.getData());
            stringBuilder.append(", ");

            listItem = listItem.getNext();
        }

        return stringBuilder.append(listItem.getData()).append('}').toString();
    }

    public int getCount() {
        return count;
    }

    public T getFirst() {
        validateCount();

        return head.getData();
    }

    public T getByIndex(int index) {
        validateIndex(index);

        return getItemByIndex(index).getData();
    }

    public T setByIndex(int index, T data) {
        validateIndex(index);

        ListItem<T> item = getItemByIndex(index);

        T oldData = item.getData();
        item.setData(data);

        return oldData;
    }

    public T deleteByIndex(int index) {
        validateIndex(index);

        if (index == 0) {
            return deleteFirst();
        }

        ListItem<T> item = getItemByIndex(index);

        T deletedData = item.getNext().getData();
        item.setNext(item.getNext().getNext());

        count--;
        return deletedData;
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void addByIndex(int index, T data) {
        validateIndex(index);

        if (index == 0) {
            addFirst(data);
        } else {
            ListItem<T> previousItem = getItemByIndex(index - 1);

            ListItem<T> item = new ListItem<>(data, previousItem.getNext());
            previousItem.setNext(item);
        }

        count++;
    }

    public boolean delete(T data) {
        validateCount();

        if (head.getData().equals(data)) {
            deleteFirst();
            return true;
        }

        if (count == 1) {
            return false;
        }

        for (ListItem<T> previousItem = head, currentItem = head.getNext(); currentItem != null; previousItem = currentItem, currentItem = currentItem.getNext()) {
            try {
                if (currentItem.getData().equals(data)) {
                    previousItem.setNext(currentItem.getNext());
                    count--;
                    return true;
                }
            } catch (NullPointerException e) {
                if (data == null) {
                    previousItem.setNext(currentItem.getNext());
                    count--;
                    return true;
                }
            }
        }

        return false;
    }

    public T deleteFirst() {
        if (count == 0) {
            throw new NullPointerException("У пустого списка нет первого элемента!");
        }

        T deletedData = head.getData();
        head = head.getNext();
        count--;
        return deletedData;
    }

    public void inverse() {
        ListItem<T> item = head;

        while (head != null && item.getNext() != null) {
            ListItem<T> newItem = item.getNext();
            item.setNext(newItem.getNext());
            newItem.setNext(head);
            head = newItem;
        }
    }

    public SinglyLinkedList<T> copy() {
        if (count == 0) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<T> newList = new SinglyLinkedList<>(getFirst());

        for (ListItem<T> item = head, newListItem = newList.head; item.getNext() != null; item = item.getNext(), newListItem = newListItem.getNext()) {
            ListItem<T> nextNewListItem = new ListItem<>(item.getNext().getData());
            newListItem.setNext(nextNewListItem);

            newList.count ++;
        }

        return newList;
    }

    private ListItem<T> getItemByIndex(int index) {
        ListItem<T> item = head;

        for (int i = 0; i < index; i++) {
            item = item.getNext();
        }

        return item;
    }

    private void validateIndex(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Переданный индекс " + index + " не в пределах диапазона от 0 до " + count + "!");
        }
    }

    private void validateCount() {
        if (count == 0) {
            throw new NoSuchElementException("Пустой список!");
        }
    }
}
