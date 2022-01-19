package com.example.primzahlenthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etCandidate;
    Button btnPrimzahlenTest;
    TextView tvResult;

    private Handler handler = new Handler();
    private Thread thread;

    String result = "";
    private static int act = 1;
    private static final String TAG = "MAIN_ACTIVITY";
    private long[] memLoad = new long[1024*1024];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCandidate = findViewById(R.id.etCandidate);
        btnPrimzahlenTest = findViewById(R.id.btnPrimzahlenTest);
        tvResult = findViewById(R.id.tvResult);

        btnPrimzahlenTest.setOnClickListener(this);
        tvResult.setText("");

        act++;
        Runtime runtime = Runtime.getRuntime();
        int numberOfThreads = Thread.getAllStackTraces().keySet().size();
        long consumed = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
        Log.i(TAG, "Anzahl Threads: " + numberOfThreads + "; Consumed Memory: " + consumed);
    }

    @Override
    public void onClick(View view) {
        btnPrimzahlenTest.setEnabled(false);

        thread = new Thread() {
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);

                String txtCandidate = etCandidate.getText().toString();
                boolean df = false;
                long cand, i, mdc;

                if (txtCandidate.length() == 0) return;

                cand = Long.parseLong(txtCandidate);
                mdc = (long) Math.sqrt(cand);
                for (i = 2; i <= mdc; i++) {
                    if (cand % i == 0) {
                        df = true;
                        break;
                    }
                }

                if (cand <= 1) {
                    result = txtCandidate + " ist falsches Argument";
                } else if (df) {
                    result = txtCandidate + " ist keine Primzahl\nDivisor: " + Long.toString(i);
                } else if (!df) {
                    result = txtCandidate + " ist eine Primzahl";
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvResult.setText(result);
                        btnPrimzahlenTest.setEnabled(true);
                    }
                });

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvResult.setText(result);
                        btnPrimzahlenTest.setEnabled(true);
                    }
                });
            }
        };
        thread.start();
    }
}