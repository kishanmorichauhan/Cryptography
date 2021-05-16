package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Encryption extends AppCompatActivity {

    EditText etenc;
    TextView etctv;
    ClipboardManager cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);

        etenc=findViewById(R.id.etenc);
        etctv=findViewById(R.id.enctv);
        cpb=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

    }
    public void enc(View view){
        String temp = etenc.getText().toString();
        String rv = encode.enc(temp);
        etctv.setText(rv);
    }

    public void copy(View view){

        String data = etctv.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp = ClipData.newPlainText("text",data);
            cpb.setPrimaryClip(temp);
            Toast.makeText(this, "Copied", Toast.LENGTH_LONG).show();
        }

    }
}