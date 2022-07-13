package com.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class SimpleGridView extends AppCompatActivity {
    GridView gridView;

    String strLang[]={"Data 1","Data 2","Data 3","Data 4","Data 5","Data 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_grid_view);

        gridView = findViewById(R.id.grid_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.raw_grid,R.id.tv_grid_view,strLang);
        gridView.setAdapter(arrayAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String data = strLang[i];
            }
        });

    }
}