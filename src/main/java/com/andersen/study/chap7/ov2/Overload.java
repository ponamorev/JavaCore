package com.andersen.study.chap7.ov2;
// Применить автоматическое преобразование типов к перегрузке
class OverloadDemo {
    void test() {
        System.out.println("Параметры отсутствуют.");
    }

    // Перегружаемый метод, проверяющий наличие
    // двух целочисленных параметров
    void test(int a, int b) {
        System.out.println("a и b: " + a + " и " + b);
    }

    // Перегружаемый метод, проверяющий наличие
    // параметра типа double
    void test(double a) {
        System.out.println("Внутреннее преобразование при вызове test(double) a: " + a);
    }
}
class Overload {
    public static void main(String[] args) {
        OverloadDemo ob = new OverloadDemo();
        int i = 88;

        ob.test();
        ob.test(10, 20);

        ob.test(i);
        ob.test(123.2);
    }
}
