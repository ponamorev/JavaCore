package com.andersen.study.chap13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// чтение символьных строк с консоли средствами класса BufferedReader
class BRReadLine {
    public static void main(String[] args) throws IOException{
        // создать поток вывода типа BufferedReader,
        // используя стандартный поток ввода System.in
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Введите строки текста.");
        System.out.println("Введите 'стоп' для завершения.");
        do {
            str = bufferedReader.readLine();
            System.out.println(str);
        } while (!str.equals("стоп"));
    }
}
