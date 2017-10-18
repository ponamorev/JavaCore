package com.andersen.study.chap9.p2;

class OtherPackage {
    OtherPackage() {
        com.andersen.study.chap9.p1.Protection p = new
                com.andersen.study.chap9.p1.Protection();
        System.out.println("Конструктор из другого пакета.");
        // операция ниже доступна только для суперкласса или пакета, в котором он находится
        // System.out.println("n = " + n);

        // операция ниже доступна только суперклассу
        // System.out.println("n_pri = " + n_pri);

        // операция ниже доступна либо суперклассу, либо подклассу, либо пакету
        // System.out.println("n_pro = " + n_pro);

        System.out.println("n_pub = " + p.n_pub);
    }
}
