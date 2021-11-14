package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class Practical_8_3 extends AppCompatActivity {

    Button btnLoad;
    ProgressDialog progressDialog;
    int status = 0;
    Handler handler = new Handler();
    long size = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical83);

        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(v.getContext());
                progressDialog.setCancelable(false);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setMessage("Downloading File");
                progressDialog.setProgress(0);
                progressDialog.setMax(100);
                progressDialog.show();


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (status < 100) {
                            status = performOperation();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.setProgress(status);
                                }
                            });
                        }
                        if (status >= 100) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();
                        }
                    }
                }).start();
            }
        });
    }

    private int performOperation() {
        while (size <= 10000) {
            size++;
            if (size == 1000) {
                return 10;
            } else if (size == 2000) {
                return 20;
            } else if (size == 3000) {
                return 30;
            } else if (size == 4000) {
                return 40;
            } else if (size == 5000) {
                return 50;
            } else if (size == 6000) {
                return 60;
            } else if (size == 7000) {
                return 70;
            } else if (size == 8000) {
                return 80;
            } else if (size == 9000) {
                return 90;
            }
        }
        return 100;
    }
}