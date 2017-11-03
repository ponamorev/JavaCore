package com.andersen.study.io;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

// демонстрация применения класса CharArrayWriter
// для выполнения программы необходимо иметь JDK 7 и выше
class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter writer = new CharArrayWriter();
        String str = "Это строка должны быть помещена в массив.";
        char buf[] = new char[str.length()];
        str.getChars(0, str.length(), buf, 0);

        try {
            writer.write(buf);
        } catch (IOException e) {
            System.err.println("Ошибка при заполнении буфера.");
            return;
        }

        System.out.println("Буфер в виде символьной строки:");
        System.out.println(writer.toString());
        System.out.println("В массив:");

        char c[] = writer.toCharArray();
        for (char i : c)
            System.out.print(i);

        System.out.println("\nВ поток вывода типа FileWriter:");
        try (FileWriter fileWriter =
                     new FileWriter("/home/vyacheslav/result.txt")) {
            writer.writeTo(fileWriter);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }

        System.out.println("Установка в исходное состояние.");
        writer.reset();

        for (int i = 0; i < 3; i++) writer.write('X');
        System.out.println(writer.toString());
    }
}
