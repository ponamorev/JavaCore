package com.andersen.study.chap8.demobox;
// расширение класса Box путём включения в него поля веса
class BoxWeight extends Box {
    double weight; // вес параллелепипеда

    // конструктор BoxWeight()
    BoxWeight(double w, double h, double d, double m) {
        width = w;
        height = h;
        depth = d;
        weight = m;
    }
}
