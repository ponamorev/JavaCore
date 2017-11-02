package com.andersen.study.chap13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* Копирование из одного текстового файла в другой
   Чтобы воспользоваться этой программой, укажите
   имена исходного и целевого файлов.
   Например, чтобы скопировать файл FIRST.TXT в SECOND.TXT,
   введите в командной строке следующую команду:

   java CopyFile FIRST.TXT SECOND.TXT

   В этой версии применяется try с ресурсами
   для автоматического закрытия файлов

   Примечание: для выполнения этого кода требуется версия JDK 7
*/
class CopyFile {
    public static void main(String[] args) {
        int i;

       // проверить, указаны ли имена файлов
        if (args.length != 2) {
            System.out.println("Используйте: java CopyFile откуда куда");
            return;
        }

        // копирование
        try (FileInputStream fileInputStream = new FileInputStream(args[0]);
                FileOutputStream fileOutputStream = new FileOutputStream(args[1])) {
            do {
                i = fileInputStream.read();
                if (i != -1) fileOutputStream.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
