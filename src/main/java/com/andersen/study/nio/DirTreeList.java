package com.andersen.study.nio;
// Простой пример применения метода walkFileTree()
// для вывода дерева каталогов.
// Требуется компонент JDK 7 и выше для выполнения этой программы.

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
// Создание специальной версии класса SimpleFileVisitor,
// в которой переопределяется метод visitFile()
class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        System.out.println(file);
        return FileVisitResult.CONTINUE;
    }
}

class DirTreeList {
    public static void main(String[] args) {
        String dirName = "/home/vyacheslav/Документы";

        System.out.println("Дерево каталогов, начиная с каталога: " + dirName + ":\n");
        try {
            Files.walkFileTree(Paths.get(dirName), new MyFileVisitor());
        } catch (IOException exc) {
            System.err.println("Ошибка ввода-вывода: " + exc);
        }
    }
}
