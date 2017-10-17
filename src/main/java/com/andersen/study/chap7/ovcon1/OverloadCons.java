package com.andersen.study.chap7.ovcon1;
// В данном примере конструкторы определяются в классе Box для
// инициализации размеров параллелепипеда тремя разными способами
class Box {
    double width;
    double height;
    double depth;

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
class OverloadCons {
    public static void main(String[] args) {
        // создаём параллелепипеды, используя
        // разные конструкторы
        Box box1 = new Box(10, 20, 15);
        Box box2 = new Box();
        Box cube = new Box(7);

        double vol;

        // получить объём первого параллелипипеда
        vol = box1.volume();
        System.out.println("Объём box1 равен: " + vol);

        // получить объём второго параллелипипеда
        vol = box2.volume();
        System.out.println("Объём box2 равен: " + vol);

        // получить объём куба
        vol = cube.volume();
        System.out.println("Объём cube равен: " + vol);
    }
}
