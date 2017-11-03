package com.andersen.study.io;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;

// использование буферизированного ввода
// необходимо иметь JDK 7 и выше
class BufferedReaderDemo {
    public static void main(String[] args) {
        String s = " Это знак авторского права &copy; " +
                ", а &copy - нет.";
        char buf[] = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);

        CharArrayReader reader = new CharArrayReader(buf);
        int c;
        boolean marked = false;

        try (BufferedReader bufferedReader =
                     new BufferedReader(reader)) {
            while ((c = bufferedReader.read()) != -1) {
                switch (c) {
                    case '&':
                        if (!marked) {
                            bufferedReader.mark(32);
                            marked = true;
                        } else marked = false;
                        break;
                    case ';':
                        if (marked) {
                            marked = false;
                            System.out.print("(c)");
                        } else System.out.print((char) c);
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            bufferedReader.reset();
                            System.out.print("&");
                        } else System.out.print((char) c);
                        break;
                    default:
                        if (!marked)
                            System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
