package com.andersen.study.chap7;
// Простой пример рекурсии
class Factorial {
    // рекурсивный метод
    int fact(int n) {
        int result;

        if (n == 1) return 1;
        result = fact(n - 1) * n;
        return result;
    }
}

class Recursion {
    public static void main(String[] args) {
        Factorial f = new Factorial();

        System.out.println("Факториал числа 3 равен: " + f.fact(3));
        System.out.println("Факториал числа 4 равен: " + f.fact(4));
        System.out.println("Факториал числа 5 равен: " + f.fact(5));
    }
}
