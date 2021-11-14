package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical_8 extends AppCompatActivity {

    Button btnPractical8_1, btnPractical8_2, btnPractical8_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical8);

        btnPractical8_1 = findViewById(R.id.btnPractical8_1);
        btnPractical8_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Practical_8_1.class));
            }
        });

        btnPractical8_2 = findViewById(R.id.btnPractical8_2);
        btnPractical8_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Practical_8_2.class));
            }
        });

        btnPractical8_3 = findViewById(R.id.btnPractical8_3);
        btnPractical8_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Practical_8_3.class));
            }
        });
    }
}