package com.apress.gerber.liczniki;

    public class Prąd1 extends Suma {

    private int bazaL = 30683;
    private int stanL;
    private double ab = (4.34 + 6.50 + 0.38 + 6.49 + 6) * 1.23;
    private double jcenaS = 0.2411;
    private double jcenaD = 0.1601;

    Prąd1( int stanL)
    {

        this.stanL = stanL;
    }


    @Override
    protected void obliczZuzycie() {
        int zu = stanL - bazaL;
        double s11 = zu * jcenaS * 1.23;
        double s21 = zu * jcenaD * 1.23;
        double zlicznik1 = s11 + s21;
        super.zuzycie = (int) Math.round(zlicznik1);

    }

    @Override
    protected void obliczDozaplaty() {
        int zu= stanL - bazaL;
        double s11 = zu * jcenaS * 1.23;
        double s21 = zu * jcenaD * 1.23;
        double licznik1 = s11 + s21 + ab;
        super.dozaplaty = (int) Math.round(licznik1);

    }

    @Override
    protected void obliczPrognoza() {
        int zuycie = stanL - bazaL;
        double s11 = zuycie * jcenaS * 1.23;
        double s21 = zuycie * jcenaD * 1.23;
        Parametr par1 = new Parametr();
        double prognozaL1 = ((s11 + s21) * par1.obliczParametr()) + ab;
        super.prognoza = (int) Math.round(prognozaL1);

    }
    public String toString() {
        return "L94: " + super.toString();
    }

}
