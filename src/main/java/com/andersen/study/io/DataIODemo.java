package com.andersen.study.io;

import java.io.*;

class DataIODemo {
    public static void main(String[] args) {
        String dir = "/home/vyacheslav/reesult.txt";
        // сначала вывести данные в файл
        try (DataOutputStream outputStream =
                     new DataOutputStream(new FileOutputStream(dir))) {
            outputStream.writeDouble(98.6);
            outputStream.writeInt(1000);
            outputStream.writeBoolean(true);
        } catch (FileNotFoundException e) {
            System.err.println("Нельзя открыть файл ввода: " + e);
            return;
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }

        // теперь выведем данные из файла
        try (DataInputStream inputStream =
                     new DataInputStream(new FileInputStream(dir))) {
            double d = inputStream.readDouble();
            int i = inputStream.readInt();
            boolean bool = inputStream.readBoolean();

            System.out.println("Получаемые значение: " + d + " " + i + " " + bool);
        } catch (FileNotFoundException e) {
            System.err.println("Нельзя открыть файл: " + e);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
    }
}
