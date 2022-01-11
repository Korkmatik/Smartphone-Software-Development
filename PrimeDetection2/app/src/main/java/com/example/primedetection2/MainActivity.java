package com.example.primedetection2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnCheckPrime;
    private AutoCompleteTextView userInput;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCheckPrime = findViewById(R.id.btnPrimeCheck);
        userInput = findViewById(R.id.etNumber);
        txtResult = findViewById(R.id.txtResult);

        String[] primzahlen = {
                "7", "11", "2"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, primzahlen);
        userInput.setAdapter(adapter);

        txtResult.setText("");

        btnCheckPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number;
                try {
                    number = Integer.parseInt(userInput.getText().toString());
                } catch (Exception e) {
                    txtResult.setText("Number " + getString(R.string.not_integer));
                    return;
                }

                int divisor = isPrime(number);
                if (divisor != 1 && divisor != number) {
                    txtResult.setText(number + " " + getString(R.string.not_prime) + "\n(" + getString(R.string.divisor) + " " + divisor + ")");
                    txtResult.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                } else {
                    txtResult.setText(number + " " + getString(R.string.is_prime));
                    txtResult.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                }
            }
        });
    }

    private int isPrime(int number) {
        for (int i = 2; i < number / 2 + 1; i++) {
            if (number % i == 0) return i;
        }
        return 1;
    }
}