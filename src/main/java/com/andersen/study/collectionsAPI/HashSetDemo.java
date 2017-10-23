package com.andersen.study.collectionsAPI;

import java.util.HashSet;

// Демонстрация применения класса HashSet
class HashSetDemo {
    public static void main(String[] args) {
        // создать хэш-множество
        HashSet<String> hs = new HashSet<String>();

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
