package com.andersen.study.chap8.superbox;
// добавим поле стоимости доставки
class Shipment extends BoxWeight {
    double cost;

    // сконструировать клон объекта
    Shipment(Shipment ob) {
        super(ob);
        cost = ob.cost;
    }

    // конструктор, применяемый при указании всех параметрах
    Shipment(double w, double h, double d, double m, double c) {
        super(w, h, d, m);
        cost = c;
    }

    // конструктор, применяемый по умолчанию
    Shipment() {
        super();
        cost = -1;
    }

    // конструктор, применяемый при кубе
    Shipment(double len, double m, double c) {
        super(len, m);
        cost = c;
    }
}
