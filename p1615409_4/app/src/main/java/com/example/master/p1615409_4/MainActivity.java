package com.example.master.p1615409_4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    ListView list;
    String[] studies = {
            "의류학과",
            "컴퓨터과학전공",
            "무용과",
            "식품영양학과",
            "역사문화학과",
            "it학과",
            "한국어문학부",
            "수학과",
            "응용물리학과",
            "통계학과"
    };
    String[] english_studies = {
            "CLOTHING & TEXTILES",
            "COMPUTER SCIENCE",
            "DANCE",
            "FOOD & NUTRITION",
            "HISTORY & CULTURE",
            "IT ENGINEERING",
            "KOREAN LANGUAGE & LITERATURE",
            "MATHEMATICS",
            "APPLIED PHYSICS",
            "STATISTICS"
    };
    Integer[] images = {
            R.mipmap.cloth,
            R.mipmap.computer,
            R.mipmap.dance,
            R.mipmap.food,
            R.mipmap.history,
            R.mipmap.it,
            R.mipmap.korean,
            R.mipmap.math,
            R.mipmap.physics,
            R.mipmap.statistics,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomList adapter = new
                CustomList(MainActivity.this);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getBaseContext(), studies[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }
    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context ) {
            super(context, R.layout.listitem, studies);
            this.context = context;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.listitem, null, true);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
            TextView study = (TextView) rowView.findViewById(R.id.study);
            TextView english = (TextView) rowView.findViewById(R.id.english_study);
            TextView professor = (TextView) rowView.findViewById(R.id.professor);
            TextView year = (TextView) rowView.findViewById(R.id.year);

            study.setText("학과명:"+studies[position]);
            english.setText("영문명:"+english_studies[position]);
            imageView.setImageResource(images[position]);
            professor.setText("20"+"명");
            year.setText(1930+position+"년");
            return rowView;
        }
    }

}
