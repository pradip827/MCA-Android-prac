package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Practical_3_3 extends AppCompatActivity {
    EditText txtUSD, txtINR;

    Button btnReset, btnDisable;
    long result;
    Double inr = 0.0, usd = 0.0, value = 74.97;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical33);
        txtUSD = findViewById(R.id.txtUSD);
        txtINR = findViewById(R.id.txtINR);

        btnReset = findViewById(R.id.btnReset);
        btnDisable = findViewById(R.id.btnDisable);

        btnDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Message", "Disabling the controls");
                txtUSD.setEnabled(false);
                txtINR.setEnabled(false);
                btnDisable.setEnabled(false);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtINR.setEnabled(true);
                txtUSD.setEnabled(true);
                txtUSD.setText("0");
                txtINR.setText("0");
                btnDisable.setEnabled(true);
            }
        });

        txtUSD.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!TextUtils.isEmpty(txtUSD.getText())) {
                    inr = Double.parseDouble(txtUSD.getText().toString()) * value;
                    result = Math.round(inr);
                    txtINR.setText(String.valueOf(result));
                }
            }
        });

        txtINR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!TextUtils.isEmpty(txtINR.getText())) {
                    usd = Double.parseDouble(txtINR.getText().toString()) / value;
                    result = Math.round(usd);
                    txtUSD.setText(String.valueOf(result));
                }
            }
        });
    }
}