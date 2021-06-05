package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class spalsh_screen extends AppCompatActivity {

    Animation top , bottom;
    ImageView imageView;
    TextView textView1;

    private static int SPLASH_SCREEN_TIME_OUT=5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        top = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        imageView = findViewById(R.id.logo);
        textView1 = findViewById(R.id.logotitle);

        imageView.setAnimation(top);
        textView1.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(spalsh_screen.this,
                        MainActivity.class);
                //Intent is used to switch from one activity to another.

                startActivity(i);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);

    }
}