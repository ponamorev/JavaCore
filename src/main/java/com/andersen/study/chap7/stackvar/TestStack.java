package com.andersen.study.chap7.stackvar;

class TestStack {
    public static void main(String[] args) {
        Stack myst1 = new Stack(5);
        Stack myst2 = new Stack(8);

        // разместить значения в стеке
        for (int i = 0; i < 5; i++) myst1.push(i);
        for (int i = 0; i < 8; i++) myst2.push(i);

        // извлечь числа из стеков
        System.out.println("Стек в myst1: ");
        for (int i = 0; i < 5; i++)
            System.out.print(myst1.pop() + " ");

        System.out.println("\n\nСтек в myst2: ");
        for (int i = 0; i < 8; i++)
            System.out.print(myst2.pop() + " ");
    }
}
