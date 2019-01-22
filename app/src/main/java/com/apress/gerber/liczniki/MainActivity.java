package com.apress.gerber.liczniki;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int stanLW = 1;
    private int bazaLW = 410;
    private double abW = (10.04 + 3.23)*1.08; // woda opłaty stałe
    private int doW = 8;

    private int stanL94 = 1;
    private int bazaL94 = 30932;
    private double ab94 = (4.34 + 6.50 + 0.38 + 6.49 + 6) * 1.23; // L94 opłaty stałe
    private int do94 = 5;
    private String n94 = "L94";

    private int stanL95 = 1;
    private int bazaL95 = 2773;
    private double ab95 = (7 + 6.50 + 0.38 + 6.49 + 6) * 1.23; // L95 opłaty stałe
    private int do95 = 5;
    private String n95 = "L95";
    // ceny jednostkowe podać w abstract class Suma


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        TextView textW = findViewById(R.id.editText3);
        TextView textL1 = findViewById(R.id.editText4);
        TextView textL2 = findViewById(R.id.editText5);
        Button druga = findViewById(R.id.button4);
        textW.setText("Woda odczyt " + String.valueOf(bazaLW));
        textL1.setText("L94 odczyt " + String.valueOf(bazaL94));
        textL2.setText("L95 odczyt "  + String.valueOf(bazaL95));
    }

    public void zmW(View view) {
        TextView textW = findViewById(R.id.editText3);
        TextView podW = findViewById(R.id.editText6);
        if ((podW.getText().length() != 0))
            stanLW = Integer.parseInt(podW.getText().toString());
        else stanLW = 1;
        if ((stanLW < (bazaLW + 300)) && (stanLW >= bazaLW)) {
            Suma woda = new Woda(stanLW, bazaLW, abW, doW);
            textW.setText(woda.toString());
        } else textW.setText(getResources().getString(R.string.blad));
    }

    public void zmL1(View view) {
        TextView textL1 = findViewById(R.id.editText4);
        TextView podL1 = findViewById(R.id.editText7);
        if ((podL1.getText().length() != 0))
            stanL94 = Integer.parseInt(podL1.getText().toString());
        else stanL94 = 1;
        if ((stanL94 >= bazaL94) && (stanL94 < (bazaL94 + 2000))) {
            Suma L94 = new Prad(n94, stanL94, bazaL94, ab94, do94);
            textL1.setText(L94.toString());
        } else textL1.setText(getResources().getString(R.string.blad));
    }

    public void zmL2(View view) {
        TextView textL2 = findViewById(R.id.editText5);
        TextView podL2 = findViewById(R.id.editText8);
        if ((podL2.getText().length() != 0))
            stanL95 = Integer.parseInt(podL2.getText().toString());
        else stanL95 = 1;
        if ((stanL95 >= bazaL95) && (stanL95 < bazaL95 + 2000)) {
            Suma L95 = new Prad(n95, stanL95, bazaL95, ab95, do95);
            textL2.setText(L95.toString());
        } else textL2.setText(getResources().getString(R.string.blad));
    }

    public void druga(View view) {
        Intent drugaIntent = new Intent(getApplicationContext(), DrugaActivity.class);
        drugaIntent.putExtra("aupa", "dzwoń do wodociągów");
        drugaIntent.putExtra("bupa", "podaj liczniki prądu");
        drugaIntent.putExtra("cupa", "dzwoń do Taurona");

        drugaIntent.putExtra("xupa", "tel");
        drugaIntent.putExtra("yupa", "net");
        drugaIntent.putExtra("zupa", "tel");
        startActivity(drugaIntent);
    }

    public void mapa(View view) {

        Intent mapka = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.01513, 018.48285?z=20"));
        if (mapka.resolveActivity(getPackageManager()) != null) {
            startActivity(mapka);
        }

    }

    public void net(View view) {
        Intent mapka = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.11303, 018.54548?z=20"));
        if (mapka.resolveActivity(getPackageManager()) != null) {
            startActivity(mapka);
        }



    }
}
