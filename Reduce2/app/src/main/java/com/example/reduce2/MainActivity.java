package com.example.reduce2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnReduce;
    TextView txtZahler;
    TextView txtNenner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtZahler = findViewById(R.id.etZaehler);
        txtNenner = findViewById(R.id.etNenner);

        btnReduce = findViewById(R.id.btnReduce);
        btnReduce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int zaehler, nenner;
        try {
            zaehler = Integer.parseInt(txtZahler.getText().toString());
            nenner = Integer.parseInt(txtNenner.getText().toString());
        } catch (NumberFormatException exception) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Zähler und Nenner müssen ein Integer Wert sein!");

            AlertDialog dialog = builder.create();
            dialog.show();

            return;
        }


        if (zaehler * nenner != 0) {
            int rest;
            int ggt = Math.abs(zaehler);
            int divisor = Math.abs(nenner);
            do {
                rest = ggt % divisor;
                ggt = divisor;
                divisor = rest;
            } while (rest > 0);

            zaehler /= ggt;
            nenner /= ggt;
        }

        txtZahler.setText(String.valueOf(zaehler));
        txtNenner.setText(String.valueOf(nenner));
    }
}