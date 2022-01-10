package com.example.primedetection2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCheckPrime;
    private EditText userInput;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCheckPrime = findViewById(R.id.btnPrimeCheck);
        userInput = findViewById(R.id.etNumber);
        txtResult = findViewById(R.id.txtResult);

        txtResult.setText("");

        btnCheckPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number;
                try {
                    number = Integer.parseInt(userInput.getText().toString());
                } catch (Exception e) {
                    return;
                }

                int divisor = isPrime(number);
                if (divisor != 1 && divisor != number) {
                    txtResult.setText(number + " " + getString(R.string.not_prime) + "\n(" + getString(R.string.divisor) + " " + divisor + ")");
                } else {
                    txtResult.setText(number + " " + getString(R.string.is_prime));
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