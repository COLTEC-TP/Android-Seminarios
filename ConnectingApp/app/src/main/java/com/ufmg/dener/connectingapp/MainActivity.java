package com.ufmg.dener.connectingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_bluetooth = findViewById(R.id.btn_bluetooth);
        Button btn_nfc = findViewById(R.id.btn_nfc);

        btn_bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bluetooth = new Intent(MainActivity.this, Bluetooth.class);
                startActivity(bluetooth);
            }
        });

        btn_nfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nfc = new Intent(MainActivity.this, Nfc.class);
                startActivity(nfc);
            }
        });

    }
}
