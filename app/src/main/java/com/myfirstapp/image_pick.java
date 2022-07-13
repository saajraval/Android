package com.myfirstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class image_pick extends AppCompatActivity {

    ImageView imgDp;
    Button btnGallery,btnCam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pick);
        imgDp = findViewById(R.id.img_dp);
        btnGallery= findViewById(R.id.btn_imgpick);
        btnCam=findViewById(R.id.btn_imgcam);

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent();
//                i.setAction(Intent.ACTION_PICK);
                Intent i =new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i,11);
            }
        });
        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,12);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 11 && resultCode ==RESULT_OK) {
            Uri uri = data.getData(); // data is intent object used to use the getData method
            // getData gives us uri format
            imgDp.setImageURI(uri);
        }
        if(requestCode == 12 && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)  data.getExtras().get("data");
            imgDp.setImageBitmap(bitmap);
            //getExtra gives us bitmap format
            // bitmap is a class of android gaphic and the data coming is not in the format of bitmap so we cast it
        }
    }
}
