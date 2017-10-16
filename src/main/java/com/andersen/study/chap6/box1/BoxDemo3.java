package com.andersen.study.chap6.box1;
// В этой программе применяется метод, определённый в классе Box
class BoxDemo3 {
    public static void main(String[] args) {
        Box mybox1 = new Box();
        Box mybox2 = new Box();

        // присвоить значения переменным объекта mybox1
        mybox1.width = 10;
        mybox1.height = 20;
        mybox1.depth = 15;

        // присвоить значения переменным объекта mybox2
        mybox2.width = 3;
        mybox2.height = 6;
        mybox2.depth = 9;

        // рассчитать объём первого параллелипипеда
        mybox1.volume();

        // рассчитать объём второго параллелипипеда
        mybox2.volume();
    }
}
