package com.andersen.study.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumeration implements Enumeration<FileInputStream> {
    private Enumeration<String> files;

    public InputStreamEnumeration(Vector<String> files) {
        this.files = files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
            return null;
        }
    }
}

class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>();

        files.add("/home/vyacheslav/file1.txt");
        files.add("/home/vyacheslav/file2.txt");
        files.add("/home/vyacheslav/file3.txt");
        InputStreamEnumeration inputStreamEnumeration = new InputStreamEnumeration(files);

        try (InputStream inputStream = new SequenceInputStream(inputStreamEnumeration)) {
            while ((c = inputStream.read()) != -1)
                System.out.print((char) c);
        } catch (NullPointerException e) {
            System.err.println("Ошибка открытия файла: " + e);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
