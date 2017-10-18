package com.andersen.study.chap9;

class MyIFImp2 implements MyIF {
    // Реализация обоих методов интерфейса
    public int getNumber() {
        return 100;
    }

    public String getString() {
        return "Это другая символьная строка.";
    }
}
