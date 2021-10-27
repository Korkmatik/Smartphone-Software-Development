package com.example.reduce;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.reduce.utils.CheckNumber;
import com.example.reduce.utils.Ggt;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText etNumerator;
    EditText etDenominator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindViews();
        SetCalculateAction();
    }

    private void FindViews() {
        btnCalculate = findViewById(R.id.btn_calculate);
        etNumerator = findViewById(R.id.zaehler);
        etDenominator = findViewById(R.id.nenner);
    }

    private void SetCalculateAction() {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNumerator = etNumerator.getText().toString();
                String strDenominator = etDenominator.getText().toString();

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setPositiveButton("Okay", (dialog, which) -> {});

                if (!CheckNumber.check(strNumerator)) {
                    String message = "Zähler muss eine Zahl sein";
                    etNumerator.setError(message);

                    alertDialogBuilder.setMessage(message);

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    return;
                }

                if (!CheckNumber.check(strDenominator)) {
                    String message = "Nenner muss eine Zahl sein";
                    etDenominator.setError(message);

                    alertDialogBuilder.setMessage(message);

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    return;
                }

                int numerator = Integer.parseInt(strNumerator);
                int denominator = Integer.parseInt(strDenominator);

                if (denominator == 0) {
                    String message = "Nenner darf keine 0 sein";
                    etDenominator.setError(message);

                    alertDialogBuilder.setMessage(message);

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    return;
                }

                int ggt = Ggt.calculate(numerator, denominator);
                numerator /= ggt;
                denominator /= ggt;

                Log.d("MAIN_ACTIVITY", "numberator: " + numerator + ", denominator: " + denominator);

                etNumerator.setText("" + numerator);
                etDenominator.setText("" + denominator);
            }
        });
    }
}