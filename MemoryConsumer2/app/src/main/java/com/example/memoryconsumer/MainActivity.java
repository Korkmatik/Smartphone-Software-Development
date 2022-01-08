package com.example.memoryconsumer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAllocateMemory;
    private TextView txtMemoryClass;
    private TextView txtMaxMemory;
    private TextView txtTotalMemory;
    private TextView txtFreeMemory;
    private TextView txtConsumedMemory;

    private ArrayList<String> strings;

    private ActivityManager activityManager;
    private Runtime runtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        findUIElements();
        initBtnAllocateMemory();
        setMemoryInformation();
    }

    private void initBtnAllocateMemory() {
        btnAllocateMemory.setOnClickListener(view -> allocateMemory());
    }

    private void initVariables() {
        strings = new ArrayList<>();
        activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        runtime = Runtime.getRuntime();
    }

    private void findUIElements() {
        btnAllocateMemory = findViewById(R.id.btnCreateStrings);
        txtMemoryClass = findViewById(R.id.txtMemoryClass);
        txtMaxMemory = findViewById(R.id.txtMaxMemory);
        txtTotalMemory = findViewById(R.id.txtTotalMemory);
        txtFreeMemory = findViewById(R.id.txtFreeMemory);
        txtConsumedMemory = findViewById(R.id.txtMemoryConsumed);
    }

    private void allocateMemory() {
        String allocatedString = "";

        for (int i = 0; i < 4096; i++) {
            allocatedString += "a";
        }

        strings.add(allocatedString);

        setMemoryInformation();
    }

    private void setMemoryInformation() {
        int memoryClass = activityManager.getMemoryClass();
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory() / 1024;
        long freeMemory = runtime.freeMemory() / 1024;
        long consumed = totalMemory - freeMemory;

        txtMemoryClass.setText("Memory Class (MB): " + memoryClass);
        txtMaxMemory.setText("Max Memory (KB): " + maxMemory);
        txtTotalMemory.setText("Total Memory (KB): " + totalMemory);
        txtFreeMemory.setText("Free Memory (KB): " + freeMemory);
        txtConsumedMemory.setText("Memory Consumed (KB): " + consumed);
    }
}