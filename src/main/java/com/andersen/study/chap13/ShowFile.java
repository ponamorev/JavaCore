package com.andersen.study.chap13;

import java.io.FileInputStream;
import java.io.IOException;

/* Отображение содержимого текстового файла
   Чтобы воспользоваться этой программой, укажите
   имя файла, который требуется посмотреть.
   Например, чтобы посмотреть текст файла TEST.TXT,
   введите в командной строке следующую команду:

   java ShowFile TEST.TXT

   В этой версии применяется try с ресурсами
   для автоматического закрытия файла

   Примечание: для выполнения этого кода требуется версия JDK 7
*/
class ShowFile {
    public static void main(String[] args) {
        int i;

        // проверка на то, что имя файла указано вообще
        if (args.length != 1) {
            System.out.println("Используйте: java ShowFile имя_файла");
            return;
        }

        // оператор try с ресурсами
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            do {
                i = fileInputStream.read();
                if (i != -1) System.out.println((char) i);
            } while (i != -1);
        } catch (IOException e) {
            System.err.println("Ошибка чтения из файла: " + e);
        }
    }
}
