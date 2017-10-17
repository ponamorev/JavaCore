package com.andersen.study.chap7.ovcon2;
// В этой версии класса Box один объект допускается
// инициализировать другим объектом
class Box {
    double width;
    double height;
    double depth;

    // используем в качестве параметра объект класса Box
    Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    // конструктор, используемый при указании всех размеров
    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // конструктор, используемый, когда ни один из размеров не указан
    Box() {
        width = -1;  // значение -1 используется
        height = -1; // для неинициализированного
        depth = -1;  // параллелепипеда
    }

    // конструктор, используемый при создании куба
    Box(double len) {
        width = height = depth = len;
    }

    // рассчитать и возвратить объём
    double volume() {
        return width * height * depth;
    }
}

class OverloadCons2 {
    public static void main(String[] args) {
        //создаем параллелепипеды, используя
        // разные конструкторы
        Box mybox1 = new Box(10, 20, 15);
        Box mybox2 = new Box();
        Box mycube = new Box(7);

        Box myclone = new Box(mybox1);

        double vol;

        // получить объём первого параллелипипеда
        vol = mybox1.volume();
        System.out.println("Объём mybox1 равен: " + vol);

        // получить объём второго параллелипипеда
        vol = mybox2.volume();
        System.out.println("Объём mybox2 равен: " + vol);

        // получить объём куба
        vol = mycube.volume();
        System.out.println("Объём mycube равен: " + vol);

        // получить объём клона
        vol = myclone.volume();
        System.out.println("Объём клона равен: " + vol);
    }
}
