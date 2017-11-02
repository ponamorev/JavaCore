package com.andersen.study.io;

import java.io.File;
import java.io.FilenameFilter;

// посмотреть каталог java файлов
class DirListOnly {
    public static void main(String[] args) {
        String dirname = "/home/vyacheslav//IdeaProjects/JavaCore" +
                "/src/main/java/com/andersen/study/io";
        File file = new File(dirname);
        FilenameFilter filter = new OnlyExt("java");
        String s[] = file.list(filter);

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
