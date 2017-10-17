package com.andersen.study.chap7;
// Использовать массив для передачи методу переменного
// количества аргументов. Это старый подход к обработке
// аргументов переменной длины
class PassArray {
    static void vaTest(int v[]) {
        System.out.print("Количество аргументов: " + v.length + "\nСодержимое: ");
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int n1[] = { 10 };
        int n2[] = { 1, 2, 3 };
        int n3[] = { };

        vaTest(n1); // 1 арг
        vaTest(n2); // 3 арг
        vaTest(n3); // без арг
    }
}
