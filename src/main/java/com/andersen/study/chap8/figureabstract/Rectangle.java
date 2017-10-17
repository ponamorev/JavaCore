package com.andersen.study.chap8.figureabstract;

class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }

    // переопределяем метод area() для прямоугольника
    double area() {
        System.out.println("Прямоугольник.");
        return dim1 * dim2;
    }
}
