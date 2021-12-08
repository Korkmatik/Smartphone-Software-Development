package com.example.progressbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button btn;
    ProgressTask demoTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar1);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demoTask = new ProgressTask();
                demoTask.execute();
            }
        });
    }

    private class ProgressTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            btn.setEnabled(false);
            progressBar.setProgress(0);
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            int i = 0;
            while (i < 100) {
                if (this.isCancelled()) {
                    return null;
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
                i++;
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            btn.setEnabled(true);
        }
    }
}