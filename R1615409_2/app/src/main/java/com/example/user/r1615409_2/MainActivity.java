package com.example.user.r1615409_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    int radio;
    Intent intent;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup)findViewById(R.id.cast);
    }
    public void onClick(View v){
        radio = rg.getCheckedRadioButtonId();
        if(radio == R.id.namyoung) {
            intent = new Intent(this,NamyoungActivity.class);
            startActivity(intent);
            finish();
        }
        else if(radio == R.id.cheongpa){
            intent = new Intent(this,CheongpaActivity.class);
            startActivity(intent);
            finish();
        }
        else if(radio == R.id.samgak){
            intent = new Intent(this,SamgakActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
