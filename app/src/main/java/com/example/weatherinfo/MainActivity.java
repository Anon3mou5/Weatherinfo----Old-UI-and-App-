package com.example.weatherinfo;

import android.Manifest;
import android.animation.Animator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {
    Location l;
    final Activity act = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setTransparent(this);
        final Intent intent = new Intent(this,secondactivity.class);
        Thread t = new Thread(new getdata(getApplicationContext(),this));
        t.start();
        final LottieAnimationView j = findViewById(R.id.intro);
        j.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                final LottieAnimationView i = findViewById(R.id.sunny);
                final LottieAnimationView k = findViewById(R.id.cloudy);
                final LottieAnimationView l = findViewById(R.id.rainy);
//
//                if(shopwmodel.cond=="sunny") {
//                    i.setVisibility(View.VISIBLE);
//                    k.setVisibility(View.INVISIBLE);
//                    l.setVisibility(View.INVISIBLE);
//                }
//                else if(shopwmodel.cond=="cloudy"){
//                    i.setVisibility(View.VISIBLE);
//                    k.setVisibility(View.VISIBLE);
//                    l.setVisibility(View.INVISIBLE);
//                }
//
//                else
//                {
//                    i.setVisibility(View.INVISIBLE);
//                    k.setVisibility(View.INVISIBLE);
//                    l.setVisibility(View.VISIBLE);
//
//                }
//        i.setVisibility(View.VISIBLE);
//        k.setVisibility(View.INVISIBLE);
//        l.setVisibility(View.INVISIBLE);


        startActivity(intent,
                       ActivityOptions.makeSceneTransitionAnimation(act).toBundle());

                finish();

//                TextView pl= findViewById(R.id.Place);
//                pl.setText(shopwmodel.city);
//                TextView deg= findViewById(R.id.degree);
//                String str= new String(shopwmodel.degree);
//                deg.setText(str.substring(0,2)+"°");
//                TextView hum= findViewById(R.id.hum1);
//                hum.setText(shopwmodel.hum);
//                TextView pres= findViewById(R.id.pres1);
//                pres.setText(shopwmodel.pres);
//                TextView reel= findViewById(R.id.reel1);
//                reel.setText(shopwmodel.feels);
//                TextView wind= findViewById(R.id.wind1);
//                wind.setText(shopwmodel.wind);
//                TextView  cond= findViewById(R.id.condition);
//                cond.setText(shopwmodel.cond);
//
//                TextView  descr= findViewById(R.id.textView4);
//                String sty=new String(shopwmodel.desc);
//                String y=sty.substring(0,1);
//                descr.setText(y.toUpperCase()+sty.substring(1));




            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

       // getdata gtdt = new getdata(getApplicationContext());
     //   gtdt.execute();



//
       // ViewPager2 v = findViewById(R.id.viewPager)
       // Log.d("NULL", "idc");
//        ImageButton b = findViewById((R.id.button_0));
//        String CITY;
//      //  final TextView t1 = findViewById(R.id.textView2);
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            CITY = extras.getString("city");
//            if (CITY != null) {
//
//                new requestmodel(null, getApplicationContext(), CITY);
//          //      new Thread2(t1).start();
//
//            }
//        }
//
//        b.setOnClickListener(new View.OnClickListener() {
//                                 @Override
//                                 public void onClick(View v) {
//                                     gpsavailable g = new gpsavailable();
//                                     l = g.isgpsavailable(getApplicationContext());
//                                     if (l == null) {
//                                         Log.d("Bullshit", "loc not available");
//                                         ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 3);
//                                     } else {
//                                         final double lat = l.getLatitude();
//                                         final double lng = l.getLongitude();
////          t1.setText("\n Latitude:" + lat + "\n Longitude:" + lng);
//                                         new requestmodel(l, getApplicationContext(), null);
//                        //                 new Thread2(t1).start();
//                                     }
////                                            if (shopwmodel.city == null) {
////                                                  t1.setText("Fetching");
////                                             //Toast.makeText(getApplicationContext(), "Fetching", Toast.LENGTH_SHORT).show();
////                                             try {
////                                                 Thread.currentThread().sleep(5000);
////                                                  }
////                                             catch (InterruptedException e) {
////                                                 e.printStackTrace();
////                                                 }
////                                             }
////                                             t1.setText("" + shopwmodel.city + "\n\n" + shopwmodel.degree + "^\n\nHumidity:" + shopwmodel.hum);
////                                             shopwmodel.city=null;
//                                 }
//
//                             }
//        );

        //ImageView b1 = findViewById(R.id.imageView2);
       // b1.setOnClickListener(new View.OnClickListener() {
//                                  @Override
//                                  public void onClick(View v) {
//                                      Intent t = new Intent(getApplicationContext(), activity2.class);
//                                      startActivity(t);
//                                  }
//                              }
//        );
//        Timer t = new Timer();
//        t.scheduleAtFixedRate(new Mytimer(), 2000, 4000);
    }

        void simple() {
        gpsavailable g = new gpsavailable();
        l = g.isgpsavailable(getApplicationContext(),this);
        if (l == null) {
            Log.d("Bullshit", "loc not available");
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 3);
        }
        else {
            requestmodel r = new requestmodel(l,getApplicationContext(),null);
//          t1.setText("\n Latitude:" + lat + "\n Longitude:" + lng);
//            new Thread2(l,getApplicationContext(),null).start();
        }
    }




    ////////////////////////        Timer for synching photos

//    public class Mytimer extends TimerTask {
//        public void run() {
//            ViewPager2 v = findViewById(R.id.viewPager);
//            if (v.getCurrentItem() == 0) {
//                v.setCurrentItem(1);
//            } else if (v.getCurrentItem() == 1) {
//                v.setCurrentItem(2);
//            } else if (v.getCurrentItem() == 2) {
//                v.setCurrentItem(3);
//            } else if (v.getCurrentItem() == 3) {
//                v.setCurrentItem(0);
//            } else {
//                v.setCurrentItem(0);
//            }
//        }
//    }
}



