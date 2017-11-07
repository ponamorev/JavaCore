package com.andersen.study.nio;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

// Демонстрация потокового вывода на основе системы NIO
// Требуется компонент JDK 7 и выше для выполнения этой программы
class NIOStreamWrite {
    public static void main(String[] args) {
        // открытие файла и получение потока, связанного с этим файлом
        try (OutputStream outputStream =
                     new BufferedOutputStream(Files.newOutputStream(
                             Paths.get("/home/vyacheslav/result.txt")))) {
            // вывод в поток заданное количество байтов
            for (int i = 0; i < 26; i++)
                outputStream.write((byte) ('A' + i));
        } catch (InvalidPathException e) {
            System.err.println("Ошибка указания пути файла: " + e);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
