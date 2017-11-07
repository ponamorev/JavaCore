package com.andersen.study.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

// Использование канала ввода-вывода для чтения файла
// Требуется комплект JDK 7 и выше для выполнения данной программы
class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;

        // получение канала к этому файлу
        try (SeekableByteChannel fChan =
                     Files.newByteChannel(Paths.get("/home/vyacheslav/test.txt"))) {
            // выделение памяти под буфер
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do {
                // запись байтов в буфер
                count = fChan.read(mBuf);

                // прекращение чтения при достижении конца файла
                if (count != -1) {
                    // подготовить буфер для чтения
                    mBuf.rewind();

                    // чтение байтов из буфера и вывод на экран
                    // в символьном формате
                    for (int i = 0; i < count; i++)
                        System.out.print((char) mBuf.get());
                }
            } while (count != -1);

            System.out.println();
        } catch (InvalidPathException e) {
            System.err.println("Path error: " + e);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
