package com.example.android_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.android_crud.database.DatabaseOpenHelper;

public class MainActivity extends AppCompatActivity {
    EditText name,email,mobile;
    RadioGroup gender;
    RadioButton selectedGen;
    Button submit;
    Spinner spinner;
    DatabaseOpenHelper _dbhelper;
    SQLiteDatabase _db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.st_name);
        email = findViewById(R.id.st_email);
        mobile = findViewById(R.id.st_mobile);
        gender = findViewById(R.id.st_gender);
        submit = findViewById(R.id.st_submit);
        spinner = findViewById(R.id.spinner);
        _dbhelper = new DatabaseOpenHelper(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stName = name.getText().toString();
                String stEmail = email.getText().toString();
                String stMobile = mobile.getText().toString();
                int genId = gender.getCheckedRadioButtonId();
                selectedGen = findViewById(genId);
                String stGen = selectedGen.getText().toString();
                Log.d(null, "Student: name: "+stName+
                        " Email: "+stEmail+" Mobile: "+stMobile+" Gender: "+ stGen);


            }
        });
    }

    public void goProductPage(View view){
        Log.d(null, "goProductPage: "+"ok.........");
        Intent i = new Intent(this, ShowProduct.class);
        startActivity(i);
    }

    public void saveInSQLite(View view) {
        try {
            ContentValues values = new ContentValues();
            values.put("name", "Bodrul amin");
            values.put("rollno", "123");
            _db = _dbhelper.getWritableDatabase();
            long rs = _db.insert("students", null, values);
            if(rs != -1){
                System.out.println("Save successful");
            }else{
                System.out.println("Save failed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showdbdata(View view) {
        _db = _dbhelper.getReadableDatabase();
       Cursor cursor = _db.query("students", new String[]{"id", "name"}, null, null, null, null, null);
       while (cursor.moveToNext()){
           int id = cursor.getInt(0);
           String name = cursor.getString(1);

           System.out.println("Student: Id: "+ id+" Name: "+name);
       }
    }
}