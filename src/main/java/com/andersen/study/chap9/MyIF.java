package com.andersen.study.chap9;

public interface MyIF {
    // Это объявление обычного метода в интерфейсе.
    // Он НЕ предоставляет реализацию по умолчанию
    int getNumber();

    // А это объявление метод по умолчанию.
    default String getString() {
        return "Объект типа String по умолчанию.";
    }

    // Объявление статического метода в интерфейсе
    static int getDefaultNumber() {
        return 0;
    }
}
