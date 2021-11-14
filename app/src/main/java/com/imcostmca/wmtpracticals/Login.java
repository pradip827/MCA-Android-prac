package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sdsmdg.tastytoast.TastyToast;

public class Login extends AppCompatActivity {

    Button btnSave;
    EditText txtName;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtName = findViewById(R.id.txtName);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("MyPreference", MODE_PRIVATE);
                if (sharedPreferences.contains("Name")) {
                    TastyToast.makeText(getApplicationContext(), "Already Exist", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Name", txtName.getText().toString());
                    editor.commit();
                    TastyToast.makeText(getApplicationContext(), "Registered", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                    finish();
                }
            }
        });
    }
}