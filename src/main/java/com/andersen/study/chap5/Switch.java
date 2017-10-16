package com.andersen.study.chap5;
// Усовершенствованная версия программы, в которой
// определяется принадлежность месяца к времени года
class Switch {
    public static void main(String[] args) {
        int month = 10;
        String season;
        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "зиме";
                break;
            case 3:
            case 4:
            case 5:
                season = "весне";
                break;
            case 6:
            case 7:
            case 8:
                season = "лету";
            case 9:
            case 10:
            case 11:
                season = "осени";
                break;
            default:
                season = "вымышленным месяцам";
        }
        System.out.println("Октябрь относится к " + season + ".");
    }
}
