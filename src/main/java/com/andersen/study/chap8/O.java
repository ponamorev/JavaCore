package com.andersen.study.chap8;

class O {
    final void meth() {
        System.out.println("Это завершённый метод.");
    }
}

class P extends O {
    /* void meth() { // Ошибка! Этот метод не может быть переопределён.
        System.out.println("Недопустимо!");
    } */
}
