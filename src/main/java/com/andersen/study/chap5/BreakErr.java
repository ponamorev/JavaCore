package com.andersen.study.chap5;
// Эта программа содержит ошибку
class BreakErr {
    public static void main(String[] args) {

        one: for (int i = 0; i < 3; i++) {
            System.out.print("Проход " + i + ": ");
        }

        for (int j = 0; j < 100; j++) {
            if (j == 10) { /*break one; */ } // Ошибка!
            System.out.print(j + " ");
        }
    }
}
