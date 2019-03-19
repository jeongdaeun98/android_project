package com.example.user.p1615409_8;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class ListActivity extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        helper = new DBHelper(this);
        db = helper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM contacts", null);
        startManagingCursor(cursor);
        String[] from = {"name", "phone", "birth"};
        int[] to = {R.id.name, R.id.phone, R.id.birth};

        adapter = new SimpleCursorAdapter(this, R.layout.listitem, cursor, from, to,0);
        ListView list = (ListView) findViewById(R.id.listview);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Intent intent = new Intent(ListActivity.this, ModifyActivity.class);
                cursor.moveToPosition(position);
                int id = cursor.getInt(0);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });

    }
    public void onClick(View v){
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    
}




