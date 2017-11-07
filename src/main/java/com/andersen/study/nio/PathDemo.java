package com.andersen.study.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

// Получение сведений о пути к файлу и о самом файле
// Требуется компонент JDK 7 и выше для выполнения этой программы
class PathDemo {
    public static void main(String[] args) {
        Path filePath = Paths.get("src/main/java/" +
                "com/andersen/study/nio/example/test.txt");

        System.out.println("Имя файла: " + filePath.getName(1));
        System.out.println("Путь к файлу: " + filePath);
        System.out.println("Абсолютный путь к файлу: " + filePath.toAbsolutePath());
        System.out.println("Родительский каталог: " + filePath.getParent());
        if (Files.exists(filePath))
            System.out.println("Файл существует.");
        else System.out.println("Файл не существует.");

        try {
            if (Files.isHidden(filePath))
                System.out.println("Файл скрыт.");
            else System.out.println("Файл не скрыт.");
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }

        Files.isWritable(filePath);
        System.out.println("Файл доступен для записи.");

        Files.isReadable(filePath);
        System.out.println("Файл доступен для чтения.");

        try {
            BasicFileAttributes attributes =
                    Files.readAttributes(filePath, BasicFileAttributes.class);

            if (attributes.isDirectory())
                System.out.println("Это каталог.");
            else System.out.println("Это не каталог.");

            if (attributes.isRegularFile())
                System.out.println("Это обычный файл.");
            else System.out.println("Это не обычный файл.");

            if (attributes.isSymbolicLink())
                System.out.println("Это символичная ссылка.");
            else System.out.println("Это не символичная ссылка.");

            System.out.println("Время последней модификации файла: " +
                    attributes.lastModifiedTime());
            System.out.println("Размер файла: " + attributes.size() + " байтов.");
        } catch (IOException e) {
            System.err.println("Ошибка чтения атрибутов: " + e);
        }
    }
}
