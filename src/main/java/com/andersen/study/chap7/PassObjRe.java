package com.andersen.study.chap7;
// Объекты передаются по ссылке на них
class Test2 {
    int a, b;

    Test2(int i, int j) {
        a = i;
        b = j;
    }

    // передать объект
    void meth(Test2 ob) {
        ob.a *= 2;
        ob.b /= 2;
    }
}

class PassObjRe {
    public static void main(String[] args) {
        Test2 ob = new Test2(15, 20);
        System.out.println("ob.a и ob.b до вызова: " + ob.a + " " + ob.b);

        ob.meth(ob);

        System.out.println("ob.a и ob.b после вызова: " + ob.a + " " + ob.b);
    }
}
