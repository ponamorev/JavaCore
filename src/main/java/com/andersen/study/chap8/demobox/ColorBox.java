package com.andersen.study.chap8.demobox;
// Этот класс расширяет класс Box, включя в него свойство цвета
class ColorBox extends Box {
    int color; // цвет

    ColorBox(double w, double h, double d, int c) {
        width = w;
        height = h;
        depth = d;
        color = c;
    }
}
