package com.andersen.study.chap3;
// Демонстрация срока действия переменной
class LifeTime {
    public static void main(String[] args) {
        int x;

        for (x = 0; x < 3; x++) {
            int y = -1; // переменная у инициализируется
                        // при каждом входе в блок кода
            System.out.println("y равен " + y); // здесь всегда выводится
                                                // значение у = -1
            y = 100;
            System.out.println("у теперь равно " + y);
        }
    }
}
