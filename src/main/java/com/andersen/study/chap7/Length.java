package com.andersen.study.chap7;
// Демонстрация применения члена длины массива
class Length {
    public static void main(String[] args) {
        int a1[] = new int[10];
        int a2[] = {3, 5, 7, 1, 8, 99, 44, -10};
        int a3[] = {4, 3, 2, 1};

        System.out.println("Длина массива a1 = " + a1.length);
        System.out.println("Длина массива a2 = " + a2.length);
        System.out.println("Длина массива a3 = " + a3.length);
    }
}
