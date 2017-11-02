package com.andersen.study.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class ByteArrayInputStreamDemo {
    public static void main(String[] args) throws IOException {
        String abt = "abcdefghijklmnopqrstuvwxyz";
        byte[] b = abt.getBytes();

        ByteArrayInputStream input1 = new ByteArrayInputStream(b);
        ByteArrayInputStream input2 = new ByteArrayInputStream(b, 0, 3);
    }
}
