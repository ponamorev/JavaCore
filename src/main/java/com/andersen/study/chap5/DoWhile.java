package com.andersen.study.chap5;
// Демонстрация применения оператора цикла do-while
class DoWhile {
    public static void main(String[] args) {
        int n = 10;
        do {
            System.out.println("такт " + n);
            // n--;
        } while (--n > 0);
    }
}
