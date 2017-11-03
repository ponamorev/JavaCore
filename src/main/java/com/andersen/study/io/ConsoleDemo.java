package com.andersen.study.io;

import java.io.Console;

// демонстрация применения класса Console java.io
class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;

        // получить ссылку на консоль
        con = System.console();

        // выйти из программы, если консоль недоступна
        if (con == null) return;

        // прочитать строку и вывести её
        str = con.readLine("Введите строку: ");
        con.printf("Введённая вами строка: %s\n", str);
    }
}
