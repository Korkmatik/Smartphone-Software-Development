package com.example.listactivityexercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.lvItems);
        String[] titles = {
                "Ford", "Mercedes-Benz", "BMW", "Volkswagen", "Opel", "General Motors",
                "Mazda", "Toyota", "Audi", "Suzuki", "MAN", "Skoda", "Ford", "Bantley", "Porsche",
                "Ferrari", "Lamborghini", "Fiat", "Seat", "Renault"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, titles);
        lv.setAdapter(adapter);

        lv.setVerticalScrollBarEnabled(true);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // builder.setMessage("Ihre Wahl: " + titles[position]);
                builder.setMessage("Ihre Wahl: " + ((TextView) view).getText().toString());

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.context_edit:
                Toast.makeText(this, "EDIT: " + adapterContextMenuInfo.id, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.context_delete:
                Toast.makeText(this, "DELETE: " + adapterContextMenuInfo.id, Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}