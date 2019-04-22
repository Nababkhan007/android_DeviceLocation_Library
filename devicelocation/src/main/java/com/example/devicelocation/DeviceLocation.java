package com.example.devicelocation;

import android.content.Context;
import android.location.Location;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class DeviceLocation {
    Context context;
    FusedLocationProviderClient client;
    LocationRequest request;
    LocationCallback callback;
    double latitude;
    double longitude;

    public double getDeviceLocation(){
        this.client = LocationServices.getFusedLocationProviderClient(this.context);
        this.request = new LocationRequest().setPriority(LocationRequest
                .PRIORITY_HIGH_ACCURACY)
                .setInterval(3000)
                .setFastestInterval(1000);
        this.callback = new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                for (Location location : locationResult.getLocations()){
                    latitude = location.getLatitude();
                    longitude = location.getLatitude();

                    Toast.makeText(context, String.valueOf(latitude)+" "+String.valueOf(longitude),
                            Toast.LENGTH_SHORT).show();
                }
            }
        };

        return 0;
    }
}

