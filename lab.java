package com.example.labtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b,insert,delete,display;
    LocationManager lm;
    LocationListener ls;
       EditText address,name,id,age;
    Database db;
    AlertDialog.Builder builder;
   public  String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new Database(this);
        builder = new AlertDialog.Builder(this);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.editText);
        address=(EditText)findViewById((R.id.editText4)) ;
        id=(EditText)findViewById(R.id.editText2);
        age=(EditText)findViewById(R.id.editText3);
        b = (Button) findViewById(R.id.button);
        insert= (Button) findViewById(R.id.button2);
        delete = (Button) findViewById(R.id.button3);
        display = (Button) findViewById(R.id.button4);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.insert_data(name.getText().toString(),Integer.parseInt(id.getText().toString()),Integer.parseInt(age.getText().toString()),s);
                Toast.makeText(MainActivity.this,"inserted",Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button3) {
                    db.delete_data(name.getText().toString());
                    Toast.makeText(MainActivity.this,"Deleted",Toast.LENGTH_SHORT).show();
                }}
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer b = (StringBuffer) db.display_data();
               // Toast.makeText(MainActivity.this,"Display status "+ b.toString(),Toast.LENGTH_LONG).show();

                builder.setMessage(b.toString()) .setTitle("PERSONAL INFORMATION")
                        .setCancelable(true);
               builder.show();

                //Setting message manually and performing action on button click




            }

        });


        lm=(LocationManager)getSystemService(LOCATION_SERVICE);
        ls = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                s = " Location : latidtude: " + location.getLatitude() + "- longitude: " + location.getLongitude();
                address.setText(s);
                //Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }
            @Override
            public void onProviderEnabled(String provider) {
            }
            @Override
            public void onProviderDisabled(String provider) {
                Intent i= new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i); }};
        cf_button();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case 10: cf_button();break;
            default:break; }
    }
    public void cf_button() {
        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            // TODO: Consider calling

            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.INTERNET},10);
            }

            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, ls);

            }
        });

    }

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
Database.java


package com.example.labtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public  static final String DATABASE_NAME="Details.db";
    public  static final String table_name="t_table";
    public  static final String COL1="ID";
    public  static final String COL2="Name";
    public  static final String COL3="Age";
    public  static final String COL4="Address";
    SQLiteDatabase db;







    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_query= "create table "+ table_name + " (ID INTEGER , Name TEXT, Age INTEGER, Address TEXT)";
        db.execSQL(sql_query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ table_name);
        onCreate(db);

    }

    public void insert_data(String name,int id,int age,String add){
       // String query = " INSERT INTO t_table VALUES ("+id+"' "+name+" ', "+age+",'"+add+"' );";
        //db.execSQL(query);
        ContentValues cv = new ContentValues();
        cv.put(COL1,id);
        cv.put(COL2,name);
        cv.put(COL3,age);
        cv.put(COL4,add);
        db.insert(table_name,null,cv);

    }

    public void delete_data(String name){
        String query="DELETE FROM t_table WHERE Name='"+name+"';";
        db.execSQL(query);
    }
    public StringBuffer display_data() {
        StringBuffer buffer= new StringBuffer();

        Cursor c = db.rawQuery("SELECT * FROM t_table", null);
        if(c.getCount()==0) {
            buffer.append("Empty");
            //show message
           // Toast.makeText(getBaseContext(),"NOYHING IS THERE",Toast.LENGTH_SHORT).show();

        }

        while (c.moveToNext()){
            buffer.append("ID:"+c.getString(c.getColumnIndex("ID"))+"\n");
            buffer.append("NAME:"+c.getString(c.getColumnIndex("Name"))+"\n");
            buffer.append("AGE:"+c.getString(c.getColumnIndex("Age"))+"\n"+"\n");
            buffer.append("ADDRESS"+c.getString(c.getColumnIndex("Address"))+"\n"+"\n");
        }
        return buffer;

    }

}

