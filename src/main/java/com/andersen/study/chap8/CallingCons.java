package com.andersen.study.chap8;
// Демонстрация порядка вызовов конструкторов при наследовании
// суперкласс G
class G {
    G() {
        System.out.println("В конструкторе G");
    }
}

// расширение класса G
class H extends G {
    H() {
        System.out.println("В конструкторе H");
    }
}

// расширение класса H
class I extends H {
    I() {
        System.out.println("В конструкторе I");
    }
}

class CallingCons {
    public static void main(String[] args) {
        I i = new I();
    }
}
