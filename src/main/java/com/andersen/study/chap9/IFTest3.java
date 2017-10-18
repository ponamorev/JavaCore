package com.andersen.study.chap9;
// Создать переменную интерфейса и
// обратиться к стекам через неё
class IFTest3 {
    public static void main(String[] args) {
        IntStack mystack; // создать переменную ссылки на интерфейс
        DynStack ds = new DynStack(5);
        FixedStack fs = new FixedStack(8);

        mystack = ds; // загрузить динамический стек
        // разместить числа в стеке
        for (int i = 0; i < 12; i++)
            mystack.push(i);

        mystack = fs; // загрузить фиксированный стек
        for (int i = 0; i < 8; i++)
            mystack.push(i);

        mystack = ds;
        System.out.println("Значения в динамеческом стеке:");
        for (int i = 0; i < 12; i++)
            System.out.print(mystack.pop() + " ");

        mystack = fs;
        System.out.println("\nЗначения в фиксированном стеке:");
        for (int i = 0; i < 8; i++)
            System.out.print(mystack.pop() + " ");
    }
}
