package com.example.pocketmonsterappa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainActivity2 extends AppCompatActivity {
    private String[] setumeiData;
    private TextView tvSetumeiData;
    private String typeTe;
    private TextView name;
    private String sentakuName;
    private String fileNa;
    private int typenum;
    private int intNo;
    private int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        typenum=intent.getIntExtra("type",0);

        intNo=0;

        name=findViewById(R.id.textView3);
        tvSetumeiData=findViewById(R.id.textView4);
        tvSetumeiData=findViewById(R.id.textView4);
        TextView textView=findViewById(R.id.textView5);
        textView.setText(typeTe);
        initInputData();
        hikaku();
    }


    //ボタンを押したときにsentakunameとtypeTeが同じ値だったら、その行をとりだして表示する
    public void clickNext(View view) {
        setNextData();
        hikaku();

    }


    //setumeiDataの中身を","ごとに区切り対応するそれぞれの変数に保存する処理
    private void setNextData(){
        StringTokenizer st=new StringTokenizer(setumeiData[intNo],",");
        String str;

        str=st.nextToken();
        name.setText(str);

        str=st.nextToken();
        typeTe=str;

        str=st.nextToken();
        fileNa=str;

        str=st.nextToken();
        tvSetumeiData.setText(str);

    }


    //csvファイルの中身を行ごとにsetumeiData配列に入れる処理
    private void initInputData(){
        try {
            AssetManager assets=getAssets();
            InputStream in=assets.open("pokemon.csv");
            String str;
            int j=0;
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            if (br.readLine()!=null){
                setumeiData=new String[100];
                while ((str=br.readLine())!=null){
                    Log.d("pokemon.csv["+j+"]",str);
                    setumeiData[j++]=str;
                }
            }
        }catch (Exception e){
            Log.d("pokemon.csv","読み込み失敗");
        }
    }


    //file名をcsvファイルから取り出して表示する
    private void imageVi(){
        ImageView iv=(ImageView)findViewById(R.id.imageView);
        AssetManager as=getResources().getAssets();
        try {
            InputStream is=as.open("png/"+fileNa);
            Bitmap bm= BitmapFactory.decodeStream(is);
            iv.setImageBitmap(bm);
        }catch (Exception e){
            Log.e("image","読み込み失敗");
        }
    }

    private void hikaku(){
        StringTokenizer st=new StringTokenizer(setumeiData[intNo],",");
        String str;
        str=st.nextToken();
        str=st.nextToken();

        switch (typenum){
            case 1:
                if(str.equals("くさ")){
                    setNextData();
                    intNo++;
                    if (intNo>=7){
                        intNo=0;
                    }
                }else{
                    intNo++;
                    if (intNo>=7){
                        intNo=0;
                    }
                    hikaku();
                }
                break;
            case 2:
                if(str.equals("ほのお")){
                   setNextData();
                    intNo++;
                    if (intNo>=7){
                        intNo=0;
                    }
                }else{
                    intNo++;
                    if (intNo>=7){
                        intNo=0;
                    }
                    hikaku();
                }
                break;
            case 3:
                if(str.equals("みず")){
                    setNextData();
                    intNo++;
                    if (intNo>=7){
                        intNo=0;
                    }
                }else{
                    intNo++;
                    if (intNo>=7){
                        intNo=0;
                    }
                    hikaku();
                }
                break;
            default:
                setNextData();
                intNo++;
                if (intNo>=7){
                    intNo=0;
                }
        }

        imageVi();

    }

    public void backClick(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
