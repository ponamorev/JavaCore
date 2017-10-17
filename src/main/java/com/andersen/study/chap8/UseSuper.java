package com.andersen.study.chap8;
// Использовать ключевое слово super с целью предотвратить сокрытие имён
class E {
    int i;
}

class F extends E {
    int i; // этот член i скрывает член i суперкласса Е

    F(int a, int b) {
        super.i = a; // член из класса E
        i = b; // член из класса F
    }

    void show() {
        System.out.println("Член i в суперклассе: " + super.i);
        System.out.println("Член i в подклассе: " + i);
    }
}

class UseSuper {
    public static void main(String[] args) {
        F subOb = new F(1, 2);

        subOb.show();
    }
}
