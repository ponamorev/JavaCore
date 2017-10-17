package com.andersen.study.chap7;
// Определение внутреннего класса в цикле for
class OuterV3 {
    int outer_x = 100;

    void test() {
        for (int i = 0; i < 10; i++) {
            class Inner {
                void display() {
                    System.out.println("outer_x = " + outer_x);
                }
            }
            Inner inner = new Inner();
            inner.display();
        }
    }
}

class InnerClassDemoFor {
    public static void main(String[] args) {
        OuterV3 outer = new OuterV3();
        outer.test();
    }
}
