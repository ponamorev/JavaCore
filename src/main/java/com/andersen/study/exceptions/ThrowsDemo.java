package com.andersen.study.exceptions;
// Эта программа содержит ошибку, и поэтому она не подлежит компиляции (первый вариант)
// Действующий вариант (второй) верный
class ThrowsDemo {
    static void throwOne() throws IllegalAccessException {
        System.out.println("В теле метода throwOne().");
        // первый вариант, неправильный
        // throw new IllegalAccessException("демонстрация");

        throw new IllegalAccessException("демонстрация");
    }

    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Перехвачено исключение: " + e);
        }
    }
}
