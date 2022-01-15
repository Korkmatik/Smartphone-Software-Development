package com.example.progressbar;

import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.util.Timer;

public class ProgressDemoTask extends AsyncTask<ProgressBar, Integer, String> {
    @Override
    protected String doInBackground(ProgressBar... progressBars) {
        ProgressBar bar = progressBars[0];

        for (int i = 1; i <= 100; i++) {
            bar.setProgress(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "";
    }
}
