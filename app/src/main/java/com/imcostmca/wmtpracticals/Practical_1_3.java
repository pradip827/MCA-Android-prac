package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practical_1_3 extends AppCompatActivity {

    Button btnCLickMe;
    EditText txtName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical13);
        txtName = findViewById(R.id.txtName);
        btnCLickMe = findViewById(R.id.btnClickMe);


        btnCLickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txtName.getText())) {
                    Toast.makeText(getApplicationContext(), "First Enter Your Name", Toast.LENGTH_SHORT).show();
                } else {
                    name = txtName.getText().toString();
                    Toast.makeText(getApplicationContext(), "Hey! " + name + " You Have Clicked Me", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}