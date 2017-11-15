package com.andersen.study.chap11;
// Example of mutual blocking
class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " entered in method A.foo()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Class A interrupted.");
        }
        System.out.println(name + " tries to call method B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("In method A.last()");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered in method B.bar()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Class B interrupted.");
        }
        System.out.println(name + " tries to call method A.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("In method B.last()");
    }
}

public class Deadlock implements Runnable {
    private A a = new A();
    private  B b = new B();

    private Deadlock() {
        Thread.currentThread().setName("Main thread");
        Thread thread = new Thread(this, "Rival thread");
        thread.start();

        a.foo(b); // get blocking for an object a in this thread
        System.out.println("Back to main thread.");
    }

    public void run() {
        b.bar(a); // get blocking for an object b in other thread
        System.out.println("Back to other thread.");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}
