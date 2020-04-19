package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
 Button mirror1,mirror2,mirror3,mirror4;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
/////
XML file
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#000000"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginLeft="32dp"
            android:layout_marginRight="32dp"
            android:layout_marginTop="32dp">

            <TextView
                android:id="@+id/dashboardname"
                android:text="MIRRORS AVAILABLE"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="24sp"
                android:textColor="#FFFFFF"></TextView>


        </RelativeLayout>

        <GridLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:columnOrderPreserved="false"
            android:alignmentMode="alignMargins"
            android:rowCount="6"
            android:columnCount="2">

            <androidx.cardview.widget.CardView
                app:cardBackgroundColor="#242424"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_columnWeight="1"
                android:layout_rowWeight="1"
                app:cardElevation="6dp"
                app:cardCornerRadius="12dp"
                android:layout_margin="12dp">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:gravity="center"
                    android:orientation="vertical"
                    android:padding="16dp">
                    <Button
                        android:layout_width="50sp"
                        android:layout_height="50sp"
                        android:id="@+id/b1"
                        android:background="@drawable/mirror"/>

                    <TextView
                        android:layout_marginTop="12dp"
                        android:textColor="#FFFFFF"
                        android:textSize="18dp"
                        android:text="Mirror 1"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"/>

                </LinearLayout>


            </androidx.cardview.widget.CardView>
            <androidx.cardview.widget.CardView
                app:cardBackgroundColor="#242424"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_columnWeight="1"
                android:layout_rowWeight="1"
                app:cardElevation="6dp"
                app:cardCornerRadius="12dp"
                android:layout_margin="12dp">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:gravity="center"
                    android:orientation="vertical"
                    android:padding="8dp">
                    <Button
                        android:layout_width="50sp"
                        android:layout_height="50sp"
                        android:id="@+id/b2"
                        android:background="@drawable/mirror"/>

                    <TextView
                        android:layout_marginTop="12dp"
                        android:textColor="#FFFFFF"
                        android:textSize="18dp"
                        android:text="Mirror 2"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"/>

                </LinearLayout>


            </androidx.cardview.widget.CardView>
            <androidx.cardview.widget.CardView
                app:cardBackgroundColor="#242424"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_columnWeight="1"
                android:layout_rowWeight="1"
                app:cardElevation="6dp"
                app:cardCornerRadius="12dp"
                android:layout_margin="12dp">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:gravity="center"
                    android:orientation="vertical"
                    android:padding="16dp">
                    <Button
                        android:layout_width="50sp"
                        android:layout_height="50sp"
                        android:id="@+id/b3"
                        android:background="@drawable/mirror"/>

                    <TextView
                        android:layout_marginTop="12dp"
                        android:textColor="#FFFFFF"
                        android:textSize="18dp"
                        android:text="Mirror 3"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"/>

                </LinearLayout>


            </androidx.cardview.widget.CardView>
            <androidx.cardview.widget.CardView
                app:cardBackgroundColor="#242424"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_columnWeight="1"
                android:layout_rowWeight="1"
                app:cardElevation="6dp"
                app:cardCornerRadius="12dp"
                android:layout_margin="12dp">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:gravity="center"
                    android:orientation="vertical"
                    android:padding="16dp">
                    <Button
                        android:layout_width="50sp"
                        android:layout_height="50sp"
                        android:id="@+id/b4"
                        android:background="@drawable/mirror"/>

                    <TextView
                        android:layout_marginTop="12dp"
                        android:textColor="#FFFFFF"
                        android:textSize="18dp"
                        android:text="Mirror 4"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"/>

                </LinearLayout>


            </androidx.cardview.widget.CardView>




        </GridLayout>


    </LinearLayout>








</ScrollView>


