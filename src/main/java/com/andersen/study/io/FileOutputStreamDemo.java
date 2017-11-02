package com.andersen.study.io;

import java.io.FileOutputStream;
import java.io.IOException;

class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = "Now is the time foa all good men\n" +
                " to come to the aid of their country\n" +
                " and pay their due taxes.";
        byte buf[] = source.getBytes();

        try (FileOutputStream f0 = new FileOutputStream("/home/vyacheslav/file1.txt");
             FileOutputStream f1 = new FileOutputStream("/home/vyacheslav/file2.txt");
             FileOutputStream f2 = new FileOutputStream("/home/vyacheslav/file3.txt"))
        {
            // записать данные в первый файл
            for (int i = 0; i < buf.length; i += 2)
                f0.write(buf[i]);

            // записать данные во второй файл
            f1.write(buf);

            // записать данные в третий файл
            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch (IOException e) {
            System.err.println("Произошла ошибка ввода-вывода: " + e);
        }
    }
}
