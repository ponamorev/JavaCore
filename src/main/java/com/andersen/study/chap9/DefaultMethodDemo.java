package com.andersen.study.chap9;
// Использовать метод по умолчанию
class DefaultMethodDemo {
    public static void main(String[] args) {
        MyIFImp obj = new MyIFImp();

        // Вызов явно реализованного метода getNumber()
        System.out.println(obj.getNumber());
        // Можно вызвать метод getString()
        System.out.println(obj.getString());
    }
}
