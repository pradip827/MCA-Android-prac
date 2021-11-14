package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Practical_3_1 extends AppCompatActivity {

    Intent intent;
    TextView txtView;
    String data = "";
    float no = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical31);

        intent = getIntent();
        txtView = findViewById(R.id.txtContent);

        data = intent.getStringExtra("Msg");
        no = intent.getFloatExtra("No",0);
        txtView.setText(data + no);
    }
}