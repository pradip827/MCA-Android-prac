package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical_2 extends AppCompatActivity {

    Button btnPractical2_1, btnPractical2_2, btnPractical3_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical2);

        btnPractical2_1 = findViewById(R.id.btnPractical2_1);
        btnPractical2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Practical_2.this, Practical_2_1.class));
                finish();
            }
        });

        btnPractical2_2 = findViewById(R.id.btnPractical2_2);
        btnPractical2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Practical_2.this, Practical_2_2.class));
                finish();
            }
        });
    }
}