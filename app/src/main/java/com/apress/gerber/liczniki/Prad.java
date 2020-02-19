package com.apress.gerber.liczniki;

public class Prad extends Suma {
    private int bazaL;
    private int stanL;
    private double ab;
    private String name;
    private int dzienO;

    Prad(String name, int stanL, int bazaL, double ab, int dzienO) {
        this.name = name;
        this.stanL = stanL;
        this.bazaL = bazaL;
        this.ab = ab;
        this.dzienO = dzienO;
    }
    private String getName() {
        return name;
    }
    @Override
    protected void obliczIlosc() {
        super.ilosc = stanL - bazaL;
    }
    @Override
    protected void obliczZuzycie() {
        int zu = stanL - bazaL;
        double zlicznik = Math.round(zu * 1.23 * (super.jcenaS + super.jcenaD) * 100);
        super.zuzycie = zlicznik / 100;
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
        return getName() + ": "  + getIlosc() + " kWh "  + super.toString();
    }
}

