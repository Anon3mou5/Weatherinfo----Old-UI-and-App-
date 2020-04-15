package com.example.weatherinfo;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class getdata extends AppCompatActivity implements Runnable {

    Context c;
    Activity a;
    getdata(Context c, Activity a) {
        this.c = c;
        this.a=a;
    }


    public void run() {

        a.runOnUiThread(new Runnable() {
            @Override
            public void run() {


                gpsavailable g = new gpsavailable();
                Location l = g.isgpsavailable(c, a);
                if (l == null) {
                    Log.d("Bullshit", "loc not available");
                    // ActivityCompat.requestPermissions(, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 3);
                } else {
                    final double lat = l.getLatitude();
                    final double lng = l.getLongitude();
                    requestmodel r = new requestmodel(l, c, null);
                }
            }
            });

    }

//    @Override
//    protected Void doInBackground(Void... params) {
//
//        gpsavailable g = new gpsavailable();
//        Location l = g.isgpsavailable(c);
//        if (l == null) {
//            Log.d("Bullshit", "loc not available");
//            // ActivityCompat.requestPermissions(, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 3);
//        } else {
//            final double lat = l.getLatitude();
//            final double lng = l.getLongitude();
//            requestmodel r = new requestmodel(l,c,null);
//    }
//        return null;

    }
