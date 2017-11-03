package com.andersen.study.io;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

// демонстрация применения метода unread()
// из класса PushbackReader
// для выполнения программы необходим JDK 7 и выше
public class PushbackReaderDemo {
    public static void main(String[] args) {
        String s = "if (a == 4) a = 0;\n";
        char buf[] = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        CharArrayReader reader = new CharArrayReader(buf);

        int c;

        try (PushbackReader pushbackReader =
                     new PushbackReader(reader)) {
            while ((c = pushbackReader.read()) != -1) {
                switch (c) {
                    case '=':
                        if ((c = pushbackReader.read()) == '=')
                            System.out.print(".eq.");
                        else {
                            System.out.print("<-");
                            pushbackReader.unread(c);
                        }
                        break;
                    default:
                        System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
