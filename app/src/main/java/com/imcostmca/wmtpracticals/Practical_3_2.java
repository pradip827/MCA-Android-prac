package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sdsmdg.tastytoast.TastyToast;

public class Practical_3_2 extends AppCompatActivity {

    ListView lstView;
    String[] cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical32);

        lstView = findViewById(R.id.lstCities);
        cities = getResources().getStringArray(R.array.cities);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, cities);
        lstView.setAdapter(adapter);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TastyToast.makeText(getApplicationContext(), cities[i], TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
            }
        });

        lstView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                TastyToast.makeText(getApplicationContext(), "Long Click Event", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                return false;
            }
        });
    }
}