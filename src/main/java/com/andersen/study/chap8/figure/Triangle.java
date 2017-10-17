package com.andersen.study.chap8.figure;

class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }

    // переопределим метод area() для прямоугольного треугольника
    double area() {
        System.out.println("Прямоугольный треугольник.");
        return dim1 * dim2 / 2;
    }
}
