package com.example.explizitesintentmitrueckmeldung;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "EXTA_MESSAGE";

    private static final int REQUEST_CODE_EXPLICIT = 12;

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        Button btnSecondActivity = findViewById(R.id.btnSecondActivity);
        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
                iSecondActivity.putExtra(EXTRA_MESSAGE, getString(R.string.hello_first_activity));
                startActivityForResult(iSecondActivity, REQUEST_CODE_EXPLICIT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_EXPLICIT) {
            if (resultCode == RESULT_OK) {
                tvResult.setText(getString(R.string.result) + ": " + data.getStringExtra(EXTRA_MESSAGE));
            } else {
                tvResult.setText(R.string.error_second_activity);
            }
        }
    }
}