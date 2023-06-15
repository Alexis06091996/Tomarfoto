package com.example.tomarfotojava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


        private ImageView imageView;
        private Bitmap imageBitmap;
        private static final int REQUEST_IMAGE_CAPTURE = 101;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            imageView = findViewById(R.id.ima1);
        }

        public void takePicture(View view) {
            Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (imageTakeIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE);
            }
        }

        public void saveImage(View view) {
            if (imageBitmap != null) {
                String savedImageURL = MediaStore.Images.Media.insertImage(
                        getContentResolver(),
                        imageBitmap,
                        "Imagen capturada",
                        "Descripción de la imagen"
                );
                Toast.makeText(this,"EXITO AL GUARDAR!",Toast.LENGTH_LONG).show();
                if (savedImageURL != null) {

                } else {

                }
            } else {

            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                imageBitmap = (Bitmap) extras.get("data");
                imageView.setImageBitmap(imageBitmap);

            }
        }

    }





