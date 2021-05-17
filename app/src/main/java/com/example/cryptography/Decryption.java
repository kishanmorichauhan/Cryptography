package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Decryption extends AppCompatActivity {

    EditText etdec;
    TextView dectv;
    ClipboardManager cplbord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);

        etdec = findViewById(R.id.etdec);
        dectv = findViewById(R.id.dectv);
        cplbord = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);

    }

    public void dec(View view){
        String temp = etdec.getText().toString();
        String rv= decode.dec(temp);
        dectv.setText(rv);
    }
    public void cp1 (View view){
        String data= dectv.getText().toString().trim();
        if(!data.isEmpty()){
            ClipData temp=ClipData.newPlainText("text",data);
            cplbord.setPrimaryClip(temp);
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
        }

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

    }
}