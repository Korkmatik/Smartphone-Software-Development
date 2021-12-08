package com.example.demospinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = findViewById(R.id.spCarBrands1);
        spinner1.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.spCarBrands2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.car_brands,
                android.R.layout.simple_spinner_dropdown_item
        );
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3 = findViewById(R.id.spCarBrands3);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.car_brands,
                android.R.layout.simple_spinner_item
        );
        spinner3.setAdapter(adapter2);
        spinner3.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position != 0) {
            String text = ((TextView)view).getText().toString();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(text);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}