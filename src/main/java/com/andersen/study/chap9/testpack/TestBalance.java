package com.andersen.study.chap9.testpack;

import com.andersen.study.chap9.MyPack.*;

public class TestBalance {
    public static void main(String[] args) {
        // Класс Balance объявлен как public, поэтому мы
        // можем им воспользоваться и вызвать конструктор
        Balance test = new Balance("J. J. Jaspers", 99.88);

        test.show();
    }
}
