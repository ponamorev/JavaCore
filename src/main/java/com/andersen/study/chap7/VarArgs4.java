package com.andersen.study.chap7;
// Аргументы переменной длины, перегрузка и неоднозначность
//
// Эта программа содержит ошибку
// Ошибочная строка закомментированна
class VarArgs4 {
    static void vaTest(int ... v) {
        System.out.print("vaTest(int ...)" + "\nКоличество аргументов: " +
                v.length + "\nСодержимое: ");
        for (int x : v)
            System.out.print(x + " ");
        System.out.println("\n");
    }

    static void vaTest(boolean ... v) {
        System.out.print("vaTest(boolean ...)" + "\nКоличество аргументов: " +
                v.length + "\nСодержимое: ");
        for (boolean x : v)
            System.out.print(x + " ");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        vaTest(1, 2, 3);
        vaTest(true, false, false);
        // vaTest(); // Это ошибка! Неоднозначность!
    }
}
