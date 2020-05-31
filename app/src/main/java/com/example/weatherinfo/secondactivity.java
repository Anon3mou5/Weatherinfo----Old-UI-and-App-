package com.example.weatherinfo;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jaeger.library.StatusBarUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class secondactivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTransparent(this);
        setContentView(R.layout.afterintro2);
        final Context c=getApplicationContext();

        settext();
        TextView  descr= findViewById(R.id.textView4);
        String sty=new String(shopwmodel.desc);
        String y=sty.substring(0,1);
        descr.setText(y.toUpperCase()+sty.substring(1));
        descr.animate().alpha(1).translationY(-140).setDuration(1200).setStartDelay(850);

        FloatingActionButton b = findViewById(R.id.floati);
        FloatingActionButton b2 = findViewById(R.id.floati2);
        b.animate().alpha(1).translationY(-140).setDuration(2000).setStartDelay(1650);


        final ConstraintLayout l4 = findViewById(R.id.constraintLayout4);
        final ConstraintLayout l = findViewById(R.id.constraintLayout);
        final ConstraintLayout l2 = findViewById(R.id.constraintLayout2);
        final ConstraintLayout l3 = findViewById(R.id.constraintLayout3);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int visible = 0;
                while (visible == 0) {
                    Rect scrollBound = new Rect();
                    ScrollView scroll = findViewById(R.id.scroll);
                    scroll.getHitRect(scrollBound);
                    // Log.d("SCROLL VALUE", scrollBound.toString());
                    if (l4.getLocalVisibleRect(scrollBound)) {
                        l2.animate().alpha(1).translationY(-140).setDuration(600).setStartDelay(200);
                        l.animate().alpha(1).translationY(-140).setDuration(1000).setStartDelay(550);
                        l3.animate().alpha(1).translationY(-140).setDuration(1400).setStartDelay(950);
                        l4.animate().alpha(1).translationY(-140).setDuration(1800).setStartDelay(1350);
                        visible = 1;
                        }
                    }
            }

        });
        t.start();
        final SwipeRefreshLayout swipe = findViewById(R.id.swipe_container);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Thread t = new Thread(new getdata(c, secondactivity.this));
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
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
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
                        });
                        swipe.setRefreshing(false);
                    }

                };
                g.start();


            }

        });

