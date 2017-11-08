package com.andersen.study.streamAPI;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

// Демонстрация применения метода trySplit()
class StreamDemo10 {
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

        // Попытка разделить первый итератор
        Spliterator<String> splitter1 = splitter.trySplit();

        // Сначала используется итератор splitter1, если нельзя разделить splitter
        if (splitter1 != null) {
            System.out.println("Результат, выводимый итератором splitter1:");
            splitter1.forEachRemaining(System.out::println);
        }

        // Теперь используем итератор splitter
        System.out.println("\nРезультат, выводимый итератором splitter:");
        splitter.forEachRemaining(System.out::println);
    }
}
