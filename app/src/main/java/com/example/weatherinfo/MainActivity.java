package com.example.weatherinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import android.Manifest;
import java.lang.Thread;
import java.util.Timer;
import java.util.TimerTask;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Location l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 v = findViewById(R.id.viewPager);
        v.setAdapter(new second(getApplicationContext(), R.layout.s));
        Log.d("NULL", "idc");
        ImageButton b = findViewById((R.id.button_0));
        String CITY;
        final TextView t1 = findViewById(R.id.textView2);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CITY = extras.getString("city");
            if (CITY != null) {

                new requestmodel(null, getApplicationContext(), CITY);
                new Thread2(t1).start();

            }
        }

        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     gpsavailable g = new gpsavailable();
                                     l = g.isgpsavailable(getApplicationContext());
                                     if (l == null) {
                                         Log.d("Bullshit", "loc not available");
                                         ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 3);
                                     } else {
                                         final double lat = l.getLatitude();
                                         final double lng = l.getLongitude();
//          t1.setText("\n Latitude:" + lat + "\n Longitude:" + lng);
                                         new requestmodel(l, getApplicationContext(), null);
                                         new Thread2(t1).start();
                                     }
//                                            if (shopwmodel.city == null) {
//                                                  t1.setText("Fetching");
//                                             //Toast.makeText(getApplicationContext(), "Fetching", Toast.LENGTH_SHORT).show();
//                                             try {
//                                                 Thread.currentThread().sleep(5000);
//                                                  }
//                                             catch (InterruptedException e) {
//                                                 e.printStackTrace();
//                                                 }
//                                             }
//                                             t1.setText("" + shopwmodel.city + "\n\n" + shopwmodel.degree + "^\n\nHumidity:" + shopwmodel.hum);
//                                             shopwmodel.city=null;
                                 }

                             }
        );

        ImageView b1 = findViewById(R.id.imageView2);
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent t = new Intent(getApplicationContext(), activity2.class);
                                      startActivity(t);
                                  }
                              }
        );
        Timer t = new Timer();
        t.scheduleAtFixedRate(new Mytimer(), 2000, 4000);
    }

    //    void simple() {
//        gpsavailable g = new gpsavailable();
//        l = g.isgpsavailable(getApplicationContext());
//        if (l == null) {
//            Log.d("Bullshit", "loc not available");
//            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 3);
//        }
//        else {
//            final double lat = l.getLatitude();
//            final double lng = l.getLongitude();
////          t1.setText("\n Latitude:" + lat + "\n Longitude:" + lng);
//            new Thread2(l,getApplicationContext(),null).start();
//        }
//    }

    public class Mytimer extends TimerTask {
        public void run() {
            ViewPager2 v = findViewById(R.id.viewPager);
            if (v.getCurrentItem() == 0) {
                v.setCurrentItem(1);
            } else if (v.getCurrentItem() == 1) {
                v.setCurrentItem(2);
            } else if (v.getCurrentItem() == 2) {
                v.setCurrentItem(3);
            } else if (v.getCurrentItem() == 3) {
                v.setCurrentItem(0);
            } else {
                v.setCurrentItem(0);
            }
        }
    }
}



