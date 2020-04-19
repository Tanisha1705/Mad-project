package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Authentication extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        final DatabaseHelper db;
        db= new DatabaseHelper(this);
         final EditText entry=(EditText) findViewById(R.id.editText);
        final EditText create=(EditText)findViewById(R.id.editText2);
        final EditText name=(EditText)findViewById(R.id.editText3);
        Button login=(Button) findViewById(R.id.button);
         Button insert=(Button) findViewById(R.id.button2);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result=  db.check(Integer.parseInt(entry.getText().toString()));
                Toast.makeText(Authentication.this,result,Toast.LENGTH_LONG).show();

            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insert(Integer.parseInt(create.getText().toString()));
                Toast.makeText(Authentication.this,"Code Created",Toast.LENGTH_LONG).show();
            }
        });

    }
}
