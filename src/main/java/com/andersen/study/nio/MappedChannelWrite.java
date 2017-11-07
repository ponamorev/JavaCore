package com.andersen.study.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// Запись данных в сопоставляемый файл
// Требуется компонент JDK 7 и выше для выполнения программы
public class MappedChannelWrite {
    public static void main(String[] args) {
        // получение канала к файлу
        try (FileChannel fileChannel =
                     (FileChannel) Files.newByteChannel(
                             Paths.get("/home/vyacheslav/result.txt"),
                             StandardOpenOption.CREATE,
                             StandardOpenOption.WRITE,
                             StandardOpenOption.READ)) {
            // создание буфера
            MappedByteBuffer mBuf = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            // заполнение буфера данными
            for (int i = 0; i < 26; i++)
                mBuf.put((byte) ('A' + i));
        } catch (InvalidPathException e) {
            System.err.println("Ошибка указания пути файла: " + e);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
            System.exit(1);
        }
    }
}
