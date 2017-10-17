package com.andersen.study.chap7;
// Демонстрация различий между модификакторами доступа private и public
class Test4 {
    int a; // default
    public int b; // public
    private int c; // private

    // методы доступа к члену c данного класса
    void setc(int i) { // установить значение переменной
        c = i;
    }
    int getc() { // получить значение переменной
        return c;
    }
}

public class AccessTest {
    public static void main(String[] args) {
        Test4 ob = new Test4();

        // переменные a и b доступны непосредственно
        ob.a = 10;
        ob.b = 20;

        // этот оператор неверен и может вызвать ошибку
        // ob.c = 100;

        // доступ к этому члену класса осуществляется через методы
        ob.setc(100);
        System.out.println("a, b и c: " + ob.a + ", " + ob.b + " и " + ob.getc());
    }
}
