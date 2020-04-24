package com.example.weatherinfo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class gpsavailable extends AppCompatActivity {
    LocationManager mLocationManager;
    double lat, lng;
    private Location location;
    private long MIN_TIME_BW_UPDATES = 30000;
    private long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;

    public Location isgpsavailable(final Context context,Activity a) {

        Log.d("NULL", "here in gps");
        mLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // getting GPS status
        boolean isGPSEnabled = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        // getting network status
        boolean isNetworkEnabled = mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);


        if (!isGPSEnabled && !isNetworkEnabled) {

        } else {



            if (isNetworkEnabled) {
                Log.d("NULL", "here in net");
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(context, "Enable Internet in settings.", Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions(
                            this,
                            new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                            40
                    );
                }
                // First get location from Network Provider
                else {
                    Log.d("NULL", "net permission allowed");
                    mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, new LocationListener() {
                                @Override
                                public void onLocationChanged(Location location) {

                                }

                                @Override
                                public void onStatusChanged(String provider, int status, Bundle extras) {

                                }

                                @Override
                                public void onProviderEnabled(String provider) {

                                }

                                @Override
                                public void onProviderDisabled(String provider) {

                                    Toast.makeText(getApplicationContext(), "Disabled", Toast.LENGTH_SHORT);
                                }


                            }
                    );
                    Log.d("Network", "Network");
                    if (mLocationManager != null) {
                        location = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            lat = location.getLatitude();
                            lng = location.getLongitude();
                        }
                    }
                }
            }
            //get the location by gps
          /*  if (isGPSEnabled) {
                if (location == null) {
                    Log.d("NULL","here in gpsenhvhu");
                    if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(context, "First enable LOCATION ACCESS in settings.", Toast.LENGTH_LONG).show();
                    } else {

                        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, new LocationListener() {
                            @Override
                            public void onLocationChanged(Location location) {

                            }

                            @Override
                            public void onStatusChanged(String provider, int status, Bundle extras) {

                            }

                            @Override
                            public void onProviderEnabled(String provider) {

                            }

                            @Override
                            public void onProviderDisabled(String provider) {

                            }
                        });
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (mLocationManager != null) {
                            location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                Log.d("loc", "Received location");
                                lat = location.getLatitude();
                                lng = location.getLongitude();
                            }
                        }
                    }
                }
            }
        }
*/
        }
   if (location == null) {
            Log.d("NULL", "No location in gpsavailable");
        }
        return location;
    }
}

