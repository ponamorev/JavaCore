package com.andersen.study.collectionsAPI;

import java.util.LinkedHashSet;
// Демонстрация применения класса LinkedHashSet
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // создать хэш-множество
        LinkedHashSet<String> hs = new LinkedHashSet<String>();

        // ввести элементы в хэш-множество
        hs.add("Бета");
        hs.add("Альфа");
        hs.add("Эта");
        hs.add("Гамма");
        hs.add("Эпсилон");
        hs.add("Омега");

        System.out.println(hs);
    }
}
