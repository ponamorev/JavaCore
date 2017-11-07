package com.andersen.study.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// Вывод содержимого каталога
// Требуется компонент JDK 7 и выше для выполнения этой программы
class DirList {
    public static void main(String[] args) {
        String dirName = "/home/vyacheslav/Документы";

        // получение и обработка потока ввода каталога
        try (DirectoryStream<Path> dirStream =
                     Files.newDirectoryStream(Paths.get(dirName))) {

            System.out.println("Каталог " + dirName);

            // использование цикла for в стиле for each
            // для вывода содержимого каталога
            // (DirectoryStream реализует Interable)
            for (Path entry : dirStream) {
                BasicFileAttributes attributes =
                        Files.readAttributes(entry, BasicFileAttributes.class);

                if (attributes.isDirectory())
                    System.out.print("<DIR>  ");
                else System.out.print("       ");

                System.out.println(entry.getName(3));
            }

            // фильтрация файлов в каталоге по маскам
            DirectoryStream<Path> filterStream =
                    Files.newDirectoryStream(Paths.get(dirName), "*.{odt,doc*}");
            System.out.println("\nДокументы для работы в LibreOffice Writer:");
            for (Path entry : filterStream)
                System.out.println("\t" + entry.getName(3));

            // второй способ фильтрации с возвращением значения true
            // выведем файлы, которые являются обычными файлами

            // создание фальтра типа DirectoryStream.Filter<Path>
            DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
                @Override
                public boolean accept(Path entry) throws IOException {
                    return Files.isRegularFile(entry);
                }
            };

            System.out.println("\n");
            // фильтрация в каталоге по созданному фильтру
            try (DirectoryStream<Path> simpleFiles =
                         Files.newDirectoryStream(Paths.get(dirName), how)) {
                System.out.println("Вывод всех файлов, являющихся простыми файлами." +
                        "\nКаталог: " + dirName);

                for (Path entry : simpleFiles)
                    System.out.println("\t" + entry.getName(3));
            }
        } catch (InvalidPathException e) {
            System.err.println("Ошибка при указании пути: " + e);
        } catch (NotDirectoryException e) {
            System.err.println(dirName + " не является каталогом.");
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
