package com.andersen.study.chap13;

import java.io.PrintWriter;

// демонстрация применения класса PrintWriter
class PrintWriterDemo {
    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter(System.out, true);

        printWriter.println("Это строка.");
        int i = -7;
        printWriter.println(i);
        double d = 4.5e-7;
        printWriter.println(d);
    }
}
