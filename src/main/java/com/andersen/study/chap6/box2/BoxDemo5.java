package com.andersen.study.chap6.box2;
// Применение метода с параметрами
class BoxDemo5 {
    public static void main(String[] args) {
        Box mybox1 = new Box();
        Box mybox2 = new Box();
        double vol;

        // инициализировать каждый экземпляр класса Box
        mybox1.setDim(10, 20, 15);
        mybox2.setDim(3, 6, 9);

        // получить объём первого параллелипипеда
        vol = mybox1.volume();
        System.out.println("Объём равен: " + vol);

        // рассчитать объём второго параллелипипеда
        vol = mybox2.volume();
        System.out.println("Объём равен: " + vol);
    }
}
