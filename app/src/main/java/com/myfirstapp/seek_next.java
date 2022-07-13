package com.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class seek_next extends AppCompatActivity {

    TextView tv_seek_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_next);
        tv_seek_val=findViewById(R.id.tv_seek_next);

        Intent i= getIntent();
        String strSeekVal =  i.getStringExtra("KEY_SEEK_VALUE");
        tv_seek_val.setText("Seek bar value is  : "+ strSeekVal);

    }
}