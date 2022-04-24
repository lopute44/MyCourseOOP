package academitschool.oop.ilina.HashTable.main;

import academitschool.oop.ilina.HashTable.HashTable;

public class HashTableMain {
    public static void main(String[] args) {
        HashTable<String> hashTable = new HashTable<>(20);

        hashTable.setElement("String");
        hashTable.setElement("String");
        hashTable.setElement("String1");
        hashTable.setElement("String2");
        hashTable.setElement("String3");

        System.out.println("Хэш таблица: " + hashTable);

        String string = "String3";
        if (hashTable.isContainElement(string)){
            System.out.println("Хэш таблица содержит элемент: " + string);
        }
    }
}
