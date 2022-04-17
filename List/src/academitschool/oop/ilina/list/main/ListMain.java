package academitschool.oop.ilina.list.main;

import academitschool.oop.ilina.list.SinglyLinkedList;

import java.util.ArrayList;

public class ListMain {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>("String1");
        list.addFirst("String2");
        list.addFirst("String3");
        list.addFirst("String4");
        list.addFirst("String5");
        list.addFirst("String6");

        System.out.println(list);

        System.out.println("Удаление элемента индексом 2: " + list.deleteByIndex(2));

        System.out.println(list);

        System.out.println("Элемент с индексом 3: " + list.getByIndex(3));

        System.out.println("Замена элемента с индексом 3 на новой значение, значение старого элемента: " + list.setByIndex(3, "StringNew"));
        System.out.println("Список после замены: " + list);

        System.out.println("Удаление элемента с индексом 3, значение удаленного элемента: " + list.deleteByIndex(3));
        System.out.println("Список после удаления: " + list);
        System.out.println();

        System.out.println("Список после вставки элемента по индексу 3:");
        list.addByIndex(3, "String3");
        System.out.println(list);

        System.out.println("Удаление элемента со значением String5: " + list.delete("String5"));
        System.out.println("Список после удаления элемента" + list);

        System.out.println("Удаление первого элемента: " + list.deleteFirst());
        System.out.println("Список после удаления первого элемента: " + list);

        list.addFirst("FirstString");
        System.out.println("Список после добавления первого элемента: " + list);

        list.inverse();
        System.out.println("Список после разворота: " + list);

        SinglyLinkedList<String> newList = list.copy();
        System.out.println("Новый список, копия предыдущего списка: " + newList);
    }
}
