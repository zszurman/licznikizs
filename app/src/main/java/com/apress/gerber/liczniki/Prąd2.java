package com.apress.gerber.liczniki;

public class Prąd2 {


    private int bazaL = 1685;
    private int stanL = 1685;
    private double jcenaS = 0.2411;
    private double jcenaD = 0.1601;
    private int korekta = 0;
    private double ab = (4.34 + 6.50 + 0.38) * 1.23 + 6.49 + 6;

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
        double s12 = zuycie * jcenaS;
        double s22 = zuycie * jcenaD;

        double licznik2 = (s12 + s22) * 1.23 + ab;
        int nlicznik2 = (int) licznik2;
        return nlicznik2;
    }

    public double obliczZLicznik(int stanL)
    {
        int zuycie = stanL - bazaL;
        double s12 = zuycie * jcenaS;
        double s22 = zuycie * jcenaD;

        double zlicznik2 = (s12 + s22) * 1.23;
        int nzlicznik2 = (int) zlicznik2;
        return nzlicznik2;
    }

    public double obliczPrognoza(int stanL)
    {
        int zuycie = stanL - bazaL;
        double s12 = zuycie * jcenaS;
        double s22 = zuycie * jcenaD;

        Parametr par2 = new Parametr(korekta);
        double prognozaL2 = ((((s12 + s22) * 1.23) + ab - 32.46) * par2.obliczParametr()) + 32.46;
        int nprognozaL2 = (int) prognozaL2;
        return nprognozaL2;
    }
    public String toString()
    {
        return "L2: do zapłaty " + obliczLicznik(stanL) + " zł. " + "Prognoza " + obliczPrognoza(stanL)
                + " zł.  Zużycie " + obliczZLicznik(stanL) + " zł.";
    }
}
