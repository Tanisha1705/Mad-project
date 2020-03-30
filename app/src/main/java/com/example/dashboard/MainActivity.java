package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity  {
    public CardView newsfeed,notifications,calender,compliments,clock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsfeed = (CardView)findViewById(R.id.click_newsfeed);
        notifications=(CardView)findViewById(R.id.click_notify);
        calender = (CardView)findViewById(R.id.click_calender);
        clock = (CardView)findViewById(R.id.click_clock);
        compliments = (CardView)findViewById(R.id.click_compliments);

        newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_intent= new Intent(MainActivity.this,Newsfeed.class);
                startActivity(new_intent);
            }
        });

        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_intent1= new Intent(MainActivity.this,notifications.class);
                startActivity(new_intent1);
            }
        });
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_intent2= new Intent(MainActivity.this,calender.class);
                startActivity(new_intent2);
            }
        });
        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_intent3= new Intent(MainActivity.this,clock.class);
                startActivity(new_intent3);
            }
        });
        compliments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_intent4= new Intent(MainActivity.this,compliments.class);
                startActivity(new_intent4);
            }
        });




    }


}
