package com.andersen.study.chap6.box2;
// Теперь метод volume() возвращаем объём параллелипипеда
class BoxDemo4 {
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
        vol = mybox1.volume();
        System.out.println("Объём равен: " + vol);

        // рассчитать объём второго параллелипипеда
        vol = mybox2.volume();
        System.out.println("Объём равен: " + vol);
    }
}
