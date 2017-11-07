package com.andersen.study.nio;

import java.io.IOException;
import java.nio.file.*;

// Скопировать файл средствами системы ввода-вывода NIO
// Требуется компонент JDK 7 и выше для выполнения программы
class NIOCopy {
    public static void main(String[] args) {
        // проверка на ввод имён файлов
        if (args.length != 2) {
            System.out.println("Применение: откуда и куда копировать.");
            return;
        }

        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);

            // скопировать файл
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (InvalidPathException e) {
            System.err.println("Ошибка указания пути файла: " + e);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
