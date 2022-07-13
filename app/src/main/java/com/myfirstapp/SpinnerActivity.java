package com.myfirstapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinner;
    String strLang[]={"Select Data ","JAVA","CPP","C","Android",".NET","MEAN","MERN","JS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner= findViewById(R.id.spn_spinner);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_list_item_1,strLang){
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView tvData =(TextView) super.getDropDownView(position, convertView, parent);
                if(position == 0){
                    tvData.setTextColor(Color.BLACK);
                }
                else {
                    Random r = new Random();
                    int red=r.nextInt(255 - 0 + 1)+0;
                    int green=r.nextInt(255 - 0 + 1)+0;
                    int blue=r.nextInt(255 - 0 + 1)+0;

                    tvData.setTextColor(Color.rgb(red,green,blue));
                }
                return tvData;
                //this is to change the color of bg of TV
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView tvData =(TextView) super.getDropDownView(position, convertView, parent);
                if(position == 0){
                    tvData.setTextColor(Color.BLACK);
                }

                else if(position%2==0){

                    tvData.setTextColor(Color.CYAN);
                }
                else if (position %2!=0){
                    tvData.setTextColor(Color.RED);
                }
                return tvData;
            }
        };

        //to take data from one TV
        spinner.setAdapter(arrayAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String strData = adapterView.getSelectedItem().toString();
                // if(strData.equals("Select Data"))
                if(i !=0) {
                       Toast.makeText(SpinnerActivity.this, "Your coding Language is : " + strData, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}