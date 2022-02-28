package com.example.android_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ShowProduct extends AppCompatActivity {
    ListView listView;
    String[] arr = {"Amina","Mehedi", "Rakib", "Sakib", "Rabeya", "Yunus", "Khalilullah", "NBRS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);
        listView = findViewById(R.id.product_list);

        ArrayAdapter<String> names = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arr);
        listView.setAdapter(names);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = arr[i];
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_LONG).show();
            }
        });
    }
}