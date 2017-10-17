package com.andersen.study.chap8.figureabstract;
// Применение абстрактных методов и классов
abstract class Figure {
    double dim1;
    double dim2;
    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    // абстрактный метод area()
    abstract double area();
}
