package com.myfirstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Alertbox extends AppCompatActivity {

    Button btnAlertDialog ;
    boolean btnBackPress =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertbox);
        btnAlertDialog =findViewById(R.id.btn_alert);
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(Alertbox.this);// activity name
                        // alertDialog is a java class that gives popup
                builder.setTitle("My first Alert box");
                builder.setMessage("Hello BAKA?");
                builder.setIcon(R.drawable.home_icon);

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(Alertbox.this, "You are a baka", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Alertbox.this, "You are a kuso yaro", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
//        AlertDialog.Builder builder= new AlertDialog.Builder(Alertbox.this);// activity name
//        // alertDialog is a java class that gives popup
//        builder.setTitle("My first Alert box");
//        builder.setMessage("Hello BAKA?");
//        builder.setIcon(R.drawable.home_icon);
//
//        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//             //   Toast.makeText(Alertbox.this, "You are a baka", Toast.LENGTH_SHORT).show();
//            //    super.onBackPressed();
//            finish();
//            }
//        });
//        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(Alertbox.this, "You are a kuso yaro", Toast.LENGTH_SHORT).show();
//            }
//        });
//        builder.setNeutralButton("Done", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });
//        builder.show();

        if(btnBackPress){
            super.onBackPressed();
            return;
        }

        this.btnBackPress = true;
        Toast.makeText(Alertbox.this, "Press again to exit", Toast.LENGTH_SHORT).show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                btnBackPress=false;
            }
        },2000);
    }
}

