package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    //Declaration of Buttons
    Button btnPractical1, btnPractical2, btnPractical3, btnPractical4, btnPractical5, btnPractical6, btnPractical7, btnPractical8;
    Button btnPractical9, btnPractical10,btnPractical11,btnPractical12,btnPractical13,btnPractical14;
    String data = "";

    AlertDialog.Builder builder;

    SharedPreferences sharedPreferences;

    @Override
    public void onBackPressed() {
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Do You Want To Close This App?")
                .setCancelable(false)
                .setTitle(R.string.app_name)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        sharedPreferences = getSharedPreferences("MyPreference", MODE_PRIVATE);

        if (!sharedPreferences.contains("Name")) {
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
        }

        //Define/Initialize the button 1
        btnPractical1 = findViewById(R.id.btnPractical1);
        btnPractical1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_1.class));
            }
        });
        btnPractical2 = findViewById(R.id.btnPractical2);
        btnPractical2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Practical_2.class));

            }
        });
        btnPractical3 = findViewById(R.id.btnPractical3);
        btnPractical3.setOnClickListener(this);

        btnPractical4 = findViewById(R.id.btnPractical4);
        btnPractical4.setOnClickListener(this);

        btnPractical5 = findViewById(R.id.btnPractical5);
        btnPractical5.setOnClickListener(this);

        btnPractical6 = findViewById(R.id.btnPractical6);
        btnPractical6.setOnClickListener(this);

        btnPractical7 = findViewById(R.id.btnPractical7);
        btnPractical7.setOnClickListener(this);

        btnPractical8 = findViewById(R.id.btnPractical8);
        btnPractical8.setOnClickListener(this);

        btnPractical9 = findViewById(R.id.btnPractical9);
        btnPractical9.setOnClickListener(this);

        btnPractical10 = findViewById(R.id.btnPractical10);
        btnPractical10.setOnClickListener(this);

        btnPractical11 = findViewById(R.id.btnPractical11);
        btnPractical11.setOnClickListener(this);


        btnPractical12 = findViewById(R.id.btnPractical12);
        btnPractical12.setOnClickListener(this);

        btnPractical13 = findViewById(R.id.btnPractical13);
        btnPractical13.setOnClickListener(this);

        btnPractical14 = findViewById(R.id.btnPractical14);
        btnPractical14.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPractical3:
                Intent intent = new Intent(getApplicationContext(), Practical_3.class);
                startActivity(intent);
                break;

            case R.id.btnPractical4:
                startActivity(new Intent(getApplicationContext(), Practical_4.class));
                break;

            case R.id.btnPractical5:
                startActivity(new Intent(getApplicationContext(), Practical_5.class));
                break;

            case R.id.btnPractical6:
                startActivity(new Intent(getApplicationContext(), Practical_6.class));
                break;

            case R.id.btnPractical7:
                startActivity(new Intent(getApplicationContext(), Practical_7.class));
                break;

            case R.id.btnPractical8:
                startActivity(new Intent(getApplicationContext(), Practical_8.class));
                break;

            case R.id.btnPractical9:
                startActivity(new Intent(getApplicationContext(), Practical_9.class));
                break;

            case R.id.btnPractical10:
                startActivity(new Intent(getApplicationContext(), Practical_10.class));
                break;

            case R.id.btnPractical11:
                startActivity(new Intent(getApplicationContext(), Practical_11.class));
                break;

            case R.id.btnPractical12:
                startActivity(new Intent(getApplicationContext(), Practical_12.class));
                break;

            case R.id.btnPractical13:
                startActivity(new Intent(getApplicationContext(), Practical_13.class));
                break;

            case R.id.btnPractical14:
                startActivity(new Intent(getApplicationContext(), Practical_14.class));
                break;
        }
    }
}