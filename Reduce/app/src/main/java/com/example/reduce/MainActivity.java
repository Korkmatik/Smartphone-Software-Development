package com.example.reduce;

import androidx.appcompat.app.AppCompatActivity;

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

                if (!CheckNumber.check(strNumerator)) {
                    etNumerator.setError("Zähler muss eine Zahl sein");
                    return;
                }

                if (!CheckNumber.check(strDenominator)) {
                    etDenominator.setError("Nenner muss eine Zahl sein");
                    return;
                }

                int numerator = Integer.parseInt(strNumerator);
                int denominator = Integer.parseInt(strDenominator);

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