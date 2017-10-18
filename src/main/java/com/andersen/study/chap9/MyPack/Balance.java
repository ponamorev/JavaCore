package com.andersen.study.chap9.MyPack;

public class Balance {
    String name;
    double bal;

    public Balance(String n, double b) {
        name = n;
        bal = b;
    }

    public void show() {
        if (bal < 0)
            System.out.println("--> ");
        System.out.println(name + ": $" + bal);
    }
}
