package com.andersen.study.chap6.box2;

class Box {
    double width;
    double height;
    double depth;

    // рассчитать и возвратить объём
    double volume() {
        return width * height * depth;
    }

    void setDim(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }
}
