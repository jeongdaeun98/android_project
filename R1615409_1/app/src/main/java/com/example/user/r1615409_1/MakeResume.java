package com.example.user.r1615409_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MakeResume extends AppCompatActivity {
    int image;
    String first,second,third,fourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_resume);
        Intent dataIntent = getIntent();
        image = dataIntent.getIntExtra("IMG",0);
        first = dataIntent.getStringExtra("FIR");
        second = dataIntent.getStringExtra("SEC");
        third = dataIntent.getStringExtra("THD");
        fourth = dataIntent.getStringExtra("FOUR");

        TextView firstresume = findViewById(R.id.firstresume);
        TextView secondresume = findViewById(R.id.secondresume);
        TextView thirdresume = findViewById(R.id.thirdresume);
        TextView fourthresume = findViewById(R.id.fourthresume);
        ImageView resumeimage = findViewById(R.id.resumeimage);
        if(image != 0){
            resumeimage.setImageResource(image);
        }
        firstresume.setText(first);
        secondresume.setText(second);
        thirdresume.setText(third);
        fourthresume.setText(fourth);

    }

    public void onClick(View v){
        Intent intent = new Intent(MakeResume.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
