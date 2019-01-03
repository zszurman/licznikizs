package com.apress.gerber.liczniki;

public class Woda {

    private int bazaL = 396;
    private int stanL = 396;
    private double jcenaW = 5.19;
    private double jcenaK = 6.71;
    private double ab = 12.20;

    public Woda(int stanL)
    {

        this.stanL = stanL;
    }


    public double obliczLicznik(int stanL)
    {
        int zuycie = stanL - bazaL;
        double woda = (zuycie * jcenaW) + (zuycie * jcenaW * 0.08);
        double kanal = (zuycie * jcenaK) + (zuycie * jcenaK * 0.08);
        double wk = woda + kanal + ab;
        int nwk = (int) Math.round(wk);
        return nwk;

    }

    public double obliczZLicznik(int stanL)
    {
        int zuycie = stanL - bazaL;
        double woda = (zuycie * jcenaW) + (zuycie * jcenaW * 0.08);
        double kanal = (zuycie * jcenaK) + (zuycie * jcenaK * 0.08);
        double zwk = woda + kanal;
        int nzwk = (int) Math.round(zwk);
        return nzwk;

    }

    public double obliczPrognoza(int stanL)
    {
        int zuycie = stanL - bazaL;
        double woda = (zuycie * jcenaW) + (zuycie * jcenaW * 0.08);
        double kanal = (zuycie * jcenaK) + (zuycie * jcenaK * 0.08);
        Parametr par = new Parametr();
        double prognozaW = ((woda + kanal) * par.obliczParametr()) + ab;
        int nprognozaW = (int) Math.round(prognozaW);
        return nprognozaW;
    }

    public String toString()
    {
        return "W: zużycie " + obliczZLicznik(stanL)+  " zł. do zapłaty " + obliczLicznik(stanL)  + " zł. " + "rachunek "
                + obliczPrognoza(stanL)  + " zł.";
    }

}
