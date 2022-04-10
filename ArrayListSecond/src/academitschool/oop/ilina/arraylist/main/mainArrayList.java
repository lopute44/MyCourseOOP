package academitschool.oop.ilina.arraylist.main;

import academitschool.oop.ilina.arraylist.ArrayList;

public class mainArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(20);
        System.out.println("Размер пустого списка: " + list.size());
        System.out.println("Проверка на заполненность пустого списка: " + list.isEmpty());
        System.out.println("Печать пустого списка: " + list);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);

        list.trimToSize();

        System.out.println("Размер заполненного списка: " + list.size());
        System.out.println("Проверка на заполненность заполненного списка: " + list.isEmpty());
        list.set(2, 100);
        System.out.println("Замененный элемент: " + list.get(2));
        System.out.println("Список после замены элемента: " + list);

        list.remove(2);
        System.out.println("Список после удаления элемента с индексом 2: " + list);

        list.add(2, 3);
        System.out.println("Список после добавления элемента по индексу 2: " + list);

    }
}
