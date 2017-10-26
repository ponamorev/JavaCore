package com.andersen.study.collectionsAPI;
/* Простая база телефонных номеров,
   построенная на основе списков свойств.*/
import java.io.*;
import java.util.Properties;

class PhoneBook {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        FileInputStream fileInputStream = null;
        boolean changed = false;

        // попытаться открыть файл phonebook.dat
        try {
            fileInputStream =
                    new FileInputStream("/home/vyacheslav/Рабочий стол/phonebook.dat");
        } catch (FileNotFoundException e) { /* игонрировать */ }

        /* Если телефонная книга уже существует, загрузить
           существующие телефонные номера. */
        try {
            if (fileInputStream != null) {
                properties.load(fileInputStream);
                fileInputStream.close();
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла.");
        }

        // разрешить пользователю вводить новые имена и
        // номера телефонов абонентов
        do {
            System.out.println("Введите имя ('выход' для завершения): ");
            name = bufferedReader.readLine();
            if (name.equals("выход")) continue;
            System.out.println("Введите номер: ");
            number = bufferedReader.readLine();
            properties.put(name, number);
            changed = true;
        } while (!name.equals("выход"));
        // сохранить телефонную книгу, если она изменилась
        if (changed) {
            FileOutputStream fileOutputStream =
                    new FileOutputStream("/home/vyacheslav/Рабочий стол/phonebook.dat");
            properties.store(fileOutputStream, "Телефонная книга");
            fileOutputStream.close();
        }

        // искать номер по имени абонента
        do {
            System.out.println("Введите имя для поиска" +
                    "('выход' для завершения)");
            name = bufferedReader.readLine();
            if (name.equals("выход")) continue;
            number = (String) properties.get(name);
            System.out.println(number);
        } while (!name.equals("выход"));
    }
}
