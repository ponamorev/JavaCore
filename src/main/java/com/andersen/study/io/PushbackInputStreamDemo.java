package com.andersen.study.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

class PushbackInputStreamDemo {
    public static void main(String[] args) {
        String s = "if (a == 4) a = 0;\n";
        byte[] buf = s.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(buf);

        int c;
        try (PushbackInputStream pushback = new PushbackInputStream(inputStream)) {
            while ((c = pushback.read()) != -1) {
                switch (c) {
                    case '=':
                        if ((c = pushback.read()) == '=')
                            System.out.print(".eq.");
                        else {
                            System.out.print("<-");
                            pushback.unread(c);
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
