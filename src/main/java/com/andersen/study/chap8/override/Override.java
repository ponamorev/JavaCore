package com.andersen.study.chap8.override;
// Методы с отличающимися сигнатурами считаются
// перегруженными, а не переопределяемыми
class A {
    int i, j;
    A(int a, int b) {
        i = a;
        j = b;
    }
    // вывод содержимого переменных i и j
    void show() {
        System.out.println("i и j: " + i + " " + j);
    }
}

// создать подкласс путём расширения класса А
class B extends A {
    int k;
    B(int a, int b, int c) {
        super(a, b);
        k = c;
    }

    // перегрузка метода show()
    void show(String msg) {
        System.out.println(msg + k);
    }
}

class Override {
    public static void main(String[] args) {
        B subOb = new B(1, 2, 3);

        subOb.show("Это k: "); // вызывается метод из класса B
        subOb.show();               // вызывается метод из класса A
    }
}
