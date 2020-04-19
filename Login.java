package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Login extends AppCompatActivity {
 Button mirror1,mirror2,mirror3,mirror4;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mirror1=(Button)findViewById(R.id.b1);
     mirror2=(Button)findViewById(R.id.b2);
     mirror3=(Button)findViewById(R.id.b3);
     mirror4=(Button)findViewById(R.id.b4);

     mirror1.setOnClickListener((new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent m1 = new Intent(MainActivity.this,Authentication.class);

             startActivity(m1);
         }
     }));


     mirror2.setOnClickListener((new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent m2 = new Intent(MainActivity.this,Authentication.class);

             startActivity(m2);
         }
     }));

     mirror3.setOnClickListener((new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent m3 = new Intent(MainActivity.this,Authentication.class);

             startActivity(m3);
         }
     }));

     mirror4.setOnClickListener((new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent m4 = new Intent(MainActivity.this,Authentication.class);

             startActivity(m4);
         }
     }));

    }

}
