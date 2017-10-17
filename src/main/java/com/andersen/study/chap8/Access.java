package com.andersen.study.chap8;
/* В иерархии классов закрытые члены остаются закрытыми
   в пределах своего класса

   Это программа содержит ошибку
   Ошибка закомментированна
 */
// суперкласс
class C {
    int i;
    private int j; // закрытый член класса

    void setij(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

// подкласс, переменная j недоступна
class D extends C {
    int total;

    void sum() {
        // total = i + j; // Ошибка! j недоступна.
    }
}

class Access {
    public static void main(String[] args) {
        D subOb = new D();

        subOb.setij(10, 12);

        subOb.sum();
        System.out.println("Сумма равна " + subOb.total);
    }
}
