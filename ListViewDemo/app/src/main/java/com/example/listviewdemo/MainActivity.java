package com.example.listviewdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        String[] cars = new String[] {
            "Mercedes-Benz", "Mazda", "Ford", "BMW", "VW", "Audi", "Jaguar", "Smart", "Nissan",
            "Toyoto", "Kia", "Chevrolet", "Rolls-Royce", "Lamborghini", "Porsche", "Rover", "Opel"
        };
        ArrayAdapter<String> carsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cars);
        listView.setAdapter(carsAdapter);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Your choice: " + cars[i]);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}