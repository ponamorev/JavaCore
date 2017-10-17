package com.andersen.study.chap8;
// Простой пример абстракции
abstract class M {
    abstract void callme();

    // абстрактные классы могут содержать и не абстрактные методы
    void callmetoo() {
        System.out.println("Это конкретный метод.");
    }
}

class N extends M {
    void callme() {
        System.out.println("Реализация метода callme() из класса N.");
    }
}

class AbstractDemo {
    public static void main(String[] args) {
        N n = new N();

        n.callme();
        n.callmetoo();
    }
}