//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Thread t = new Thread(new getdata(c,secondactivity.this));
//                t.start();
//                Thread g = new Thread() {
//                    public void run() {
////                                while(shopwmodel.city==null)
////                                {
////                                    if(shopwmodel.city!=null)
////                                    {
////                                        break;
////                                    }
////                                }
//                        try {
//                            Log.d("waited", "300 seconds");
//                            this.sleep(1600);
//                        } catch (Exception e) {
//                            //Toast.makeText(secondactivity.this,"Exception caught",Toast.LENGTH_SHORT).show();
//                        }
////                                   //setContentView(R.layout.afterintro);
//                        if (shopwmodel.city == "999") {
//                            shopwmodel.city = "Not a city";
//                        }
//                        TextView pl = findViewById(R.id.Place);
//                        pl.setText(shopwmodel.city);
//                        Log.d("settext", "succesfull: " + shopwmodel.city);
//                        TextView deg = findViewById(R.id.degree);
//                        String str = new String(shopwmodel.degree);
//                        deg.setText(str.substring(0, 2) + "°");
//                        TextView hum = findViewById(R.id.hum1);
//                        hum.setText(shopwmodel.hum);
//                        TextView pres = findViewById(R.id.pres1);
//                        pres.setText(shopwmodel.pres);
//                        TextView reel = findViewById(R.id.reel1);
//                        reel.setText(shopwmodel.feels);
//                        TextView wind = findViewById(R.id.wind1);
//                        wind.setText(shopwmodel.wind);
//                        TextView cond = findViewById(R.id.condition);
//                        cond.setText(shopwmodel.cond);
//                        TextView descr = findViewById(R.id.textView4);
//                        String sty = new String(shopwmodel.desc);
//                        String y = sty.substring(0, 1);
//                        descr.setText(y.toUpperCase() + sty.substring(1));
//                        //shopwmodel.city=null;
//                    }
//                };
//                g.start();
//
//            }
//        });
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
                        Thread g = new Thread() {
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
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        settext();
                                    }
                                });

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

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        finish();
        return;
    }

    private boolean isViewVisible(View view) {
        Rect scrollBounds = new Rect();
        ScrollView scroll = findViewById(R.id.scroll);
        scroll.getDrawingRect(scrollBounds);
        float top = view.getY();
        float bottom = top + view.getHeight();

        if (scrollBounds.top < top && scrollBounds.bottom > bottom) {
            return true;
        } else {
            return false;
        }
    }

    void settext()
    {

        TextView pl= findViewById(R.id.Place);
        pl.setText(shopwmodel.city);
        pl.animate().alpha(1).translationY(-140).setDuration(500).setStartDelay(200);
        TextView deg= findViewById(R.id.degree);
        String str= new String(shopwmodel.degree);
        deg.setText(str.substring(0,2)+"°");
        deg.animate().alpha(1).translationY(-140).setDuration(1100).setStartDelay(750);
        TextView hum= findViewById(R.id.hum1);
        hum.setText(shopwmodel.hum);
        TextView pres= findViewById(R.id.pres1);
        pres.setText(shopwmodel.pres);
        TextView reel= findViewById(R.id.reel1);
        reel.setText(shopwmodel.feels);
        TextView wind= findViewById(R.id.wind1);
        wind.setText(shopwmodel.wind);
        TextView  cond= findViewById(R.id.condition);
        LottieAnimationView lv = findViewById(R.id.imageView);
        LottieAnimationView lv2 = findViewById(R.id.imageView2);
        LottieAnimationView lv3 = findViewById(R.id.imageView3);
        cond.setText(shopwmodel.cond);
        cond.animate().alpha(1).translationY(-140).setDuration(800).setStartDelay(450);
        if (shopwmodel.cond.toLowerCase().equals("clear")) {
            lv2.setVisibility(View.VISIBLE);
            lv.setVisibility(View.INVISIBLE);
            lv3.setVisibility(View.INVISIBLE);
        } else if (shopwmodel.cond.toLowerCase().equals("clouds")) {

            lv3.setVisibility(View.VISIBLE);
            lv.setVisibility(View.INVISIBLE);
            lv2.setVisibility(View.INVISIBLE);

        } else {
            lv.setVisibility(View.VISIBLE);
            lv2.setVisibility(View.INVISIBLE);
            lv3.setVisibility(View.INVISIBLE);

        }
        TextView  descr= findViewById(R.id.textView4);
        String sty=new String(shopwmodel.desc);
        String y=sty.substring(0,1);
        descr.setText(y.toUpperCase()+sty.substring(1));


        lv.animate().alpha(1).translationY(-140).setDuration(1400).setStartDelay(1050);
        lv2.animate().alpha(1).translationY(-140).setDuration(1400).setStartDelay(1050);
        lv3.animate().alpha(1).translationY(-140).setDuration(1400).setStartDelay(1050);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dayofweek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
        TextView day = findViewById(R.id.day);
        TextView time = findViewById(R.id.time);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String time3 = formatter.format(calendar.getTime());
        int hr = Integer.parseInt(time3.substring(0, 2));
        String mi = time3.substring(2);
        if (hr > 12) {
            time.setText(Integer.toString(hr - 12) + mi + " PM");
        } else if (hr == 12) {
            time.setText(Integer.toString(hr) + mi + " PM");
        } else if (hr == 0) {
            time.setText(Integer.toString(hr + 12) + mi + " AM");
        } else {
            time.setText(Integer.toString(hr) + mi + " AM");
        }
        time.animate().alpha(1).translationY(-140).setDuration(1700).setStartDelay(1350);
        day.setText(dayofweek);
        day.animate().alpha(1).translationY(-140).setDuration(1800).setStartDelay(1450);
    }

}