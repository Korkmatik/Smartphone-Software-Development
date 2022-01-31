package com.example.explizitesintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString(MainActivity.DATA_TAG);

        TextView txt = findViewById(R.id.textView);
        txt.setText(data);

        setResult(MainActivity.RESULT_OK, new Intent().putExtra(MainActivity.DATA_TAG, "Test"));
        finish();
    }
}