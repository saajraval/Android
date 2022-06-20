package com.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeSp extends AppCompatActivity {


    TextView tvUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_sp);
        tvUserName = findViewById(R.id.tv_username);

        Intent i= getIntent();
        String strUserName =  i.getStringExtra("KEY_USERNAME");
        tvUserName.setText("User Name is : "+ strUserName);

    }
}