package com.andersen.study.chap5;
// Применение оператора break для выхода из цикла
class BreakLoop {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i == 10) break; // выход из цикла, елси значение
                                // переменной i равно 10
            System.out.println("i равно: " + i);
        }
        System.out.println("Цикл завершён.");
    }
}
