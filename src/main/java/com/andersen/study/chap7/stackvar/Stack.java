package com.andersen.study.chap7.stackvar;
// Усовершенствованный класс Stack, в котором используется член длины массива
class Stack {
    private int stck[];
    private int tos;

    // выделяется память под стек и инициализация стека
    Stack(int size) {
        stck = new int[size];
        tos = -1;
    }

    // поместить элемент в стек
    void push(int item) {
        if (tos == stck.length - 1) System.out.println("Стек переполнен.");
        else stck[++tos] = item;
    }

    int pop() {
        if (tos < 0) {
            System.out.println("Стек не заполнен.");
            return 0;
        } else return stck[tos--];
    }
}
