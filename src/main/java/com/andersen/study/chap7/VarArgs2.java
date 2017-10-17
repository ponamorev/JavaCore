package com.andersen.study.chap7;
// Использование аргумента переменной длины вместе
// со старндартными аргументами
class VarArgs2 {
    // msg - обычный параметр, v - параметр переменной длины
    static void vaTest(String msg, int ... v) {
        System.out.print(msg + v.length + "\nСодержимое: ");
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        vaTest("Один параметр переменной длины - ", 10);
        vaTest("Три параметра переменной длины - ", 1, 2, 3);
        vaTest("Без параметров переменной длины - ");
    }
}
