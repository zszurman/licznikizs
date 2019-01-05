package com.apress.gerber.liczniki;

   public class Prąd2 extends Suma{


    private int bazaL = 2658;
    private int stanL;
    private double jcenaS = 0.2411;
    private double jcenaD = 0.1601;
    private double ab = (7 + 6.50 + 0.38 + 6.49 + 6) * 1.23;

    Prąd2(int stanL) {

        this.stanL = stanL;
    }

    @Override
    protected void obliczZuzycie() {
        int zu = stanL - bazaL;
        double s12 = zu * jcenaS * 1.23;
        double s22 = zu * jcenaD * 1.23;
        double zlicznik2 = s12 + s22;
        super.zuzycie = (int) Math.round(zlicznik2);

    }

    @Override
    protected void obliczDozaplaty() {
        int zu = stanL - bazaL;
        double s12 = zu * jcenaS * 1.23;
        double s22 = zu * jcenaD * 1.23;
        double licznik2 = s12 + s22 + ab;
        super.dozaplaty = (int) Math.round(licznik2);

    }

    @Override
    protected void obliczPrognoza() {
        int zuycie = stanL - bazaL;
        double s12 = zuycie * jcenaS * 1.23;
        double s22 = zuycie * jcenaD * 1.23;
       Parametr par2 = new Parametr();
        double prognozaL2 = ((s12 + s22) * par2.obliczParametr()) + ab;
        super.prognoza= (int) Math.round(prognozaL2);

    }

    public String toString() {
        return "L95: " + super.toString();
    }
}
