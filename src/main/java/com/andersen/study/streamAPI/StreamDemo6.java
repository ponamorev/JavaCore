package com.andersen.study.streamAPI;

import java.util.ArrayList;
import java.util.stream.IntStream;

// Отображение потока данных типа Stream на поток данных типа IntStream
class StreamDemo6 {
    public static void main(String[] args) {
        // Список значений типа double
        ArrayList<Double> list = new ArrayList<>();

        list.add(1.1);
        list.add(3.6);
        list.add(9.2);
        list.add(4.7);
        list.add(12.1);
        list.add(5.0);

        System.out.print("Исходные значения из списка list: ");
        list.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();

        // Отображение максимального допустимого предела каждого значения из списка
        // list на поток данных типа IntStream
        IntStream stream = list.stream().mapToInt(a -> (int) Math.ceil(a));

        System.out.print("Макимально допустимые пределы значений " +
                "из списка list: ");
        stream.forEach(a -> System.out.print(a + " "));
    }
}
