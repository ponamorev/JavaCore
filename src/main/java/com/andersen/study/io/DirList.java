package com.andersen.study.io;

import java.io.File;

// использовать каталоги
class DirList {
    public static void main(String[] args) {
        String dirname = "/home/vyacheslav";
        File file = new File(dirname);
        if (file.isDirectory()) {
            System.out.println("Каталог: " + dirname);
            String[] s = file.list();

            for (int i = 0; i < s.length; i++) {
                File file1 = new File(dirname + "/" + s[i]);
                if (file1.isDirectory())
                    System.out.println(s[i] + " является каталогом");
                else System.out.println(s[i] + " является файлом");
            }
        } else System.out.println(dirname + " не является каталогом");
    }
}
