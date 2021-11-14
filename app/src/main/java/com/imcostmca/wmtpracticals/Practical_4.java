package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical_4 extends AppCompatActivity {


    Button btnPractical4_1, btnPractical4_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical4);

        btnPractical4_1 = findViewById(R.id.btnPractical4_1);
        btnPractical4_2 = findViewById(R.id.btnPractical4_2);

        btnPractical4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_4_1.class));
            }
        });
        btnPractical4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_4_2.class));
            }
        });
    }
}