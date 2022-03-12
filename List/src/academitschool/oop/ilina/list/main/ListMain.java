package academitschool.oop.ilina.list.main;

import academitschool.oop.ilina.list.ListItem;
import academitschool.oop.ilina.list.SinglyLinkedList;

public class ListMain {
    public static void main(String[] args) {
        ListItem<String> listItem1 = new ListItem<String>("String1", null);
        ListItem<String> listItem2 = new ListItem<String>("String2", listItem1);
        ListItem<String> listItem3 = new ListItem<String>("String3", listItem2);
        ListItem<String> listItem4 = new ListItem<String>("String4", listItem3);
        ListItem<String> listItem5 = new ListItem<String>("String5", listItem4);

        SinglyLinkedList<String> list = new SinglyLinkedList<String>(listItem5, 5);

        System.out.println(list);

        System.out.println("Элемент с индексом 3: " + list.getDataByIndex(3));

        System.out.println("Замена элемента с индексом 3 на новой значение, значение старого элемента: " + list.setDataByIndex(3, "StringNew"));
        System.out.println("Список после замены: " + list);

        System.out.println("Удаление элемента с индексом 3, значение удаленного элемента: " + list.deleteElementByIndex(3));
        System.out.println("Список после удаления: " + list);
        System.out.println();

        ListItem<String> listItem6 = new ListItem<String>("Item in head", null);
        System.out.println("Список после вставки элемента в начало списка:");
        list.setElementInHead(listItem6);
        System.out.println(list);

        ListItem<String> listItem7 = new ListItem<String>("Item by index", null);
        System.out.println("Список после вставки элемента по индексу 2:");
        list.setElementByIndex(2, listItem7);
        System.out.println(list);

        System.out.println("Удаление элемента со значением String5: " + list.deleteElementByData("String5"));
        System.out.println("Список после удаления элемента" + list);

        System.out.println("Удаление первого элемента: " + list.deleteHead());
        System.out.println("Список после удаления первого элемента" + list);

        list.inverseList();
        System.out.println("Список после разворота: " + list);

        SinglyLinkedList<String> newList = new SinglyLinkedList<>(null, 0);

        newList.copyList(list);
        System.out.println("Новый список, копия предыдущего списка: " + newList);
    }
}
