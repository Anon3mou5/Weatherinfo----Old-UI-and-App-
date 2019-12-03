package com.example.weatherinfo;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class shopwmodel {
    static String city;
    static String degree;
    static String hum;

    public static void shopwmodels(JSONObject o) throws JSONException {
        city = o.getString("name");
        JSONObject j = new JSONObject(o.toString());
        JSONObject q =j.getJSONObject("main");
        Log.d("nested",q.toString());
        Object t = q.get("temp");
        //System.out.println(t);
        Log.d("result",t.toString());
        Object h=q.get("humidity");
        degree= t.toString();
        hum= h.toString();
    }
}

