package academitschool.oop.ilina.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(T data) {
        head = new ListItem<>(data, null);
        count = 1;
    }

    public SinglyLinkedList(){
        head = null;
        count = 0;
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
        if (count == 0) {
            throw new NullPointerException("У пустого списка нет первого элемента!");
        }

        return head.getData();
    }

    public T getByIndex(int index) {
        validateIndex(index);

        ListItem<T> item = findItemByIndex(index);

        return (item.getData());
    }

    public T setByIndex(int index, T data) {
        validateIndex(index);

        T oldData;

        ListItem<T> item = findItemByIndex(index);

        oldData = item.getData();
        item.setData(data);

        return (oldData);
    }

    public T deleteByIndex(int index) {
        validateIndex(index);

        if (index == 0) {
            return deleteFirst();
        } else {
            ListItem<T> item = findItemByIndex(index);

            T deletedData = item.getNext().getData();
            item.setNext(item.getNext().getNext());

            count--;
            return deletedData;
        }
    }

    public void addFirst(T data) {
        if (count > 0) {
            head = new ListItem<>(data, head);
        } else {
            head = new ListItem<>(data);
        }

        count++;
    }

    public void addByIndex(int index, T data) {
        if (index == 0) {
            addFirst(data);
        } else {
            ListItem<T> item = new ListItem<>(data);

            ListItem<T> previousItem = findItemByIndex(index);

            item.setNext(previousItem.getNext());
            previousItem.setNext(item);
        }

        count++;
    }

    public boolean delete(T data) {
        if (head.getData().equals(data)) {
            deleteFirst();
            return true;
        }

        for (ListItem<T> previousItem = head, currentItem = head.getNext(); currentItem.getNext() != null; previousItem = currentItem, currentItem = currentItem.getNext()) {
            if (currentItem.getData() != null && currentItem.getData().equals(data)) {
                previousItem.setNext(currentItem.getNext());
                count--;
                return true;
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

        ListItem<T> item = head.getNext();

        for (int i = 1; i < count; i++) {
            newList.addByIndex(i, item.getData());
            item = item.getNext();
        }

        return newList;
    }

    private ListItem<T> findItemByIndex(int index) {
        ListItem<T> item = head;

        for (int i = 0; i < index - 1; i++) {
            item = item.getNext();
        }

        return item;
    }

    private void validateIndex(int index) {
        if (index >= count || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Переданный индекс " + index + " выходит за пределы диапазона от 0 до " + count + "!");
        }
    }
}
