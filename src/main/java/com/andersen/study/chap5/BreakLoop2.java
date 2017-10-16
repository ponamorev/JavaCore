package com.andersen.study.chap5;
// Применение оператора break для выхода из цикла while
class BreakLoop2 {
    public static void main(String[] args) {
        int i = 0;

        while (i < 100) {
            if (i == 10) break; // выход из цикла, если значение
                                // переменной i равно 10
            System.out.println("i равно: " + i);
            i++;
        }

        System.out.println("Цикл завершён.");
    }
}
