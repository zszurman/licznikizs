package com.apress.gerber.liczniki;

public abstract class Suma {

   protected int zuzycie = -1;
    protected int dozaplaty = -1;
    protected int prognoza = -1;

    protected abstract void obliczZuzycie();

    protected double getZuzycie() {
        if (zuzycie == -1)
            obliczZuzycie();
        return zuzycie;
    }

    protected abstract void obliczDozaplaty();

    protected double getDozaplaty() {
        if (dozaplaty == -1)
            obliczDozaplaty();
        return dozaplaty;
    }

    protected abstract void obliczPrognoza();

    protected double getPrognoza() {
        if (prognoza == -1)
            obliczPrognoza();
        return prognoza;
    }

    public String toString() {
        return "zużycie: " + getZuzycie() + " zł. do zapłaty: " + getDozaplaty() + " zł. rachunek: " + getPrognoza();

    }

    public static void main(String[] args) {

        Suma woda = new Woda(409);
        System.out.println(woda.toString());
        Suma l94 = new Prąd1(30946);
        System.out.println(l94.toString());
        Suma l95 = new Prąd2(2775);
        System.out.println(l95.toString());
    }



}
