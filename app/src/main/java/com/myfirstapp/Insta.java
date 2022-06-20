package com.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Insta extends AppCompatActivity {

    EditText edtUserName;
    Button btnLogin;
    ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insta);

        edtUserName =findViewById(R.id.edt_username);
        btnLogin =findViewById(R.id.btn_login);
        imgLogo = findViewById(R.id.img_logo);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgLogo.setImageResource(R.drawable.home_icon);
                String strUserName =edtUserName.getText().toString().trim();
                if(strUserName.equals("")){
                    Toast.makeText(Insta.this,"Please enter User name :",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Insta.this,"UserName is  :"+strUserName,Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(Insta.this,"User name is :"+strUserName,Toast.LENGTH_SHORT).show();
                //Explicit intent
                Intent i =new Intent(Insta.this,HomeSp.class);
                i.putExtra("KEY_USERNAME",strUserName);
                startActivity(i);// this will pass the data to HomeSp page
            }
        });
    }
}