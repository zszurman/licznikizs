package com.apress.gerber.liczniki;

public abstract class Suma {

    protected double jcenaS = 0.2411; // prąd cena sprzedaży
    protected double jcenaD = 0.1601; // prąd cena dostawy
    protected double jcenaW = 5.19; // woda cena wody
    protected double jcenaK = 6.71; // woda cena kanalizacji

    protected int ilosc = -1;
    protected double zuzycie = -1;
    protected double dozaplaty = -1;
    protected double prognoza = -1;

    protected abstract void obliczIlosc();

    protected double getIlosc() {
        if (ilosc == -1)
            obliczIlosc();
        return ilosc;
    }

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
        return "(" + getZuzycie() + " zł.), aktualnie " + getDozaplaty() + " zł., prognoza " + getPrognoza()
                + " zł.";

    }


}
