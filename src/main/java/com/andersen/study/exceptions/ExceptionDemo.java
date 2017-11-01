package com.andersen.study.exceptions;
// в этой программе создается специальный тип исключений
class MyEception extends Exception {
    private int detail;

    MyEception(int a) {
        detail = a;
    }

    @Override
    public String toString() {
        return "MyException[" + detail + "]";
    }
}

class ExceptionDemo {
    static void compute(int a) throws MyEception {
        System.out.println("Вызван метод compute(" + a + ").");
        if (a > 10)
            throw new MyEception(a);
        System.out.println("Нормальное завершение.");
    }

    public static void main(String[] args) {
        try {
            compute(1);
            compute(20);
        } catch (MyEception e) {
            System.out.println("Перехвачено исключение: " + e);
        }
    }
}
