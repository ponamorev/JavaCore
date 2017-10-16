package com.andersen.study.chap6.box4;
/* В данном примере программы для инициализации размеров
   параллелипипеда в классе Box применяется параметризированный
   конструктор
 */
class Box {
    double width;
    double height;
    double depth;

    // это конструктор класса Box
    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // рассчитать и возвратить объём
    double volume() {
        return width * height * depth;
    }
}

class BoxDemo7 {
    public static void main(String[] args) {
        // объявить, выделить память и инициализировать объекты типа Box
        Box mybox1 = new Box(10, 20, 15);
        Box mybox2 = new Box(3, 6, 9);

        double vol;

        // получить объём первого параллелипипеда
        vol = mybox1.volume();
        System.out.println("Объём равен: " + vol);

        // рассчитать объём второго параллелипипеда
        vol = mybox2.volume();
        System.out.println("Объём равен: " + vol);
    }
}
