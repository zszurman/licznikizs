package com.apress.gerber.liczniki;

public class Prąd1 {

    private int bazaL = 29019;
    private int stanL = 29019;
    private double ab = (4.34 + 6.50 + 0.38) * 1.23 + 6.49 + 6;
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
        double s11 = zuycie * jcenaS;
        double s21 = zuycie * jcenaD * 1.23;
        double licznik1 = s11 + s21 + ab;
        int nlicznik1 = (int) licznik1;
        return nlicznik1;
    }

    public double obliczZLicznik(int stanL)
    {
        int zuycie = stanL - bazaL;
        double s11 = zuycie * jcenaS;
        double s21 = zuycie * jcenaD * 1.23;
        double zlicznik1 = s11 + s21;
        int nzlicznik1 = (int) zlicznik1;
        return nzlicznik1;

    }

    public double obliczPrognoza(int stanL)
    {
        int zuycie = stanL - bazaL;
        double s11 = zuycie * jcenaS;
        double s21 = zuycie * jcenaD * 1.23;
        Parametr par1 = new Parametr(korekta);
        double prognozaL1 = ((s11 + s21 + ab - 29.35) * par1.obliczParametr()) + 29.35;
        int nprognozaL1 = (int) prognozaL1;
        return nprognozaL1;
    }

    public String toString()
    {
        return "L1: do zapłaty " + obliczLicznik(stanL) + " zł. " + "Prognoza " + obliczPrognoza(stanL)
                + " zł.  Zużycie " + obliczZLicznik(stanL) + " zł.";
    }

}
