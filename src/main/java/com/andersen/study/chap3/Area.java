package com.andersen.study.chap3;
// вычислить площадь круга, пример работы с типом double
class Area {
    public static void main(String[] args) {
        double pi, r, a;

        r = 10.8; // радиус окружности
        pi = 3.1416; // примерное значение числа пи
        a = pi * r * r; // вычисление площади круга

        System.out.println("Площадь круга равна " + a);
    }
}