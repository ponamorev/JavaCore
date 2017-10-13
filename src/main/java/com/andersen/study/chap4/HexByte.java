package com.andersen.study.chap4;
// Маскирование двоичных разрядов расширения знака
class HexByte {
    public static void main(String[] args) {
        char hex[] = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };

        byte b = (byte) 0xf1; // 1111_0001

        System.out.println("b = 0x" + hex[(b >> 4) & 0x0f] + hex[b & 0x0f]);
        // b >> 4 = 1111_1111
        // (b >> 4) & 0x0f = 1111_1111 & 0000_1111 = 0000_1111 = f
        // 1111_0001 & 0000_1111 = 0000_0001 = 1
    }
}
