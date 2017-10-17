package com.andersen.study.chap8.figure;

class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }

    // переопределим метод area() для четырехугольника
    double area() {
        System.out.println("Прямоугольник.");
        return dim1 * dim2;
    }
}
