package com.example.weatherinfo;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class shopwmodel {
    static String city=null;
    static String degree=null;
    static String hum=null;
    static String pres;
    static String wind;
    static String cond;
    static String desc;
    static String feels;
    static String visibility;

;
    public static void shopwmodels(JSONObject o) throws JSONException {
        city = o.getString("name");
        JSONObject j = new JSONObject(o.toString());
        JSONObject q =j.getJSONObject("main");
        JSONArray wq=j.getJSONArray("weather");
        JSONObject wi=j.getJSONObject("wind");

//        for (int i = 0; i < wq.length(); i++) {
//            JSONObject jsonobject = wi.getJSONObject(i);
//            String name = jsonobject.getString("name");
//            String url = jsonobject.getString("url");
//        }

        JSONObject w=wq.getJSONObject(0);

        Object z=w.get("main");
        cond=z.toString();
        Log.d("cond",z.toString());
        Object x= w.get("description");
        desc=x.toString();
        Log.d("nested",q.toString());
        Object t = q.get("temp");
        Log.d("temp",t.toString());
        Object tz=q.get("pressure");
        Object t1=wi.get("speed");
        pres=tz.toString();
        Log.d("speed",t1.toString());
        wind=t1.toString();
        //System.out.println(t);
        Log.d("result",t.toString());
        Object h=q.get("humidity");
        degree= t.toString();
        hum = h.toString();
        Object tx=q.get("feels_like");
        feels=tx.toString();
        visibility=q.get("visibility").toString();

    }
}

