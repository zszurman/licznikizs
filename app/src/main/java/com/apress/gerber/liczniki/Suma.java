package com.apress.gerber.liczniki;

public abstract class Suma {

    double jcenaS = 0.2431; // prąd cena sprzedaży
    double jcenaD = 0.1691+0.00139; // prąd cena dostawy
    double jcenaW = 5.19; // woda cena wody
    double jcenaK = 7.02; // woda cena kanalizacji
    int ilosc = -1;
    double zuzycie = -1;
    double dozaplaty = -1;
    double prognoza = -1;

    protected abstract void obliczIlosc();

    double getIlosc() {
        if (ilosc == -1)
            obliczIlosc();
        return ilosc;
    }

    protected abstract void obliczZuzycie();

    private double getZuzycie() {
        if (zuzycie == -1)
            obliczZuzycie();
        return zuzycie;
    }

    protected abstract void obliczDozaplaty();

    private double getDozaplaty() {
        if (dozaplaty == -1)
            obliczDozaplaty();
        return dozaplaty;
    }

    protected abstract void obliczPrognoza();

    private double getPrognoza() {
        if (prognoza == -1)
            obliczPrognoza();
        return prognoza;
    }

    public String toString() {
        return "(" + getZuzycie() + " zł.), aktualnie " + getDozaplaty() + " zł., prognoza " + getPrognoza()
                + " zł.";
    }
}
