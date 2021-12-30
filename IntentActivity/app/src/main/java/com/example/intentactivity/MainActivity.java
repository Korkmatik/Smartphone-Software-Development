package com.example.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final String EXTRA_MESSAGE = "Hallo, Aufruf der zweiten Aktivität";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetButtonOnClickListener();
    }

    private void SetButtonOnClickListener() {
        Button btnSecondAcitivty = findViewById(R.id.btnStartSecondActivity);
        btnSecondAcitivty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSecondActivity = new Intent(MainActivity.this, SecondaryActivity.class);
                intentSecondActivity.putExtra(EXTRA_MESSAGE, "Hallo nocheinmal");
                startActivity(intentSecondActivity);
            }
        });
    }
}