package com.andersen.study.chap3;
// Символьные переменные ведут себя как целочисленные
class CharDemo2 {
    public static void main(String[] args) {
        char ch1;

        ch1 = 'X';
        System.out.println("ch1 содержит " + ch1);
        ch1++; // увеличение на единицу переменной ch1
        System.out.println("ch1 теперь содержит " + ch1);
    }
}
