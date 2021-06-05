package com.example.cryptography;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Image_enc_dec extends AppCompatActivity {

    Button btn_encode,btn_decode;
    TextView textView;
    ImageView imageView;
    String sImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_enc_dec);

        btn_encode = findViewById(R.id.btn_ImgEnc);
        btn_decode  = findViewById(R.id.btn_ImgDec);
        textView = findViewById(R.id.tv_dec2);
        imageView = findViewById(R.id.img_enc);

        btn_encode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ContextCompat.checkSelfPermission(Image_enc_dec.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(Image_enc_dec.this ,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);

                }else{
                    selectImage();
                }
            }
        });


        btn_decode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Image_enc_dec.this, "Decode Image Successes", Toast.LENGTH_SHORT).show();
                byte[] bytes  = Base64.decode(sImage,Base64.DEFAULT);
                Bitmap bitmap  = BitmapFactory.decodeByteArray(bytes , 0 ,bytes.length);
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    private void selectImage(){
        textView.setText("");
        imageView.setImageBitmap(null);
        Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(openGalleryIntent,1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==1 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

            selectImage();

        }else {
            Toast.makeText(getApplicationContext(),"Permission Denied. ",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null){

            Uri uri = data.getData();
            try{

                Toast.makeText(this, "Encode Image Successes", Toast.LENGTH_SHORT).show();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
                byte[] bytes = stream.toByteArray();


                sImage = Base64.encodeToString(bytes,Base64.DEFAULT);
                textView.setText(sImage);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}