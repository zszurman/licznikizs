package com.apress.gerber.liczniki;
import java.util.Calendar;

public class Parametr {


    private Calendar dzi = Calendar.getInstance();
    private int korekta = 0;

    public Parametr(int korekta)
    {
        this.korekta = korekta;
    }

    public double obliczParametr()
    {
        int dy = dzi.get(Calendar.DAY_OF_YEAR);
        int dm = dzi.get(Calendar.DAY_OF_MONTH);
        int m = dzi.get(Calendar.MONTH);
        double wsp = 1;

        if (dm <= (5 + korekta) && m < 11)
        {
            m -= 1;

            Calendar dzie1 = Calendar.getInstance();
            dzie1.set(Calendar.MONTH, m);
            dzie1.set(Calendar.DAY_OF_MONTH, 5 + korekta);

            Calendar dzie2 = Calendar.getInstance();
            dzie2.set(Calendar.MONTH, m + 1);
            dzie2.set(Calendar.DAY_OF_MONTH, 5 + korekta);

            int dy1 = dzie1.get(Calendar.DAY_OF_YEAR);
            int dy2 = dzie2.get(Calendar.DAY_OF_YEAR);
            double wsp1 = dy2 - dy1;
            double wsp2 = dy - dy1;
            wsp = wsp1 / wsp2;

        } else if (dm > (5 + korekta) && m < 11)
        {
            Calendar dzie1 = Calendar.getInstance();
            dzie1.set(Calendar.MONTH, m);
            dzie1.set(Calendar.DAY_OF_MONTH, 5 + korekta);

            Calendar dzie2 = Calendar.getInstance();
            dzie2.set(Calendar.MONTH, m + 1);
            dzie2.set(Calendar.DAY_OF_MONTH, 5 + korekta);

            int dy1 = dzie1.get(Calendar.DAY_OF_YEAR);
            int dy2 = dzie2.get(Calendar.DAY_OF_YEAR);
            double wsp1 = dy2 - dy1;
            double wsp2 = dy - dy1;
            wsp = wsp1 / wsp2;
        } else if (dm > (5 + korekta) && m == 11)
        {
            double wsp1 = dm - (5 + korekta);
            double wsp2 = 31;
            wsp = wsp1 / wsp2;
        } else if (dm <= (5 + korekta) && m == 11)
        {
            double wsp1 = 26 + dm;
            double wsp2 = 31;
            wsp = wsp1 / wsp2;
        }
        return wsp;
    }


}
