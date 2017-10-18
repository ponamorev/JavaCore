package com.andersen.study.chap9;
// Один интерфейс может расширять другой
interface C {
    void meth1();
    void meth2();
}

// Теперь добавим интерфейс B, который будет включать
// в себя методы meth1() и meth2(), и добавлять метод meth3()
interface D extends C {
    void meth3();
}

// Этот класс должен реализовать все методы из интерфейсов A и B
class MyClass implements D {
    public void meth1() {
        System.out.println("Реализация метода meth1()");
    }

    public void meth2() {
        System.out.println("Реализация метода meth2()");
    }

    public void meth3() {
        System.out.println("Реализация метода meth3()");
    }
}

class IFExtend {
    public static void main(String[] args) {
        MyClass ob = new MyClass();

        ob.meth1();
        ob.meth2();
        ob.meth3();
    }
}
