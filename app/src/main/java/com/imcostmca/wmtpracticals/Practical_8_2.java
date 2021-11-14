package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Practical_8_2 extends AppCompatActivity {

    ProgressBar loader;
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical82);

        btnStart= findViewById(R.id.btnStartLoading);
        loader = findViewById(R.id.loader);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loader.setVisibility(View.VISIBLE);
            }
        });
    }
}