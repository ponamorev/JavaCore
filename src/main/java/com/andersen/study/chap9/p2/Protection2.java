package com.andersen.study.chap9.p2;

class Protection2 extends com.andersen.study.chap9.p1.Protection {
    Protection2() {
        System.out.println("Конструктор, унаследованный из другого пакета.");
        // операция ниже доступна только для суперкласса или пакета, в котором он находится
        // System.out.println("n = " + n);

        // операция ниже доступна только суперклассу
        // System.out.println("n_pri = " + n_pri);

        System.out.println("n_pro = " + n_pro);
        System.out.println("n_pub = " + n_pub);
    }
}
