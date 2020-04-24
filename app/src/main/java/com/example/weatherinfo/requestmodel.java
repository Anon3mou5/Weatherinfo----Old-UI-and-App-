package com.example.weatherinfo;

import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.*;



import org.json.*;

import android.content.Context;

import cz.msebera.android.httpclient.Header;


public class requestmodel {
    Location l;
    Context c;
    String CITY;
    requestmodel(Location l, final Context c,String CITY) {
        this.l = l;
        this.c = c;
        this.CITY = CITY;
        String url = "https://openweathermap.org/data/2.5/weather?";
        String appid = "439d4b804bc8187953eb36d2a8c26a02";
        RequestParams params = new RequestParams();
        if (l != null && CITY==null) {
            double latt = l.getLatitude();
            double lng = l.getLongitude();
            Log.d("xyz", "Lat:" + latt);
            params.put("lat", latt);
            params.put("lon", lng);
            params.put("appid", appid);
        }
        if (CITY != null && l==null) {
            params.put("q", CITY);
            params.put("appid", appid);
            Log.d("CITY", CITY);
        }
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("CLIMA", "in SUCCESS");
                try {
                    shopwmodel.shopwmodels(response);
                } catch (Exception e) {

                }
                Log.d("Response", response.toString());
            }
            public void onFailure(int statusCode, Header[] headers,Throwable throw1, JSONObject response)
            {
                Log.d("CLIMA","FAILURE");
                shopwmodel.city="999";
            }
        });

    }
        }
