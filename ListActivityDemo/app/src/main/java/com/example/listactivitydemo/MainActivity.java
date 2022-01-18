package com.example.listactivitydemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cars = new String[] {
            "Mercedes-Benz", "BMW", "Audi", "VW", "Ford", "Mazda", "Opel"
        };

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, cars));
        ListView lv = getListView();
        lv.setVerticalScrollBarEnabled(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Your choice: " + cars[i]);
                builder.create().show();
            }
        });
        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.menu_edit:
                Toast.makeText(this, "Edit with " + cars[acmi.position], Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_del:
                Toast.makeText(this, "Delete with " + cars[acmi.position], Toast.LENGTH_LONG).show();
                return true;
        }

        return super.onContextItemSelected(item);
    }
}