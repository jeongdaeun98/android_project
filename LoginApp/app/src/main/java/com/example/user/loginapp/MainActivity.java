package com.example.user.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,id,password,onepassword;
    Button signin,cancel;
    String pwdstring,idstring,namestring,onepwdstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = findViewById(R.id.name_edit);
        id = findViewById(R.id.id_edit);
        password = findViewById(R.id.password_edit);
        onepassword = findViewById(R.id.password_one_edit);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v){
       idstring  = id.getText().toString();

    }
    public void signin(View v){
        pwdstring = password.getText().toString();
        onepwdstring = onepassword.getText().toString();
        if(pwdstring != onepwdstring){

        }


    }
    public void signcancel(View v){

    }
}
