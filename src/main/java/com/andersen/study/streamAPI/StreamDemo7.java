package com.andersen.study.streamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Использование метода collect() для создания списка List
// и множества Set из потока данных
class NamePhoneEmails {
    String name;
    String phonenum;
    String email;

    NamePhoneEmails(String n, String p, String e) {
        name = n;
        phonenum = p;
        email = e;
    }
}

class NamePhones {
    String name;
    String phonenum;

    NamePhones(String n, String p) {
        name = n;
        phonenum = p;
    }
}

class StreamDemo7 {
    public static void main(String[] args) {
        // Создание списка имён, номеров телефонов и адресов электорнной почты
        ArrayList<NamePhoneEmails> list = new ArrayList<>();
        list.add(new NamePhoneEmails("Ларри", "555-5555",
                "Larry@HerbSchildt.com"));
        list.add(new NamePhoneEmails("Джеймс", "555-4444",
                "James@HerbSchildt.com"));
        list.add(new NamePhoneEmails("Мэри", "555-3333",
                "Mary@HerbSchildt.com"));

        // Отображение только имён и номеров телефонов на новый поток данных
        Stream<NamePhones> stream = list.stream().map(a ->
                new NamePhones(a.name, a.phonenum));

        // Вызов метода collect(), чтобы составить список типа List
        // из имён и номеров телефонов
        List<NamePhones> npList = stream.collect(Collectors.toList());

        System.out.println("Имена и номера телефонов в списке типа List: ");
        for (NamePhones e : npList)
            System.out.println(e.name + ": " + e.phonenum);

        // Получение другого отображения имён и номеров телефонов
        stream = list.stream().map(a -> new NamePhones(a.name, a.phonenum));

        // Создание множества типа Set путём вызова метода collect()
        Set<NamePhones> npSet = stream.collect(Collectors.toSet());

        System.out.println("\nИмена и номера телефонов в множестве типа Set: ");
        for (NamePhones e : npSet)
            System.out.println(e.name + ": " + e.phonenum);

        stream = list.stream().map(a -> new NamePhones(a.name, a.phonenum));
        LinkedList<NamePhones> linkedList = stream.collect(LinkedList::new,
                LinkedList::add, LinkedList::addAll);
        System.out.println("\nПредставление потока в виде связанного списка:");
        for (NamePhones e : linkedList)
            System.out.println("[" + e.name + ": " + e.phonenum + "]");

        /*stream = list.stream().map(a -> new NamePhones(a.name, a.phonenum));
        HashSet<NamePhones> hashSet = stream.collect(HashSet::new, HashSet::add,
                HashSet::addAll);
        System.out.println("\nПредставление потока в виде хэшированного множества:");
        for (NamePhones e : hashSet)
            System.out.println("[" + e.name + ": " + e.phonenum + "]");*/
    }
}
