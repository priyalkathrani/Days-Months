package com.example.days_and_months;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.days_and_months.COLOR.colorActivity;
import com.example.days_and_months.DAYS.dayActivity;
import com.example.days_and_months.MONTH.monthActivity;
import com.example.days_and_months.SEASON.seasonActivity;
import com.example.days_and_months.TIME.timeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView month = (TextView) findViewById(R.id.month_view);
        TextView day = (TextView) findViewById(R.id.days_view);
        TextView season = (TextView) findViewById(R.id.season_view);
        TextView color = (TextView) findViewById(R.id.color_view);
        TextView time = (TextView) findViewById(R.id.time_view);

        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, monthActivity.class);
                startActivity(i);
            }
        });

        day.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, dayActivity.class);
                startActivity(i);
            }
        });

        season.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, seasonActivity.class);
                startActivity(i);
            }
        });

        color.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, colorActivity.class);
                startActivity(i);
            }
        });

        time.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, timeActivity.class);
                startActivity(i);
            }
        });
    }

    public void days_view(View view) {
        Intent i = new Intent(MainActivity.this, dayActivity.class);
    }
}