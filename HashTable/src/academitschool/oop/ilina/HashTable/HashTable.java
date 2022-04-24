package academitschool.oop.ilina.HashTable;

import java.util.ArrayList;

public class HashTable<T> {
    final private ArrayList<T>[] hashTable;

    public HashTable(int size) {
        hashTable = new ArrayList[size];
    }

    public int getSize() {
        return hashTable.length;
    }

    public void setElement(T element) {
        int index = Math.abs(element.hashCode() % getSize());

        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
        }

        hashTable[index].add(element);
    }

    public boolean isContainElement (T element) {
        int index = Math.abs(element.hashCode() % getSize());

        ArrayList<T> resultList = hashTable[index];

        if (resultList == null) {
            return false;
        }

        for (T s : resultList) {
            if (s.equals(element)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        for (ArrayList<T> e : hashTable) {
            stringBuilder.append(e);
            stringBuilder.append(", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        return stringBuilder.append("}").toString();
    }
}
