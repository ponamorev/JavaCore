package com.andersen.study.collectionsAPI;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class AlgorithmsDemo {
    public static void main(String[] args) {
        // создать неинициализированный связный список
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(-8);
        ll.add(20);
        ll.add(-20);
        ll.add(8);

        // создать компаратор с обратный упорядочением
        Comparator<Integer> r = Collections.reverseOrder();

        // отсортировать список при помощи созданного компаратора
        Collections.sort(ll, r);

        System.out.println("Список отсортирован в обратном порядке: ");

        for (int i : ll)
            System.out.print(i + " ");

        System.out.println();

        // перетасовать список
        Collections.shuffle(ll);

        // вывести перетасованный список
        System.out.println("Список перетасован: ");

        for (int i : ll)
            System.out.print(i + " ");

        System.out.println();
        System.out.println("Минимум: " + Collections.min(ll));
        System.out.println("Максимум: " + Collections.max(ll));
    }
}
