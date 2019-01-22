package com.apress.gerber.liczniki;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DrugaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_druga);

        Intent dupa = getIntent();
        TextView ts1 = findViewById(R.id.ts1);
        TextView ts2 = findViewById(R.id.ts2);
        TextView ts3 = findViewById(R.id.ts3);

        TextView bts1 = findViewById(R.id.bts1);
        TextView bts2 = findViewById(R.id.bts2);
        TextView bts3 = findViewById(R.id.bts3);

        ts1.setText(dupa.getStringExtra("aupa"));
        ts2.setText(dupa.getStringExtra("bupa"));
        ts3.setText(dupa.getStringExtra("cupa"));

        bts1.setText(dupa.getStringExtra("xupa"));
        bts2.setText(dupa.getStringExtra("yupa"));
        bts3.setText(dupa.getStringExtra("zupa"));
    }

    public void dzwon(View view) {

        Intent tel = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+48324552634"));
        if (tel.resolveActivity(getPackageManager()) != null) {
            startActivity(tel);
        }
    }

    public void wyslij(View view) {

        Intent stronka = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ebok.tauron.pl/"));
        if (stronka.resolveActivity(getPackageManager()) != null) {
            startActivity(stronka);
        }
    }

    public void rob(View view) {

        Intent tel = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+48323030991"));
        if (tel.resolveActivity(getPackageManager()) != null) {
            startActivity(tel);
        }




      /*  String[] jola= {"jolszurman@wp.pl"};
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, jola);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Od Zyszka");
        intent.putExtra(Intent.EXTRA_TEXT, "Cześć, testuja program. Miłych snów:)");

        if (intent.resolveActivity(getPackageManager()) != null) {


        startActivity(Intent.createChooser(intent, "Send Email"));
*/

    }

}