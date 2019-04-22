package com.example.devicelocation;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {

    FusedLocationProviderClient client;
    LocationRequest request;
    LocationCallback callback;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDeviceLocation();
    }

    public double getDeviceLocation(){
        client = LocationServices.getFusedLocationProviderClient(this);
        request = new LocationRequest().setPriority(LocationRequest
                .PRIORITY_HIGH_ACCURACY)
                .setInterval(3000)
                .setFastestInterval(1000);
        callback = new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                for (Location location : locationResult.getLocations()){
                    latitude = location.getLatitude();
                    longitude = location.getLatitude();

                    Toast.makeText(MainActivity.this, String.valueOf(latitude)+" "+String.valueOf(longitude),
                            Toast.LENGTH_SHORT).show();
                }
            }
        };

        return 0.0d;
    }
}
