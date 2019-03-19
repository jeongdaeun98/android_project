package com.example.user.p1615409_8;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    EditText name,phone,birth;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();

        } catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }
        name = (EditText) findViewById(R.id.name_edit);
        phone = (EditText) findViewById(R.id.phone_edit);
        birth = (EditText)findViewById(R.id.birth_edit);

    }

    public void onClick(View target) {
        String names = name.getText().toString();
        String phones = phone.getText().toString();
        String births = birth.getText().toString();
        db.execSQL("INSERT INTO contacts (name,phone,birth) VALUES ('"+ names + "', '" + phones
                + "', '" + births + "');");
        name.setText("");
        phone.setText("");
        birth.setText("");
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
        finish();
    }



}
