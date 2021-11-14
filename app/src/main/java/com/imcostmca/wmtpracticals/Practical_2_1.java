package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sdsmdg.tastytoast.TastyToast;

public class Practical_2_1 extends AppCompatActivity {

    Button btnBack;

    @Override
    public void onBackPressed() {
        TastyToast.makeText(getApplicationContext(), "Back Button Pressed", TastyToast.LENGTH_LONG, TastyToast.ERROR);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical21);
        btnBack = findViewById(R.id.btnBack);
        TastyToast.makeText(getApplicationContext(), "onCreate Event", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Practical_2_1.this, Practical_2.class));
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        TastyToast.makeText(getApplicationContext(), "onStart Event", TastyToast.LENGTH_LONG, TastyToast.WARNING);
    }

    @Override
    protected void onPause() {
        super.onPause();
        TastyToast.makeText(getApplicationContext(), "onPause Event", TastyToast.LENGTH_LONG, TastyToast.DEFAULT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TastyToast.makeText(getApplicationContext(), "onResume Event", TastyToast.LENGTH_LONG, TastyToast.INFO);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        TastyToast.makeText(getApplicationContext(), "onRestart Event", TastyToast.LENGTH_LONG, TastyToast.CONFUSING);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TastyToast.makeText(getApplicationContext(), "onDestroy Event", TastyToast.LENGTH_LONG, TastyToast.WARNING);
    }
}