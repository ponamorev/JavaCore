package com.andersen.study.chap7;
// Демонстрация применения аргументов переменной длины
class VarArgs {
    // теперь метода vaTest() объявляется с аргументом переменной длины
    static void vaTest(int ... v) {
        System.out.print("Количество аргументов: " + v.length + "\nСодержимое: ");
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // теперь vaTest() можно объявить без создания массивов
        vaTest(10);
        vaTest(1, 2, 3);
        vaTest();
    }
}
