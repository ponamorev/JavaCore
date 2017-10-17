package com.andersen.study.chap8.figureabstract;

class AbstractAreas {
    public static void main(String[] args) {
        // Figure f = new Figure(10, 10); // теперь этот объявление недопустимо
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);
        Figure figref; // верно, создается ссылка, а не объект

        figref = r;
        System.out.println("Площадб фигуры равна: " + figref.area());

        figref = t;
        System.out.println("Площадб фигуры равна: " + figref.area());
    }
}
