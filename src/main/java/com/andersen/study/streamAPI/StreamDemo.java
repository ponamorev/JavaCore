package com.andersen.study.streamAPI;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

// Демонстрация нескольких потоковых операций
class StreamDemo {
    public static void main(String[] args) {
        // Создание списочного массива типа Integer
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Исходный список: " + myList);

        // Получение потока элементов списочного массива
        Stream<Integer> myStream = myList.stream();

        // Получение минимального и максимального значений при помощи
        // методов min(), max(), isPresent(), get()
        Optional<Integer> minVal = myStream.min(Integer::compare);
        minVal.ifPresent(integer -> System.out.println("Минимальное значение: " +
                integer));

        // Получение нового потока данных, т.к. min() является оконечной операцией
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        maxVal.ifPresent(integer -> System.out.println("Максимальное значение: " +
                integer));

        // Сортировка поток данных, вызвав метод sorted()
        Stream<Integer> sortedStream = myList.stream().sorted();

        // Отображение отсортированного потока данных при помощи метода forEach()
        System.out.print("Отсортированный поток данных: ");
        sortedStream.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Вывод только нечётных целочисленных значений при помощи метода filter()
        Stream<Integer> oddVals =
                myList.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.print("Нечётные значения: ");
        oddVals.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Вывод только тех нечётных целочисленных значений,
        // которые больше 5
        oddVals = myList.stream().filter(n -> (n % 2) == 1).filter(n -> n > 5);
        System.out.print("Нечётные значения больше 5: ");
        oddVals.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
