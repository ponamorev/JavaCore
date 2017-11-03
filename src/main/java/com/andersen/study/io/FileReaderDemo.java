package com.andersen.study.io;

import java.io.FileReader;
import java.io.IOException;

// демонстрация применения FileReader
// для выполнения программы необходимо JDK 7 и выше
class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader reader =
                     new FileReader("/home/vyacheslav/result.txt")) {
            int c;

            // прочитать и вывести содержимое файла
            while ((c = reader.read()) != -1)
                System.out.print((char) c);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
