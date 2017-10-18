package com.andersen.study.chap9;

class TestIface2 {
    public static void main(String[] args) {
        Callback c = new Client();
        AnotherClient ob = new AnotherClient();

        c.callback(42);

        c = ob; // теперь переменная c типа Callback ссылается
                // на объект типа AnotherClient
        c.callback(42);
    }
}
