package com.andersen.study.streamAPI;

import java.util.ArrayList;
import java.util.stream.Stream;

// Применение метода map() для создания нового потока данных,
// содержащего только избранные элементы из исходного потока
class NamePhoneEmail {
    String name;
    String phonenum;
    String email;

    NamePhoneEmail(String n, String p, String e) {
        name = n;
        phonenum = p;
        email = e;
    }
}

class NamePhone {
    String name;
    String phonenum;

    NamePhone(String n, String p) {
        name = n;
        phonenum = p;
    }
}

class StreamDemo5 {
    public static void main(String[] args) {
        // Создание списка имён, номеров телефонов и адресов электорнной почты
        ArrayList<NamePhoneEmail> list = new ArrayList<>();
        list.add(new NamePhoneEmail("Ларри", "555-5555",
                "Larry@HerbSchildt.com"));
        list.add(new NamePhoneEmail("Джеймс", "555-4444",
                "James@HerbSchildt.com"));
        list.add(new NamePhoneEmail("Мэри", "555-3333",
                "Mary@HerbSchildt.com"));

        System.out.println("Исходные элементы из списка list: ");
        list.stream().forEach((a) -> System.out.println(a.name + " " +
                a.phonenum + " " + a.email));
        System.out.println();

        // Отображение нового потока данных
        // Только имена и номера телефонов
        Stream<NamePhone> nameAndPhone = list.stream().map((a) ->
                new NamePhone(a.name, a.phonenum));
        System.out.println("Список имён и номеров телефонов: ");
        nameAndPhone.forEach(a -> System.out.println(a.name + " " +
                a.phonenum));
    }
}
