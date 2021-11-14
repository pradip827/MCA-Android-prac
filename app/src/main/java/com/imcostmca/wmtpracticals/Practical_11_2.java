package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sdsmdg.tastytoast.TastyToast;

public class Practical_11_2 extends AppCompatActivity {

    EditText txtMobileNo, txtSMS;
    Button btnSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical112);
        txtMobileNo = findViewById(R.id.txtMobileNo);
        txtSMS = findViewById(R.id.txtSMS);
        btnSendMessage = findViewById(R.id.btnSendMessage);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txtMobileNo.getText())) {
                    TastyToast.makeText(getApplicationContext(), "Enter Mobile No", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                } else if (TextUtils.isEmpty(txtSMS.getText())) {
                    TastyToast.makeText(getApplicationContext(), "Enter Text", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                } else {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(txtMobileNo.getText().toString(), null, txtSMS.getText().toString(), null, null);
                    TastyToast.makeText(getApplicationContext(), "SMS Sent", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                }
            }
        });

    }
}