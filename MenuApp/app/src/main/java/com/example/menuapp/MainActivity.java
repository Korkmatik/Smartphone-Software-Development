package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itAction1:
                Toast
                    .makeText(
                        MainActivity.this,
                        "Aktion 1 wurde gewählt",
                        Toast.LENGTH_LONG)
                    .show();
                return true;
            case R.id.itAction2:
                Toast
                    .makeText(
                        getApplicationContext(),
                        "Aktion 2 wurde gewählt",
                        Toast.LENGTH_SHORT)
                    .show();
                return true;
            case R.id.itAction3:
                Toast
                    .makeText(
                        this,
                        "Aktion 3 wurde gewählt",
                        Toast.LENGTH_LONG)
                    .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void menuclick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itAction1:
                Toast
                    .makeText(
                        MainActivity.this,
                        "Aktion 1 wurde gewählt über menuclick",
                        Toast.LENGTH_LONG)
                    .show();
                break;
            case R.id.itAction2:
                Toast
                    .makeText(
                        getApplicationContext(),
                        "Aktion 2 wurde gewählt über menuclick",
                        Toast.LENGTH_SHORT)
                    .show();
                break;
            case R.id.itAction3:
                Toast
                    .makeText(
                        this,
                        "Aktion 3 wurde gewählt über menuclick",
                        Toast.LENGTH_LONG)
                    .show();
                break;
        }
    }
}