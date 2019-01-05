package com.apress.gerber.liczniki;

public class Woda extends Suma {

    private int bazaL = 396;
    private int stanL;
    private double jcenaW = 5.19;
    private double jcenaK = 6.71;
    private double ab = 12.20;

     Woda(int stanL) {

        this.stanL = stanL;
    }

    @Override
    protected void obliczZuzycie() {
        int zu = stanL - bazaL;
        double woda = (zu * jcenaW) + (zu * jcenaW * 0.08);
        double kanal = (zu * jcenaK) + (zu * jcenaK * 0.08);
        double zwk = woda + kanal;
        super.zuzycie = (int) Math.round(zwk);

    }

    @Override
    protected void obliczDozaplaty() {
        int zu = stanL - bazaL;
        double woda = (zu * jcenaW) + (zu * jcenaW * 0.08);
        double kanal = (zu * jcenaK) + (zu * jcenaK * 0.08);
        double wk = woda + kanal + ab;
        super.dozaplaty = (int) Math.round(wk);

    }

    @Override
    protected void obliczPrognoza() {
        int zu = stanL - bazaL;
        double woda = (zu * jcenaW) + (zu * jcenaW * 0.08);
        double kanal = (zu * jcenaK) + (zu * jcenaK * 0.08);
        Parametr par = new Parametr();
        double prognozaW = ((woda + kanal) * par.obliczParametr()) + ab;
        super.prognoza = (int) Math.round(prognozaW);

    }
    public String toString() {
        return "W: " + super.toString();
    }


}
