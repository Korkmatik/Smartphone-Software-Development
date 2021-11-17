package com.example.primedetection;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etUserInput;
    TextView lblResult;
    Button btnCheckPrime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        // Resetting result text
        lblResult.setText("");

        addOnClickListenerToBtn();
    }

    private void addOnClickListenerToBtn() {
        btnCheckPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = etUserInput.getText().toString();
                if (!userInput.matches("-?\\d+")) {
                    PrintError(userInput, userInput + " " + getString(R.string.not_integer));
                }

                try {
                    long inputNumber = Integer.parseInt(userInput);
                    long divisor = getBiggestDivisor(Math.abs(inputNumber));

                    if (divisor == inputNumber) {
                        lblResult.setText(userInput + " " + getString(R.string.is_prime));
                    } else {
                        lblResult.setText(
                                userInput + " " + getString(R.string.not_prime) +
                                        "\n(" + getString(R.string.divisor) + ": " + divisor + ")"
                        );
                    }
                } catch (java.lang.NumberFormatException e){
                    PrintError(userInput, userInput + " " + getString(R.string.not_integer));
                }
            }
        });
    }

    private void PrintError(String userInput, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setPositiveButton(getString(R.string.ok), null);
        builder.setMessage(message);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void findViews() {
        etUserInput = findViewById(R.id.etPrimeNumber);
        lblResult = findViewById(R.id.lblResult);
        btnCheckPrime = findViewById(R.id.btnCheckPrime);
    }

    private long getBiggestDivisor(long number) {
        long numberToCheck = number;
        while (numberToCheck > 1) {
            numberToCheck--;

            if (number % numberToCheck == 0) {
                return numberToCheck;
            }
        }

        return number;
    }
}