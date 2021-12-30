package com.example.intentactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Bundle bundle = getIntent().getExtras();
        String sAusgabe = bundle.getString(MainActivity.EXTRA_MESSAGE);

        TextView txtAusgabe = findViewById(R.id.txtAusgabe);
        txtAusgabe.setText(sAusgabe);
    }
}