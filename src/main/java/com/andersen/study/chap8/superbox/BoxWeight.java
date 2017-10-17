package com.andersen.study.chap8.superbox;

// расширение класса Box путём включения в него поля веса
class BoxWeight extends Box {
    double weight; // вес параллелепипеда

    // сконструировать клон объекта
    BoxWeight(BoxWeight ob) {
        super(ob);
        weight = ob.weight;
    }

    // конструктор, применяемый при указании всех параметров
    BoxWeight(double w, double h, double d, double m) {
        super(w, h, d);
        weight = m;
    }

    // конструктор, применяемый в отсутствии параметров
    BoxWeight() {
        super();
        weight = -1;
    }

    // конструктор, применяемый при создании куба
    BoxWeight(double len, double m) {
        super(len);
        weight = m;
    }
}
