package com.apress.gerber.liczniki;

public class Woda {

    private int bazaL = 293;
    private int stanL = 293;
    private int korekta = 0;
    private double jcenaW = 5.19;
    private double jcenaK = 6.71;
    private double ab = 12.20;

    public Woda(int stanL)
    {

        this.stanL = stanL;
    }

    public Woda(int korekta, int stanL)
    {
        this.korekta = korekta;
        this.stanL = stanL;
    }

    public double obliczLicznik(int stanL)
    {
        int zuycie = stanL - bazaL;
        double woda = (zuycie * jcenaW) + (zuycie * jcenaW * 0.08);
        double kanal = (zuycie * jcenaK) + (zuycie * jcenaK * 0.08);
        double wk = woda + kanal + ab;
        int nwk = (int) wk;
        return nwk;

    }

    public double obliczZLicznik(int stanL)
    {
        int zuycie = stanL - bazaL;
        double woda = (zuycie * jcenaW) + (zuycie * jcenaW * 0.08);
        double kanal = (zuycie * jcenaK) + (zuycie * jcenaK * 0.08);
        double zwk = woda + kanal;
        int nzwk = (int) zwk;
        return nzwk;

    }

    public double obliczPrognoza(int stanL)
    {
        int zuycie = stanL - bazaL;
        double woda = (zuycie * jcenaW) + (zuycie * jcenaW * 0.08);
        double kanal = (zuycie * jcenaK) + (zuycie * jcenaK * 0.08);
        Parametr par = new Parametr(korekta);
        double prognozaW = ((woda + kanal) * par.obliczParametr()) + ab;
        int nprognozaW = (int) prognozaW;
        return nprognozaW;
    }

    public String toString()
    {
        return "W: do zapłaty " + obliczLicznik(stanL)  + " zł. " + "Prognoza " + obliczPrognoza(stanL)
                + " zł.  zużycie: " + obliczZLicznik(stanL) + " zł.   ";
    }

}
