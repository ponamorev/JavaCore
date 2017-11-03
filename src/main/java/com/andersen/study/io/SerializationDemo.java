package com.andersen.study.io;

import java.io.*;

// демонстрация применения сериализации и десериализации
// в этой программе используется try с ресурсами, поэтому
// минимальная версия для выполнения программы - JDK 7
public class SerializationDemo {
    public static void main(String[] args) {
        // произвести сериализацию объектов
        try (ObjectOutputStream objOutput = new ObjectOutputStream(
                new FileOutputStream("/home/vyacheslav/test.txt"))) {
            MyClass obj1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("Object 1:\n" + obj1);
            objOutput.writeObject(obj1);
        } catch (IOException e) {
            System.err.println("Исключение при сериализации: " + e);
        }

        System.out.println();
        // произвести десериализацию объекта
        try (ObjectInputStream objInput = new ObjectInputStream(
                new FileInputStream("/home/vyacheslav/test.txt"))) {
            MyClass obj2;
            obj2 = (MyClass) objInput.readObject();
            System.out.println("Object 2:\n" + obj2);
        } catch (IOException e) {
            System.err.println("Исключение при десериализации: " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Класс не найден: " + e);
        }
    }
}

class MyClass implements Serializable {
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "s = " + s + "; i = " + i + "; d = " + d;
    }
}
