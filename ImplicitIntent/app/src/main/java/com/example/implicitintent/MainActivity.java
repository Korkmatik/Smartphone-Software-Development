package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHsKemptenButton();
        initViewContactsButton();
        initViewSettingsButton();
    }

    private void initViewSettingsButton() {
        Button btnSettings = findViewById(R.id.btnViewSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(Settings.ACTION_SETTINGS);
                if (settingsIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(settingsIntent);
            }
        });
    }

    private void initViewContactsButton() {
        Button btnViewContacts = findViewById(R.id.btnViewContacts);
        btnViewContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewContactsIntent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
                startActivity(viewContactsIntent);
            }
        });
    }

    private void initHsKemptenButton() {
        Button btnHsKempten = findViewById(R.id.btnHSKempten);
        btnHsKempten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String HsKemptenURL = "https://www.hs-kempten.de";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(HsKemptenURL));
                Intent chooserIntent = Intent.createChooser(browserIntent, getString(R.string.choose_browser));
                startActivity(chooserIntent);
            }
        });
    }
}