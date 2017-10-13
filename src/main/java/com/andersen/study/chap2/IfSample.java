package com.andersen.study.chap2;

class IfSample {
    public static void main(String[] args) {
        int x, y;

        x = 10;
        y = 20;

        if (x < y) System.out.println("x меньше y");

        x = x * 2;
        if (x == y) System.out.println("х равно у");

        x = x * 2;
        if (x > y) System.out.println("х больше у");

        // Этот оператор не будет выполняться, потому что условие false
        if (x == y) System.out.println("вы не увидите этого");
    }
}
