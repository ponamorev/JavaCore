package com.andersen.study.chap4;

class OpBitEquals {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        a |= 4; // 0...0001 | 0...0100 = 0...0101 = 5
        b >>= 1; // 0...0010 >> 1 = 0...0001 = 1
        c <<= 1; // 0...0011 << 1 = 0...0110 = 6
        a ^= c; // 0...0101 ^ 0...0110 = 0...0011 = 3

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }
}
