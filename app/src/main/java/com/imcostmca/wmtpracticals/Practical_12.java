package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical_12 extends AppCompatActivity {

    Button btnCat1, btnCat2, btnCat3, btnCat4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical12);

        btnCat1 = findViewById(R.id.btnCat1);
        btnCat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Practical_12_1.class);
                intent.putExtra("nID",1);
                startActivity(intent);
            }
        });

        btnCat2 = findViewById(R.id.btnCat2);
        btnCat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Practical_12_1.class);
                intent.putExtra("nID",2);
                startActivity(intent);
            }
        });
        btnCat3 = findViewById(R.id.btnCat3);
        btnCat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Practical_12_1.class);
                intent.putExtra("nID",3);
                startActivity(intent);
            }
        });

        btnCat4 = findViewById(R.id.btnCat4);
        btnCat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Practical_12_1.class);
                intent.putExtra("nID",4);
                startActivity(intent);
            }
        });
    }
}