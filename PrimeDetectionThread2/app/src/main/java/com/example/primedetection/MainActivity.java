package com.example.primedetection;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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
        lblResult.setMovementMethod(LinkMovementMethod.getInstance());

        addOnClickListenerToBtn();
        addAutoCompleteToEtUserInput();
    }

    private void addAutoCompleteToEtUserInput() {
        String[] primeNumbers = new String[] {
                "4847395873",
                "89733450702642291073",
                "570720314346261719006299292137"
        };

        ArrayAdapter<String> primeAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                primeNumbers
        );
        AutoCompleteTextView view = findViewById(R.id.autoCompleteTextView);
        view.setAdapter(primeAdapter);
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
                    long inputNumber = Long.parseLong(userInput);

                    AsyncPrime a = new AsyncPrime();
                    a.execute(inputNumber);
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

    private class AsyncPrime extends AsyncTask<Long, Integer, String> {

        protected void onPreExecute() {
            btnCheckPrime.setEnabled(false);
        }

        @Override
        protected String doInBackground(Long... strings) {
            long inputNumber = strings[0];
            String ret = "";
            
            long divisor = getBiggestDivisor(Math.abs(inputNumber));
            if (divisor == inputNumber || divisor == 1) {
                ret = inputNumber + " " + getString(R.string.is_prime);
            } else {
                ret = inputNumber + " " + getString(R.string.not_prime) +
                                "\n(" + getString(R.string.divisor) + ": " + divisor + ")";
            }

            return ret;
        }

        @Override
        protected void onPostExecute(String s) {
            btnCheckPrime.setEnabled(true);
            lblResult.setText(s);
        }
    }
}