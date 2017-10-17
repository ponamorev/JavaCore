package com.andersen.study.chap7.stackfix;
// В классе определяется целочисленный стек, в котором
// можно хранить до 10 целочисленных значений
class Stack {
    /* Теперь stck и tos закрытые. Это позволит их защитить от
       преднамеренного или случайного изменения, которое может
       нарушить стек.
     */
    private int stck[] = new int[10];
    private int tos;

    // инициализировать вершину стека
    Stack() {
        tos = -1;
    }

    void push(int item) {
        if (tos == 9) System.out.println("Стек переполнен.");
        else stck[++tos] = item;
    }

    int pop() {
        if (tos < 0) {
            System.out.println("Стек не заполнен.");
            return 0;
        }
        else {
            return stck[tos--];
        }
    }
}
