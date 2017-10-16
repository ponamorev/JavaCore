package com.andersen.study.chap6;
// В классе определяется целочисленный стек, в котором
// можно хранить до 10 целочисленных значений
class Stack {
    int stck[] = new int[10];
    int tos;

    // инициализировать вершину стека
    Stack() {
        tos = -1;
    }

    // разместить элемент в стеке
    void push(int item) {
        if (tos == 9)
            System.out.println("Стек заполнен.");
        else stck[++tos] = item;
    }

    // извлечь элемент из стека
    int pop() {
        if (tos == -1) {
            System.out.println("Стек пуст.");
            return 0;
        }
        else return stck[tos--];
    }
}
