package com.andersen.study.nio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

// Запись данных в файл средствами системы ввода-вывода NIO
// Требуется компонент JDK 7 и выше для выполнения программы
class ExplicitChannelWrite {
    public static void main(String[] args) {
        // получение канала к файлу
        try (FileChannel fileChannel =
                     (FileChannel) Files.newByteChannel(
                             Paths.get("/home/vyacheslav/result.txt"),
                             StandardOpenOption.WRITE,
                             StandardOpenOption.CREATE)) {
            // создание буфера
            ByteBuffer mBuf = ByteBuffer.allocate(26);

            // запись некоторого количества байтов в буфер
            for (int i = 0; i < 26; i++)
                mBuf.put((byte) ('A' + i));

            // подготовка буфера к записи
            mBuf.rewind();

            // запись данных из буфера в файл
            fileChannel.write(mBuf);
        } catch (InvalidPathException e) {
            System.err.println("Ошибка указания пути к файлу: " + e);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
            System.exit(1);
        }
    }
}
