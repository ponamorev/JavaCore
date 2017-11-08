package com.andersen.study.streamAPI;

import java.util.ArrayList;
import java.util.stream.Stream;

// Отображение одного потока данных на другой
class StreamDemo4 {
    public static void main(String[] args) {
        // Создание числового списка типа Double
        ArrayList<Double> list = new ArrayList<>();

        list.add(7.0);
        list.add(18.0);
        list.add(10.0);
        list.add(24.0);
        list.add(17.0);
        list.add(5.0);

        // Отображение квадратные корни элементов из списка list на новый поток данных
        Stream<Double> sqrtRootStream = list.stream().map(Math::sqrt);

        // Получение произведения квадратных корней
        double productOfSqrRoot = sqrtRootStream.reduce(1.0, (a, b) -> a * b);

        System.out.println("Произведение квадратных корней равно " + productOfSqrRoot);
    }
}
