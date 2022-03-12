package academitschool.oop.ilina.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(ListItem<T> head, int count) {
        this.head = head;
        this.count = count;
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "null";
        }

        StringBuilder b = new StringBuilder();
        b.append('{');

        ListItem<T> listItem = head;

        for (int i = 0; i < count - 1; i++) {
            b.append(listItem.getData());
            listItem = listItem.getNext();
            b.append(", ");
        }

        return b.append(listItem).append('}').toString();
    }

    public int getSize() {
        return count;
    }

    public T getFirstItem() {
        return head.getData();
    }

    private void validateIndex(int index) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Переданный индекс выходит за пределы списка!");
        }
    }

    public T getDataByIndex(int index) {
        this.validateIndex(index);

        if (index == 0) {
            return getFirstItem();
        }

        ListItem<T> item = head;

        for (int i = 0; i < index; i++) {
            item = item.getNext();
        }

        return (item.getData());
    }

    public T setDataByIndex(int index, T value) {
        this.validateIndex(index);

        T data;

        if (index == 0) {
            data = head.getData();
            head.setData(value);
            return data;
        }

        ListItem<T> item = head;

        for (int i = 0; i < index; i++) {
            item = item.getNext();
        }

        data = item.getData();
        item.setData(value);

        return (data);
    }

    public T deleteElementByIndex(int index) {
        validateIndex(index);

        T data;
        if (index == 0) {
            deleteHead();
        }

        ListItem<T> item = head;

        for (int i = 0; i < index - 1; i++) {
            item = item.getNext();
        }

        data = item.getNext().getData();
        item.setNext(item.getNext().getNext());

        count--;
        return data;
    }

    public void setElementInHead(ListItem<T> item) {
        item.setNext(head);
        head = item;
        count++;
    }

    public void setElementByIndex(int index, ListItem<T> item) {
        if (index == 0) {
            setElementInHead(item);
        }

        ListItem<T> previousItem = head;

        for (int i = 0; i < index - 1; i++) {
            previousItem = previousItem.getNext();
        }

        item.setNext(previousItem.getNext());
        previousItem.setNext(item);

        count++;
    }

    public boolean deleteElementByData(T data) {
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (p.getNext().getData().equals(data)) {
                p.setNext(p.getNext().getNext());
                count--;
                return true;
            }
        }

        return false;
    }

    public T deleteHead() {
        T data;
        data = head.getData();
        head = head.getNext();
        count--;
        return data;
    }

    public void inverseList() {
        ListItem<T> item = head;

        while (item.getNext() != null) {
            ListItem<T> newItem = item.getNext();
            item.setNext(newItem.getNext());
            newItem.setNext(head);
            head = newItem;
        }
    }

    public void copyList(SinglyLinkedList<T> list) {
        count = list.count;
        head = list.head;

        for (ListItem<T> p = head, copyList = list.head, prev = null; copyList != null; prev = p, p = p.getNext(), copyList = copyList.getNext()) {
            p.setData(copyList.getData());
            if (prev != null) {
                prev.setNext(p);
            }
        }
    }
}
