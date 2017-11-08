package com.andersen.study.streamAPI;

import java.util.ArrayList;

// Демонстрация применения объединяющего варианта метода reduce()
class StreamDemo3 {
    public static void main(String[] args) {
        // Создание числового списка типа Double
        ArrayList<Double> list = new ArrayList<>();

        list.add(7.0);
        list.add(18.0);
        list.add(10.0);
        list.add(24.0);
        list.add(17.0);
        list.add(5.0);

        double productOfSqrRoots = list.parallelStream().reduce(1.0,
                (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);

        System.out.println("Произведение квадратных корней: " + productOfSqrRoots);
    }
}
