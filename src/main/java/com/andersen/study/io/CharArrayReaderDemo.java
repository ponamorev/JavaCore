package com.andersen.study.io;

import java.io.CharArrayReader;
import java.io.IOException;

// демонстрация применения класса CharArrayReader
// для выполнения программы необходимо иметь JDK 7 и выше
class CharArrayReaderDemo {
    public static void main(String[] args) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        char c[] = new char[abc.length()];
        abc.getChars(0, abc.length(), c, 0);
        int i;

        // вывод всех символов алфивита
        try (CharArrayReader reader = new CharArrayReader(c)) {
            System.out.println("Full alphabet.");
            while ((i = reader.read()) != -1)
                System.out.print((char) i);
            System.out.println();
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }

        // вывод первых пяти символов
        try (CharArrayReader reader = new CharArrayReader(c, 0, 5)) {
            System.out.println("First five chars.");
            while ((i = reader.read()) != -1)
                System.out.print((char) i);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
