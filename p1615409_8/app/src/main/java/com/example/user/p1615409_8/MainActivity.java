package com.example.user.p1615409_8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v) {

        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        finish();
    }
    public void add(View v){
               Intent intent = new Intent(this, AddActivity.class);
               startActivity(intent);
               finish();
       }
}
