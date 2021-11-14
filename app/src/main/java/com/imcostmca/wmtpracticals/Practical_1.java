package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical_1 extends AppCompatActivity {

    Button btnPractical_1_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical1);

        btnPractical_1_3 = findViewById(R.id.btnPractical1_3);
        btnPractical_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_1_3.class));
            }
        });
    }
}