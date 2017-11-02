package com.andersen.study.io;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class ByteArrayOutputStreamDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String s = "Эти данные должны быть внесены в массив.";
        byte[] buf = s.getBytes();

        try {
            output.write(buf);
        } catch (IOException e) {
            System.err.println("Ошибка записи в буффер: " + e);
            return;
        }

        System.out.println("Буфер в виде символьной строки:");
        System.out.println(output.toString());
        System.out.println("В массив:");
        byte[] b = output.toByteArray();
        for (byte aB : b) System.out.print((char) aB);

        System.out.println("\nВ поток вывода OutputStream()");

        try (FileOutputStream file =
                     new FileOutputStream("/home/vyacheslav/test.txt")) {
            output.writeTo(file);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
            return;
        }

        System.out.println("Установка в исходное состояние.");
        output.reset();

        for (int i = 0; i < 3; i++) output.write('X');
        System.out.println(output.toString());
    }
}
