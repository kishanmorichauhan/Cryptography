package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button enc,dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        enc=findViewById(R.id.btn_encr);
        dec=findViewById(R.id.btn_decr);
        enc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this,Encryption.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Encryption", Toast.LENGTH_SHORT).show();
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Decryption.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Decryption", Toast.LENGTH_SHORT).show();
            }
        });


    }
}