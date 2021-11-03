package com.example.memoryconsumer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShowMemoryClass();
        ShowMemoryInfo();
        InitDataAllocation();
    }

    private void InitDataAllocation() {
        data = new ArrayList<>();
        Button btnAllocateMemory = findViewById(R.id.btnCreateStrings);
        btnAllocateMemory.setOnClickListener(v -> {
            for (int i = 0; i < 100; i++) {
                String generatedString = "";
                for (int j = 0; j < 100; j++) {
                    UUID uuid = UUID.randomUUID();
                    generatedString += uuid.toString();
                }
                data.add(generatedString);
            }

            ShowMemoryInfo();
        });
    }

    private void ShowMemoryInfo() {
        long maxMemory = Runtime.getRuntime().maxMemory() / 1000;
        long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
        long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
        long memoryConsumed = totalMemory - freeMemory;

        TextView txtMaxMemory = findViewById(R.id.txtMaxMemory);
        TextView txtTotalMemory = findViewById(R.id.txtTotalMemory);
        TextView txtFreeMemory = findViewById(R.id.txtFreeMemory);
        TextView txtMemoryConsumed = findViewById(R.id.txtMemoryConsumed);

        txtMaxMemory.setText("Max Memory (KB): " + maxMemory);
        txtTotalMemory.setText("Total Memory (KB): " + totalMemory);
        txtFreeMemory.setText("Free Memory (KB): " + freeMemory);
        txtMemoryConsumed.setText("Memory Consumed (KB): " + memoryConsumed);
    }

    private void ShowMemoryClass() {
        ActivityManager activityManager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        int memoryClass = activityManager.getMemoryClass();
        TextView txtMemoryClass = findViewById(R.id.txtMemoryClass);
        txtMemoryClass.setText("Memory Class (MB): " + memoryClass);
    }
}