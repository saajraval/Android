package com.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText edtUserName;
        Button btnLogin;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserName =findViewById(R.id.UserName);
        btnLogin =findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName =edtUserName.getText().toString();
                Toast.makeText(MainActivity.this,"User name is :"+strUserName,Toast.LENGTH_SHORT).show();
            }
        });
    }
}