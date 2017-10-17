package com.andersen.study.chap8.demobox;

class RefDemo {
    public static void main(String[] args) {
        BoxWeight weightbox = new BoxWeight(3, 5, 7, 8.73);
        Box plainbox = new Box();
        double vol;

        vol = weightbox.volume();
        System.out.println("Объём weightbox равен " + vol);
        System.out.println("Вес weightbox равен " + weightbox.weight);
        System.out.println();

        // присвоить ссылке на объект BoxWeight ссылки на объект Box
        plainbox = weightbox;
        vol = plainbox.volume();
        System.out.println("Объём plainbox равен " + vol);

        /* Следующий оператор ошибочек, так как член plainbox
           не определяет член weight. Строка закомментированна. */
        // System.out.println("Вес plainbox равен " + plainbox.weight);
    }
}
