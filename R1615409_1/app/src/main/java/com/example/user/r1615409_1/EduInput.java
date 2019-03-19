package com.example.user.r1615409_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EduInput extends AppCompatActivity {

    int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edu_input);

    }

    public void onClick(View v){
        EditText first = findViewById(R.id.firstinput);
        EditText second = findViewById(R.id.secondinput);
        EditText third = findViewById(R.id.thirdinput);
        EditText fourth = findViewById(R.id.fourthinput);
        Intent intent = new Intent(EduInput.this,MainActivity.class);
        intent.putExtra("FIR",first.getText().toString());
        intent.putExtra("SEC",second.getText().toString());
        intent.putExtra("THD",third.getText().toString());
        intent.putExtra("FOUR",fourth.getText().toString());
        startActivity(intent);
        finish();
    }
}
