package com.andersen.study.collectionsAPI;

import java.util.ArrayList;

// Демонстрация применения класса ArrayList
class ArrayListDemo {
    public static void main(String[] args) {
        // создать списочный массив
        ArrayList<String> a1 = new ArrayList<String>();

        System.out.println("Начальный размер списочного массива a1: " + a1.size());

        // ввести элементы в массив
        a1.add("C");
        a1.add("A");
        a1.add("E");
        a1.add("B");
        a1.add("D");
        a1.add("F");
        a1.add(1, "A2");
        System.out.println("Размер списочного массива a1 после " +
                "ввода элементов: " + a1.size());

        // вывести списочный массив
        System.out.println("Содержимое списочного массива a1: " + a1);

        // удалить элементы из массива
        a1.remove("F");
        a1.remove(2);
        System.out.println("Размер списочного массива a1 после " +
                "удаления элементов: " + a1.size());

        System.out.println("Содержимое списочного массива a1: " + a1);
    }
}
