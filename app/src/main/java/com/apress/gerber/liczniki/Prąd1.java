package com.apress.gerber.liczniki;

public class Prąd1 {

    private int bazaL = 29426;
    private int stanL = 29426;
    private double ab = (4.34 + 6.50 + 0.38 + 6.49 + 6) * 1.23;
    private double jcenaS = 0.2411;
    private double jcenaD = 0.1601;
    private int korekta = 0;

    public Prąd1( int stanL)
    {

        this.stanL = stanL;
    }

    public Prąd1(int korekta, int stanL)
    {
        this.korekta = korekta;
        this.stanL = stanL;
    }


    public double obliczLicznik(int stanL)
    {

        int zuycie = stanL - bazaL;
        double s11 = zuycie * jcenaS * 1.23;
        double s21 = zuycie * jcenaD * 1.23;
        double licznik1 = s11 + s21 + ab;
        int nlicznik1 = (int) Math.round(licznik1);
        return nlicznik1;
    }

    public double obliczZLicznik(int stanL)
    {
        int zuycie = stanL - bazaL;
        double s11 = zuycie * jcenaS * 1.23;
        double s21 = zuycie * jcenaD * 1.23;
        double zlicznik1 = s11 + s21;
        int nzlicznik1 = (int) Math.round(zlicznik1);
        return nzlicznik1;

    }

    public double obliczPrognoza(int stanL)
    {
        int zuycie = stanL - bazaL;
        double s11 = zuycie * jcenaS * 1.23;
        double s21 = zuycie * jcenaD * 1.23;
        Parametr par1 = new Parametr(korekta);
        double prognozaL1 = ((s11 + s21) * par1.obliczParametr()) + ab;
        int nprognozaL1 = (int) Math.round(prognozaL1);
        return nprognozaL1;
    }

    public String toString()
    {
        return "L1: zużycie " + obliczZLicznik(stanL)+  " zł. do zapłaty " + obliczLicznik(stanL)  + " zł. " + "rachunek "
                + obliczPrognoza(stanL)  + " zł.";
    }

}
