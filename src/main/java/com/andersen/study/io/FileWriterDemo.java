package com.andersen.study.io;

import java.io.FileWriter;
import java.io.IOException;

// демонстрация применения FileWriter
// для выполнения программы необходим JDK 7 и выше
class FileWriterDemo {
    public static void main(String[] args) {
        String source = "Now is the time foa all good men\n" +
                " to come to the aid of their country\n" +
                " and pay their due taxes.";
        char buffer[] = new char[source.length()];
        source.getChars(0, source.length(), buffer, 0);

        try (FileWriter writer = new FileWriter("/home/vyacheslav/file1.txt");
             FileWriter writer1 = new FileWriter("/home/vyacheslav/file2.txt");
             FileWriter writer2 = new FileWriter("/home/vyacheslav/file3.txt")) {
            // вывести символы в первый файл
            for (int i = 0; i < source.length(); i += 2)
                writer.write(buffer[i]);

            // вывести символы во второй файл
            writer1.write(buffer);

            // вывести символы в третий файл
            writer2.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
