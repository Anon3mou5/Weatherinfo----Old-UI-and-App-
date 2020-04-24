package com.example.weatherinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class secondactivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context c=getApplicationContext();
        settext();
        TextView  descr= findViewById(R.id.textView4);
        String sty=new String(shopwmodel.desc);
        String y=sty.substring(0,1);
        descr.setText(y.toUpperCase()+sty.substring(1));

        FloatingActionButton b = findViewById(R.id.floati);
        FloatingActionButton b2 = findViewById(R.id.floati2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new getdata(c,secondactivity.this));
                t.start();
                Thread g = new Thread() {
                    public void run() {
//                                while(shopwmodel.city==null)
//                                {
//                                    if(shopwmodel.city!=null)
//                                    {
//                                        break;
//                                    }
//                                }
                        try {
                            Log.d("waited", "300 seconds");
                            this.sleep(1600);
                        } catch (Exception e) {
                            //Toast.makeText(secondactivity.this,"Exception caught",Toast.LENGTH_SHORT).show();
                        }
//                                   //setContentView(R.layout.afterintro);
                        if (shopwmodel.city == "999") {
                            shopwmodel.city = "Not a city";
                        }
                        TextView pl = findViewById(R.id.Place);
                        pl.setText(shopwmodel.city);
                        Log.d("settext", "succesfull: " + shopwmodel.city);
                        TextView deg = findViewById(R.id.degree);
                        String str = new String(shopwmodel.degree);
                        deg.setText(str.substring(0, 2) + "°");
                        TextView hum = findViewById(R.id.hum1);
                        hum.setText(shopwmodel.hum);
                        TextView pres = findViewById(R.id.pres1);
                        pres.setText(shopwmodel.pres);
                        TextView reel = findViewById(R.id.reel1);
                        reel.setText(shopwmodel.feels);
                        TextView wind = findViewById(R.id.wind1);
                        wind.setText(shopwmodel.wind);
                        TextView cond = findViewById(R.id.condition);
                        cond.setText(shopwmodel.cond);
                        TextView descr = findViewById(R.id.textView4);
                        String sty = new String(shopwmodel.desc);
                        String y = sty.substring(0, 1);
                        descr.setText(y.toUpperCase() + sty.substring(1));
                        //shopwmodel.city=null;
                    }
                };
                g.start();

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(secondactivity.this);
                View v2 = getLayoutInflater().inflate(R.layout.popup,null);
                final TextView city = v2.findViewById(R.id.textView5);
                FloatingActionButton b = v2.findViewById(R.id.floating_action_button);
                builder.setView(v2);
                final AlertDialog dialog= builder.create();
               dialog.show();
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(city.getText().toString().isEmpty())
                        {
                            Toast.makeText(secondactivity.this,"Please enter city name",Toast.LENGTH_SHORT).show();
                        }
                        requestmodel r = new requestmodel(null,secondactivity.this,city.getText().toString());
                        dialog.dismiss();
//                        try{
//                            this.wait(100);
//                        }
//                       catch (Exception e)
//                       {
//                           Toast.makeText(secondactivity.this,"Exception caught",Toast.LENGTH_SHORT).show();
//                       }
                        Thread g = new Thread(){
                            public void run()
                            {
//                                while(shopwmodel.city==null)
//                                {
//                                    if(shopwmodel.city!=null)
//                                    {
//                                        break;
//                                    }
//                                }
                                try {
                                    Log.d("waited","300 seconds");
                                    this.sleep(1600);
                                }
                                catch(Exception e)
                                {
                                    //Toast.makeText(secondactivity.this,"Exception caught",Toast.LENGTH_SHORT).show();
                                }
//                                   //setContentView(R.layout.afterintro);
                                    if(shopwmodel.city=="999")
                                    {
                                        shopwmodel.city="Not a city";
                                    }
                                    TextView pl= findViewById(R.id.Place);
                                    pl.setText(shopwmodel.city);
                                    Log.d("settext","succesfull: "+shopwmodel.city);
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
                                    //shopwmodel.city=null;
                            }
                        };
                        g.start();
                    }
                });
//
//              builder.setView(v2);
                dialog.show();
            }
        });


    }

    void settext()
    {
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
        //shopwmodel.city=null;
    }
}