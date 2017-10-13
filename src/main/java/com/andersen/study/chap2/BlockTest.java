package com.andersen.study.chap2;
// Тестирование применений блоков кода
class BlockTest {
    public static void main(String[] args) {
        int x, y;

        y = 20;

        // адресатом этого оператора цикла служит блок кода
        // заключенный в фигурные скобки
        for (x = 0; x < 10; x++) {
            System.out.println("Значение х равно " + x);
            System.out.println("Значение у равно " + y);
            y = y - 2;
        }
    }
}
