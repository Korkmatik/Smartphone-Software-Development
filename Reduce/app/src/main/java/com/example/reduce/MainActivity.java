package com.example.reduce;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.reduce.utils.CheckNumber;
import com.example.reduce.utils.Ggt;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText etNumerator;
    EditText etDenominator;

    private Animation rotate;
    private MediaPlayer btnSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindViews();
        SetCalculateAction();
        loadAnimation();
        loadSound();
    }

    private void loadSound() {
        btnSound = MediaPlayer.create(this, R.raw.fallbackring);
    }

    private void loadAnimation() {
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
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
                alertDialogBuilder.setPositiveButton(getString(R.string.okay), (dialog, which) -> {});

                if (!CheckNumber.check(strNumerator)) {
                    String message = getString(R.string.numberator_not_number_error);
                    etNumerator.setError(message);

                    alertDialogBuilder.setMessage(message);

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    return;
                }

                if (!CheckNumber.check(strDenominator)) {
                    String message = getString(R.string.denominator_not_number_error);
                    etDenominator.setError(message);

                    alertDialogBuilder.setMessage(message);

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    return;
                }

                int numerator = Integer.parseInt(strNumerator);
                int denominator = Integer.parseInt(strDenominator);

                if (denominator == 0) {
                    String message = getString(R.string.denominator_zero_error);
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

                v.startAnimation(rotate);
                btnSound.start();
            }
        });
    }
}