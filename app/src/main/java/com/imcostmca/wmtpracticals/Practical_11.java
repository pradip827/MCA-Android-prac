package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Practical_11 extends AppCompatActivity {


    Button btnPractical11_1, btnPractical11_2, btnPractical11_3, btnPractical11_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical11);

        btnPractical11_1 = findViewById(R.id.btnPractical11_1);
        btnPractical11_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Practical_11_1.class));
            }
        });
        btnPractical11_2 = findViewById(R.id.btnPractical11_2);
        btnPractical11_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Practical_11_2.class));
            }
        });
        btnPractical11_3 = findViewById(R.id.btnPractical11_3);

        btnPractical11_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:1800-22-3322"));//Phone No
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });

        btnPractical11_4 = findViewById(R.id.btnPractical11_4);
        btnPractical11_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Practical_11_4.class));
            }
        });
    }
}