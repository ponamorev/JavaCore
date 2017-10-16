package com.andersen.study.chap6.box1;
// Эта программа объявляет объект типа Box
class BoxDemo {
    public static void main(String[] args) {
        Box mybox = new Box();
        double vol;

        // присвоить значения переменным объекта mybox
        mybox.width = 10;
        mybox.height = 20;
        mybox.depth = 15;

        // рассчитать объём параллелипипеда
        vol = mybox.width * mybox.height * mybox.depth;
        System.out.println("Объём параллелипипеда равен: " + vol);
    }
}
