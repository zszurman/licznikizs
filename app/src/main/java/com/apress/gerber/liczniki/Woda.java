package com.apress.gerber.liczniki;

public class Woda extends Suma {
    private int bazaL;
    private int stanL;
    private double ab;
    private int dzienO;

    public Woda(int stanL, int bazaL, double ab, int dzienO) {

        this.stanL = stanL;
        this.bazaL = bazaL;
        this.ab = ab;
        this.dzienO = dzienO;
    }

    @Override
    protected void obliczIlosc() {
        super.ilosc = stanL - bazaL;

    }

    @Override
    protected void obliczZuzycie() {
        int zu = stanL - bazaL;
        double woda = (zu * super.jcenaW)*1.08;
        double kanal = (zu * super.jcenaK)*1.08;
        double zwk = Math.round((woda + kanal) * 100);
        super.zuzycie = zwk / 100;
    }

    @Override
    protected void obliczDozaplaty() {

        double doz = Math.round((super.zuzycie + ab) * 100);
        super.dozaplaty = doz / 100;
    }

    @Override
    protected void obliczPrognoza() {

        Parametr par = new Parametr(dzienO);
        double prog = Math.round((super.zuzycie * par.obliczParametr() + ab) * 100);
        super.prognoza = prog / 100;
    }

    public String toString() {
        return "W: " + getIlosc() + " m^3 " + super.toString();
    }

}
