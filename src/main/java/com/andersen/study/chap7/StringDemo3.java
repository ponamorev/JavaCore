package com.andersen.study.chap7;
// Демонстрация применения массива символьных строк
class StringDemo3 {
    public static void main(String[] args) {
        String str[] = { "один", "два", "три" };

        for (int i = 0; i < str.length; i++)
            System.out.println("str[" + i + "]: " + str[i]);
    }
}
