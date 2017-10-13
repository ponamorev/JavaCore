package com.andersen.study.chap3;
// вычисление расстояния, которое пройдёт свет
// при помощи переменной типа long
class Light {
    public static void main(String[] args) {
        int lightspeed;
        long days;
        long seconds;
        long distance;

        // приблизительная скорость света, м/с
        lightspeed = 186000;

        days = 1000; // количество дней

        seconds = days * 24 * 60 * 60; // количество времени в секундах

        distance = lightspeed * seconds; // расстояние, которое пройдёт свет

        System.out.print("За " + days);
        System.out.print(" дней свет пройдёт приблизительно ");
        System.out.println(distance + " миль.");
    }
}
