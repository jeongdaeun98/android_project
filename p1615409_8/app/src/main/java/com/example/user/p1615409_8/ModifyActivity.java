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

public class ModifyActivity extends AppCompatActivity {

    EditText name,phone,birth;
    DBHelper helper;
    SQLiteDatabase db;
    Intent intent;
    Cursor cursor;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = helper.getReadableDatabase();
        }
        name = findViewById(R.id.name_edit);
        phone = findViewById(R.id.phone_edit);
        birth = findViewById(R.id.birth_edit);
        intent = getIntent();
        id = intent.getIntExtra("id",-1);
        cursor = db.rawQuery("SELECT * FROM contacts WHERE _id = '"+id+"';", null);
        cursor.moveToFirst();
        name.setText(cursor.getString(1));
        phone.setText(cursor.getString(2));
        birth.setText(cursor.getString(3));

    }

    public void delete(View v){
        db.execSQL("DELETE FROM contacts  WHERE _id = '"+id+"';");
        intent = new Intent(this,ListActivity.class);
        startActivity(intent);
        finish();
    }
    public void modify(View v){
        String nastr = name.getText().toString();
        String phstr = phone.getText().toString();
        String birstr = birth.getText().toString();
        db.execSQL("UPDATE contacts SET name = '"+ nastr +"', phone = '"+phstr+"', birth = '"+birstr+"' WHERE _id = '"+id+"';");
        intent= new Intent(this,ListActivity.class);
        startActivity(intent);
        finish();
    }



}
