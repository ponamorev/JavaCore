package com.andersen.study.chap7.stackfix;

import com.andersen.study.chap7.stackfix.Stack;

class TestStack {
    public static void main(String[] args) {
        Stack myst1 = new Stack();
        Stack myst2 = new Stack();

        // разместить значения в стеке
        for (int i = 0; i < 10; i++) myst1.push(i);
        for (int i = 10; i < 20; i++) myst2.push(i);

        // извлечь числа из стеков
        System.out.println("Стек в myst1: ");
        for (int i = 0; i < 10; i++)
            System.out.print(myst1.pop() + " ");

        System.out.println("\n\nСтек в myst2: ");
        for (int i = 0; i < 10; i++)
            System.out.print(myst2.pop() + " ");

            // эти операторы недопустимы
        // myst1.tos = -2;
        // myst2.stck[3] = 100;
    }
}
