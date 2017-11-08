package com.andersen.study.streamAPI;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

// Применение итератора-разделителя в потоке данных
class StreamDemo9 {
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

        // Получение итератора-разделителя
        Spliterator<String> splitter = myStream.spliterator();

        // Перебор элементов в потоке данных
        splitter.forEachRemaining(s -> System.out.println(s));

        myStream = myList.stream();
        splitter = myStream.spliterator();
        System.out.println();
        while (splitter.tryAdvance(System.out::println));
    }
}
