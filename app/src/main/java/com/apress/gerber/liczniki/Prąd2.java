package com.apress.gerber.liczniki;

public class Prąd2 {


    private int bazaL = 1977;
    private int stanL = 1977;
    private double jcenaS = 0.2411;
    private double jcenaD = 0.1601;
    private int korekta = 0;
    private double ab = (7 + 6.50 + 0.38 + 6.49 + 6) * 1.23;

    public Prąd2(int stanL)
    {

        this.stanL = stanL;
    }

    public Prąd2(int korekta, int stanL)
    {
        this.korekta = korekta;
        this.stanL = stanL;
    }

    public double obliczLicznik(int stanL)
    {
        int zuycie = stanL - bazaL;
        double s12 = zuycie * jcenaS * 1.23;
        double s22 = zuycie * jcenaD * 1.23;

        double licznik2 = s12 + s22 + ab;
        int nlicznik2 = (int) Math.round(licznik2);
        return nlicznik2;
    }

    public double obliczZLicznik(int stanL)
    {
        int zuycie = stanL - bazaL;
        double s12 = zuycie * jcenaS * 1.23;
        double s22 = zuycie * jcenaD * 1.23;

        double zlicznik2 = s12 + s22;
        int nzlicznik2 = (int) Math.round(zlicznik2);
        return nzlicznik2;
    }

    public double obliczPrognoza(int stanL)
    {
        int zuycie = stanL - bazaL;
        double s12 = zuycie * jcenaS * 1.23;
        double s22 = zuycie * jcenaD * 1.23;

        Parametr par2 = new Parametr(korekta);
        double prognozaL2 = ((s12 + s22) * par2.obliczParametr()) + ab;
        int nprognozaL2 = (int) Math.round(prognozaL2);
        return nprognozaL2;
    }
    public String toString()
    {
        return "L2: zużycie " + obliczZLicznik(stanL)+  " zł. do zapłaty " + obliczLicznik(stanL)  + " zł. " + "rachunek "
                + obliczPrognoza(stanL)  + " zł.";
    }
}
