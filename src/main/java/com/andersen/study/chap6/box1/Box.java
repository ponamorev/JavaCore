package com.andersen.study.chap6.box1;

class Box {
    double width;
    double height;
    double depth;

    // вывести объём параллелипипеда
    void volume() {
        System.out.print("Объём параллелипипеда равен: ");
        System.out.println(width * height * depth);
    }
}
