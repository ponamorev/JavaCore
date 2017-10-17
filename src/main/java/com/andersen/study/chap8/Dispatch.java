package com.andersen.study.chap8;
// Динамическая диспетчеризация методов
class J {
    void callme() {
        System.out.println("В методе callme() класса J");
    }
}

class K extends J {
    // переопределяем метод callme()
    void callme() {
        System.out.println("В методе callme() класса K");
    }
}

class L extends J {
    // переопределяем метод callme()
    void callme() {
        System.out.println("В методе callme() класса L");
    }
}

class Dispatch {
    public static void main(String[] args) {
        J j = new J(); // объект класса J
        K k = new K(); // объект класса K
        L l = new L(); // объект класса L

        J r; // ссылка на объекта типа J

        r = j;
        r.callme();

        r = k;
        r.callme();

        r = l;
        r.callme();
    }
}
