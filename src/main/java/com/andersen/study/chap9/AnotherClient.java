package com.andersen.study.chap9;
// ещё одна реализация интерфейса Callback
class AnotherClient implements Callback {
    // реализация метода callback()
    public void callback(int p) {
        System.out.println("Ещё один вариант метода callback()");
        System.out.println("p в квадрате равно " + (p * p));
    }
}
