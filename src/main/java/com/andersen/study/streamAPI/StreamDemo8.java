package com.andersen.study.streamAPI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

// Применение итератора в потоке данных
class StreamDemo8 {
    public static void main(String[] args) {
        // Создание списочного массива символьных строк
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Альфа");
        myList.add("Бета");
        myList.add("Гамма");
        myList.add("Дельта");
        myList.add("Кси");
        myList.add("Омега");

        // Получение потока данных для списочного массива
        Stream<String> myStream = myList.stream();

        // Получение итератора для потока данных
        Iterator<String> iterator = myStream.iterator();

        // Перебор элементов в потоке данных
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
