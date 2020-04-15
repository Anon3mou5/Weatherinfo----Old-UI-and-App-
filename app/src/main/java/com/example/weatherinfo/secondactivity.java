package com.example.weatherinfo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class secondactivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterintro);
        TextView pl= findViewById(R.id.Place);
        pl.setText(shopwmodel.city);
        TextView deg= findViewById(R.id.degree);
        String str= new String(shopwmodel.degree);
        deg.setText(str.substring(0,2)+"°");
        TextView hum= findViewById(R.id.hum1);
        hum.setText(shopwmodel.hum);
        TextView pres= findViewById(R.id.pres1);
        pres.setText(shopwmodel.pres);
        TextView reel= findViewById(R.id.reel1);
        reel.setText(shopwmodel.feels);
        TextView wind= findViewById(R.id.wind1);
        wind.setText(shopwmodel.wind);
        TextView  cond= findViewById(R.id.condition);
        cond.setText(shopwmodel.cond);

        TextView  descr= findViewById(R.id.textView4);
        String sty=new String(shopwmodel.desc);
        String y=sty.substring(0,1);
        descr.setText(y.toUpperCase()+sty.substring(1));


    }
}