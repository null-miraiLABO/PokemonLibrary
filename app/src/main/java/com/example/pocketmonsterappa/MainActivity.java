package com.example.pocketmonsterappa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg;
    private RadioButton[] rb;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg=findViewById(R.id.radioGroup);
        rb=new RadioButton[4];
        rb[0]=findViewById(R.id.radioButton);
        rb[1]=findViewById(R.id.radioButton2);
        rb[2]=findViewById(R.id.radioButton3);
        rb[3]=findViewById(R.id.radioButton4);
    }


    public void clickStart(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
        startActivity(intent);

        for (int i=0;i< rb.length;i++){
            if(rb[i].isChecked()){
                a=i;
            }
        }

        intent.putExtra("type",a);
        startActivity(intent);
    }
}