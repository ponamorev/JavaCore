package com.andersen.study.chap4;
// Демонстрация применения логических операций
class BoolLogic {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = a | b; // true
        boolean d = a & b; // false
        boolean e = a ^ b; // true
        boolean f = (!a & b) | (a & !b); // true
        boolean g = !a; // false

        System.out.println("        a = " + a);
        System.out.println("        b = " + b);
        System.out.println("      a|b = " + c);
        System.out.println("      a&b = " + d);
        System.out.println("      a^b = " + e);
        System.out.println("!a&b|a&!b = " + f);
        System.out.println("       !a = " + g);
    }
}
