package com.andersen.study.collectionsAPI;

import java.util.TreeSet;

// Демонстрация применения класса TreeSet
public class TreeSetDemo {
    public static void main(String[] args) {
        // создать древовидное множество типа TreeSet
        TreeSet<String> ts = new TreeSet<String>();

        // ввести элементы в древовидное множество типа TreeSet
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        System.out.println(ts);
        System.out.println(ts.subSet("C", "F"));
    }
}
