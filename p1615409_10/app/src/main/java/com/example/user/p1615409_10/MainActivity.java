package com.example.user.p1615409_10;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    Button set;
    TextView num,text;
    boolean setTrue = true;
    ArrayList<Double> latitude;
    ArrayList<Double> longitude;
    double dist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set = (Button)findViewById(R.id.setClick);

        num = (TextView)findViewById(R.id.movingDistanceNum);
        text = (TextView) findViewById(R.id.movingDistanceText);

        }

    public void onClick(View v) {
        ActivityCompat.requestPermissions( MainActivity.this,  new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
        int permissionCamera = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCamera == PackageManager.PERMISSION_GRANTED) {
            if (setTrue) {
                text.setVisibility(View.INVISIBLE);
                num.setVisibility(View.INVISIBLE);
                latitude = new ArrayList<Double>();
                longitude = new ArrayList<Double>();
                setTrue = false;
                set.setText("측정 종료");
                LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
                LocationListener locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        longitude.add(location.getLongitude());
                        latitude.add(location.getLatitude());
                    }
                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }
                    public void onProviderEnabled(String provider) {
                    }
                    public void onProviderDisabled(String provider) {
                    }
                };
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, locationListener);
            } else {
                setTrue = true;
                set.setText("측정 시작");
                dist = 0;
                for(int i = 0; i < latitude.size() - 1; i++) {
                    dist += distanceByDegree(latitude.get(i), longitude.get(i), latitude.get(i + 1), longitude.get(i + 1));
                    Log.e("latitude",Double.toString(latitude.get(i)));
                    Log.e("longitude",Double.toString(longitude.get(i)));

                }
                String distance = Double.toString(dist) + "km";
                text.setVisibility(View.VISIBLE);
                num.setText(distance);
                num.setVisibility(View.VISIBLE);

            }
        }
    }
    //두지점(위도,경도) 사이의 거리
    public double distanceByDegree(double _latitude1, double _longitude1, double _latitude2, double _longitude2){
        double theta, dist;
        theta = _longitude1 - _longitude2;
        dist = Math.sin(degreeToRadian(_latitude1)) * Math.sin(degreeToRadian(_latitude2)) + Math.cos(degreeToRadian(_latitude1))
                * Math.cos(degreeToRadian(_latitude2)) * Math.cos(degreeToRadian(theta));
        dist = Math.acos(dist);
        dist = radianToDegree(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;    // 단위 mile 에서 km 변환.
        Log.e("distance",Double.toString(dist));
        return dist;
    }

    //degree->radian 변환
    public double degreeToRadian(double degree){
        return degree * Math.PI / 180.0;
    }

    //randian -> degree 변환
    public double radianToDegree(double radian){
        return radian * 180d / Math.PI;
    }

}
