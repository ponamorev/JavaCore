package com.andersen.study.nio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/* Отображение содержимого текстового файла
   Чтобы воспользоваться этой программой, укажите
   имя файла, который требуется посмотреть.
   Например, чтобы посмотреть текст файла TEST.TXT,
   введите в командной строке следующую команду:

   java ShowFile TEST.TXT

   Требуется компонент JDK 7 и выше для выполнения этой программы
*/
class ShowFile {
    public static void main(String[] args) {
        int i;

        // проверка на то, что файл был указан
        if (args.length != 1) {
            System.out.println("Используйте: ShowFile имя_файла");
            return;
        }

        // открыть файл и получить связанный с ним поток ввода
        try (InputStream inputStream =
                     Files.newInputStream(Paths.get(args[0]))) {
            do {
                i = inputStream.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (InvalidPathException e) {
            System.err.println("Ошибка указания пути файла: " + e);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
