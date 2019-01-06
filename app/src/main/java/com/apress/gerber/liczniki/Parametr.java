package com.apress.gerber.liczniki;
import java.util.Calendar;

     public class Parametr {
         private int dp = 5; // dzień pomiaru
         private Calendar dzi = Calendar.getInstance();

         public Parametr() {

         }

         public Parametr(int dp) {
             this.dp = dp;

         }

         protected double obliczParametr() {
             int dy = dzi.get(Calendar.DAY_OF_YEAR);
             int dm = dzi.get(Calendar.DAY_OF_MONTH);
             int m = dzi.get(Calendar.MONTH);

             double wsp = 1;

             if ((dm <= dp) && (m != 0)) // do 5 (oprócz stycznia)
             {
                 m -= 1;

                 Calendar dzie1 = Calendar.getInstance();
                 dzie1.set(Calendar.MONTH, m);
                 dzie1.set(Calendar.DAY_OF_MONTH, dp);

                 Calendar dzie2 = Calendar.getInstance();
                 dzie2.set(Calendar.MONTH, m + 1);
                 dzie2.set(Calendar.DAY_OF_MONTH, dp);

                 int dy1 = dzie1.get(Calendar.DAY_OF_YEAR);
                 int dy2 = dzie2.get(Calendar.DAY_OF_YEAR);
                 double wsp1 = dy2 - dy1;
                 double wsp2 = dy - dy1;
                 wsp = wsp1 / wsp2;

             } else if ((dm <= dp) && (m == 0)) // do 5 w stycznia
             {
                 double wsp1 = 31;
                 double wsp2 = 31 - dp + dm;
                 wsp = wsp1 / wsp2;
             } else if ((dm > dp) && (m != 11)) // po 5 (oprócz grudnia)
             {
                 Calendar dzie1 = Calendar.getInstance();
                 dzie1.set(Calendar.MONTH, m);
                 dzie1.set(Calendar.DAY_OF_MONTH, dp);

                 Calendar dzie2 = Calendar.getInstance();
                 dzie2.set(Calendar.MONTH, m + 1);
                 dzie2.set(Calendar.DAY_OF_MONTH, dp);

                 int dy1 = dzie1.get(Calendar.DAY_OF_YEAR);
                 int dy2 = dzie2.get(Calendar.DAY_OF_YEAR);
                 double wsp1 = dy2 - dy1;
                 double wsp2 = dy - dy1;
                 wsp = wsp1 / wsp2;
             } else if ((dm > dp) && m == 11) // po 5 w grudniu
             {
                 double wsp1 = 31;
                 double wsp2 = dm - dp;
                 wsp = wsp1 / wsp2;
             }
             return wsp;
         }

     }
