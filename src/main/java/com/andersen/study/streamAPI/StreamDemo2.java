package com.andersen.study.streamAPI;

import java.util.ArrayList;
import java.util.Optional;

// Демонстрация применения метода reduce()
class StreamDemo2 {
    public static void main(String[] args) {
        // Создание списка объектов типа Integer
        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        // Два способа для получения результата перемножения целочисленных
        // элементов списка myList с помощью метода reduce()
        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b);
        productObj.ifPresent(integer -> System.out.println("Произведение" +
                " в виде объекта типа Optional: " + productObj.get()));

        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Произведение в виде значения типа int: " + product);
    }
}
