package com.andersen.study.chap6.box3;
// В этой программе для инициализации размеров параллелипипеда используется конструктор
class Box {
    double width;
    double height;
    double depth;

    // это конструктор класса Box
    Box() {
        System.out.println("Конструирование объекта Box");
        width = 10;
        height = 10;
        depth = 10;
    }

    // рассчитать и возвратить объём
    double volume() {
        return width * height * depth;
    }
}

class BoxDemo6 {
    public static void main(String[] args) {
        // объявить, выделить память и инициализировать объекты типа Box
        Box mybox1 = new Box();
        Box mybox2 = new Box();

        double vol;

        // получить объём первого параллелипипеда
        vol = mybox1.volume();
        System.out.println("Объём равен: " + vol);

        // рассчитать объём второго параллелипипеда
        vol = mybox2.volume();
        System.out.println("Объём равен: " + vol);
    }
}
