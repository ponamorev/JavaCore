package com.andersen.study.chap13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// использование класса BufferedReader для чтения символов с консоли
class BRRead {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите символы, 'q' для выхода.");
        // читать символы
        do {
            c = (char) bufferedReader.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
