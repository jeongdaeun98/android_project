package com.example.user.r1615409_1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    int image;
    String first,second,third,fourth;
    SharedPreferences appData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appData = getSharedPreferences("appData", Activity.MODE_PRIVATE);
        datasave();
        load();



    }
    public void onClick(View v){
        int id = v.getId();
        switch(id){
            case R.id.edubutton:
                intent = new Intent(MainActivity.this, EduInput.class);
                startActivity(intent);
                finish();
                break;
            case R.id.resumebutton:
                intent = new Intent(MainActivity.this, MakeResume.class);
                intent.putExtra("IMG", image);
                intent.putExtra("FIR", first);
                intent.putExtra("SEC", second);
                intent.putExtra("THD", third);
                intent.putExtra("FOUR", fourth);
                startActivity(intent);
                finish();
                break;
            case R.id.picturebutton:
                intent = new Intent(MainActivity.this, PictureSelect.class);
                startActivity(intent);
                finish();
                break;

        }
    }
    private void load() {
        image = appData.getInt("IMG", 0);
        first = appData.getString("first", "");
        second = appData.getString("second","");
        third = appData.getString("third","");
        fourth = appData.getString("fourth","");
    }
    private void datasave() {
        SharedPreferences.Editor editor = appData.edit();
        Intent dataIntent = getIntent();
        if(dataIntent.getIntExtra("IMG",0) != 0)
            editor.putInt("IMG", dataIntent.getIntExtra("IMG", 0));
        if(dataIntent.getStringExtra("FIR") != null)
            editor.putString("first",dataIntent.getStringExtra("FIR"));
        if(dataIntent.getStringExtra("SEC") != null)
            editor.putString("second",dataIntent.getStringExtra("SEC"));
        if(dataIntent.getStringExtra("THD") != null)
            editor.putString("third",dataIntent.getStringExtra("THD"));
        if(dataIntent.getStringExtra("FOUR") != null)
            editor.putString("fourth",dataIntent.getStringExtra("FOUR"));
        editor.apply();
    }

}
