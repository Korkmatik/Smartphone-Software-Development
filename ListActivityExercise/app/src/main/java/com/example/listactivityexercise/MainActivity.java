package com.example.listactivityexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.lvItems);
        String[] titles = {
                "Ford", "Mercedes-Benz", "BMW", "Volkswagen", "Opel", "General Motors",
                "Mazda", "Toyota", "Audi", "Suzuki"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, titles);
        lv.setAdapter(adapter);
    }
}