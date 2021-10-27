package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;


public class LifeActivity extends AppCompatActivity {

    public final static String TAG = "LifeActivity";
    private static int activityCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life);

        activityCount++;
        TextView txtActivityCount = findViewById(R.id.txtActivityCounter);
        txtActivityCount.setText("Activity Count: " + activityCount);

        Log.i(TAG, "onCreate: " + (savedInstanceState == null ? "NEW" : "RESTORED"));
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy");
    }
}