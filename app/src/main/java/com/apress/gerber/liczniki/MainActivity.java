package com.apress.gerber.liczniki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void zmW(View view) {
        TextView textW = findViewById(R.id.editText3);
        TextView podW = findViewById(R.id.editText6);
        int w = 1;
        if ((podW.getText().length() != 0))
            w = Integer.parseInt(podW.getText().toString());
        else w = 1;

        if ((w >= 293) && (w < 400)) {
            Woda woda = new Woda(0, w);
            textW.setText(woda.toString());
        } else textW.setText("nieprawidłowe dane");

    }

    public void zmL1(View view) {
        TextView textL1 = findViewById(R.id.editText4);
        TextView podL1 = findViewById(R.id.editText7);
        int w = 1;
        if ((podL1.getText().length() != 0))
            w = Integer.parseInt(podL1.getText().toString());
        else w = 1;

        if ((w >= 29019) && (w < 39019)) {
            Prąd1 woda = new Prąd1(0, w);
            textL1.setText(woda.toString());
        } else textL1.setText("nieprawidłowe dane");

    }

    public void zmL2(View view) {

        TextView textL2 = findViewById(R.id.editText5);
        TextView podL2 = findViewById(R.id.editText8);
        int w = 1;
        if ((podL2.getText().length() != 0))
            w = Integer.parseInt(podL2.getText().toString());
        else w = 1;

        if ((w >= 1685) && (w < 9023)) {
            Prąd2 woda = new Prąd2(0, w);
            textL2.setText(woda.toString());
        } else textL2.setText("nieprawidłowe dane");
    }

}