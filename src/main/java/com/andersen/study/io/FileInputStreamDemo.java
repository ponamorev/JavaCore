package com.andersen.study.io;

import java.io.FileInputStream;
import java.io.IOException;

class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;

        try (FileInputStream file =
                     new FileInputStream("/home/vyacheslav/result.txt")) {
            System.out.println("Общее количество доступных байтов: " +
                    (size = file.available()));
            int n = size / 10;
            System.out.println("Первые " + n + " байтов, " +
                    "прочитанных из файла по очереди методом read()");
            for (int i = 0; i < n; i++)
                System.out.println((char) file.read());

            System.out.println("\nВсё ещё доступно: " + file.available());

            System.out.println("\nЧтение следующих " + n + " байтов по очереди " +
                    "методом read(b[])");
            byte b[] = new byte[n];
            if (file.read(b) != n)
                System.err.println("Нельзя прочитать " + n + " байтов.");

            System.out.println(new String(b, 0, n));
            System.out.println("\nВсё ещё доступно: " + file.available());

            System.out.println("\nПропустить половину оставшихся байтов методом skip()");
            file.skip(size / 2);
            System.out.println("\nВсё ещё доступно: " + file.available());

            System.out.println("\nЧтение " + n / 2 + " байтов, размещаемых в конце массива.");
            if (file.read(b, n / 2, n / 2) != n / 2)
                System.err.println("Нельзя прочитать " + n / 2 + " байтов.");
            System.out.println(new String(b, 0, b.length));
            System.out.println("\nВсё ещё доступно: " + file.available());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
