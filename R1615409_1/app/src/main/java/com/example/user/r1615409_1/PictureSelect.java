package com.example.user.r1615409_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

public class PictureSelect extends AppCompatActivity {

    String first,second,third,fourth;

    int img[] = {R.mipmap.char1, R.mipmap.char2, R.mipmap.char3, R.mipmap.char4, R.mipmap.char5};
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_select);

        PictureAdapter adapter = new PictureAdapter(
                getApplicationContext(),R.layout.row, img);
        Gallery gallery = (Gallery)findViewById(R.id.gallery1);
        gallery.setAdapter(adapter);

        final ImageView iv = (ImageView)findViewById(R.id.imageView1);

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                       int position, long id) { // 선택되었을 때 콜백메서드
                iv.setImageResource(img[position]);
                pos = position;
            }

        });

    }
    public void onClick(View v){
        Intent intent = new Intent(PictureSelect.this, MainActivity.class);
        intent.putExtra("IMG",img[pos]);
        startActivity(intent);
        finish();
    }

}
