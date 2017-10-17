package com.andersen.study.chap7;
// Эта программа не подлежит компиляции
// Демонстрация недоступности переменных внутреннего класса внешнему
class OuterV2 {
    int outer_x = 100;

    void test() {}

    // внутренний класс
    class Inner {
        int y = 10; // y - локальная переменная

        void display() {
            System.out.println("вывод: outer_x = " + outer_x);
        }
    }

    void showy() {
        // System.out.println(y); // переменная y здесь недоступна
    }
}
class InnerClassDemoNoCompile {
    public static void main(String[] args) {
        OuterV2 outer = new OuterV2();
        outer.test();
    }
}
