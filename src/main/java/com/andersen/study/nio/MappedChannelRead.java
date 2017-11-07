package com.andersen.study.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

// Использование сопоставления для чтения данных из файла
// Требуется компонент JDK 7 и выше для выполнения данной программы
class MappedChannelRead {
    public static void main(String[] args) {
        // получение канала к файлу
        try (FileChannel fileChannel =
                     (FileChannel) Files.newByteChannel(
                             Paths.get("/home/vyacheslav/test.txt"))) {
            // получить размер файла
            long fSize = fileChannel.size();

            // сопоставление файла с буфером
            MappedByteBuffer mBuffer =
                    fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            // чтение байтов из буфера и вывод на экран
            for (int i = 0; i < fSize; i++)
                System.out.print((char) mBuffer.get());

            System.out.println();
        } catch (InvalidPathException e) {
            System.err.println("Ошибка указания пути файла: " + e);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
