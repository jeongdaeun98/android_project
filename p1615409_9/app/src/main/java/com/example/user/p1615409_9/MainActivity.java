package com.example.user.p1615409_9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radio;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radio = findViewById(R.id.radio);

    }
    public void onClick(View v){
        int id = radio.getCheckedRadioButtonId();
        intent = new Intent(MainActivity.this,MapsActivity.class);
        switch(id){
            case R.id.two:
                intent.putExtra("url","http://ws.bus.go.kr/api/rest/buspos/getBusPosByRtid?ServiceKey=VZk4EhfOFiAaRhqvId46im%2BuOcPd%2FzIiLaquayzXt6xEWy2G8n4hojoJnJel4KFwlDV5b5988PmYZZTx9mXWQw%3D%3D&busRouteId=100100522");
                startActivity(intent);
                finish();
                break;
            case R.id.four:
                intent.putExtra("url","http://ws.bus.go.kr/api/rest/buspos/getBusPosByRtid?ServiceKey=VZk4EhfOFiAaRhqvId46im%2BuOcPd%2FzIiLaquayzXt6xEWy2G8n4hojoJnJel4KFwlDV5b5988PmYZZTx9mXWQw%3D%3D&busRouteId=100100596");
                startActivity(intent);
                finish();
                break;
            case R.id.seven:
                intent.putExtra("url","http://ws.bus.go.kr/api/rest/buspos/getBusPosByRtid?ServiceKey=VZk4EhfOFiAaRhqvId46im%2BuOcPd%2FzIiLaquayzXt6xEWy2G8n4hojoJnJel4KFwlDV5b5988PmYZZTx9mXWQw%3D%3D&busRouteId=100100537");
                startActivity(intent);
                finish();
                break;
        }
    }

}
