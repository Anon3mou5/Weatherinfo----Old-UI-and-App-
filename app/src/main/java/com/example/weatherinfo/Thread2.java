package com.example.weatherinfo;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.widget.TextView;

public class Thread2 extends Thread {
    TextView t1;
    String CITY;
    Thread2(TextView t1)
    {
        this.t1=t1;

    }
    public void run()
    {
        t1.setText("Fetching");
        try {
            Thread.currentThread().sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(shopwmodel.city=="999")
        {
            t1.setText("Location Error:Not a Valid Location");
            return;
        }
//             if (shopwmodel.city == null) {
//            //Toast.makeText(getApplicationContext(), "Fetching", Toast.LENGTH_SHORT).show();
//            t1.setText("Fetching");


        t1.setText("" + shopwmodel.city + "\n\n" + shopwmodel.degree + "*\n\nHumidity:" + shopwmodel.hum);
        shopwmodel.city=null;
    }
}
