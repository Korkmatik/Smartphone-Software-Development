package com.example.explizitesintentmitrueckmeldung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvMessageFromParent;
    private EditText etMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);
        tvMessageFromParent = findViewById(R.id.tvMessageFromParent);

        Bundle bundleExtras = getIntent().getExtras();
        String message = bundleExtras.getString(MainActivity.EXTRA_MESSAGE);
        if (message != null)
            tvMessageFromParent.setText(message);
        else
            tvMessageFromParent.setText(R.string.no_msg_parent);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent resultIntent = new Intent(SecondActivity.this, MainActivity.class);
        resultIntent.putExtra(MainActivity.EXTRA_MESSAGE, etMessage.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}