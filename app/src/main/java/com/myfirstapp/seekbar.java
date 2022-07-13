package com.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class seekbar extends AppCompatActivity {

    SeekBar seek_Bar;
    TextView tv_seek;
    Button btn_seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        tv_seek=findViewById(R.id.tv_seekbar);
        seek_Bar=findViewById(R.id.seekbar);
        btn_seek=findViewById(R.id.btn_seekbar);

        btn_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seek_value= tv_seek.getText().toString().trim();
                Intent i =new Intent(seekbar.this,seek_next.class);
                i.putExtra("KEY_SEEK_VALUE",seek_value);
                startActivity(i);// this will pass the data to HomeSp page
            }

        });
        seek_Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                tv_seek.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}