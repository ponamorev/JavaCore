package com.andersen.study.chap11;
// Применение метода join() для ожидания завершения потоков наследования
class NewThreadFour implements Runnable {
    String name;
    Thread t;

    NewThreadFour(String nameThread) {
        name = nameThread;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    // Точка входа в поток исполнения
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("Поток " + name + " прерван!");
        }

        System.out.println("Поток " + name + " завершён!");
    }
}

public class DemoJoin {
    public static void main(String[] args) {
        NewThreadFour ob1 = new NewThreadFour("Один");
        NewThreadFour ob2 = new NewThreadFour("Два");
        NewThreadFour ob3 = new NewThreadFour("Три");

        System.out.println("Поток Один запущен: " + ob1.t.isAlive());
        System.out.println("Поток Два запущен: " + ob2.t.isAlive());
        System.out.println("Поток Три запущен: " + ob3.t.isAlive());

        // ожидание завершения потоков
        try {
            System.out.println("Ожидание завершения потоков.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.err.println("Главный поток прерван!");
        }

        System.out.println("Поток Один запущен: " + ob1.t.isAlive());
        System.out.println("Поток Два запущен: " + ob2.t.isAlive());
        System.out.println("Поток Три запущен: " + ob3.t.isAlive());

        System.out.println("Главный поток завершён!");
    }
}
