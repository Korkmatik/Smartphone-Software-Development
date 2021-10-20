package com.example.reduce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.reduce.utils.Ggt;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText etNumerator;
    EditText etDenominator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btn_calculate);
        etNumerator = findViewById(R.id.zaehler);
        etDenominator = findViewById(R.id.nenner);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numerator = Integer.parseInt(etNumerator.getText().toString());
                int denominator = Integer.parseInt(etDenominator.getText().toString());

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