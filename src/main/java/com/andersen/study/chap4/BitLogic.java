package com.andersen.study.chap4;
// Демонстрация применения поразрядных логических операций
class BitLogic {
    public static void main(String[] args) {
        String[] binary = {
                "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"
        };
        int a = 3; // 0 + 2 + 1, или 0011 в двоичном представлении
        int b = 6; // 4 + 2 + 0, или 0110 в двоичном представлении
        int c = a | b; // 0111 = 7
        int d = a & b; // 0010 = 2
        int e = a ^ b; // 0101 = 5
        int f = (~a & b) | (a & ~b); // 0100 | 0001 = 0101 = 5
        int g = ~a & 0x0f; // 0x0f = 0000_1111 -> g = ~a = 1100 = 12
        System.out.println("a = " + binary[a]);
        System.out.println("b = " + binary[b]);
        System.out.println("c = " + binary[c]);
        System.out.println("d = " + binary[d]);
        System.out.println("e = " + binary[e]);
        System.out.println("f = " + binary[f]);
        System.out.println("g = " + binary[g]);
    }
}
