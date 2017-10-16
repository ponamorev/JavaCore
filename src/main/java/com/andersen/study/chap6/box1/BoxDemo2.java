package com.andersen.study.chap6.box1;
// В этой программе объявляются два объекта типа Box
class BoxDemo2 {
    public static void main(String[] args) {
        Box mybox1 = new Box();
        Box mybox2 = new Box();
        double vol;

        // присвоить значения переменным объекта mybox1
        mybox1.width = 10;
        mybox1.height = 20;
        mybox1.depth = 15;

        // присвоить значения переменным объекта mybox2
        mybox2.width = 3;
        mybox2.height = 6;
        mybox2.depth = 9;

        // рассчитать объём первого параллелипипеда
        vol = mybox1.width * mybox1.height * mybox1.depth;
        System.out.println("Объём первого параллелипипеда равен: " + vol);

        // рассчитать объём второго параллелипипеда
        vol = mybox2.width * mybox2.height * mybox2.depth;
        System.out.println("Объём второго параллелипипеда равен: " + vol);
    }
}
