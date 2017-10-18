package com.andersen.study.chap9;

abstract class Incomplite implements Callback {
    int a, b;

    void show() {
        System.out.println(a + " " + b);
    }

    // ...
}
