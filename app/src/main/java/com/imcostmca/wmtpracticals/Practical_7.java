package com.imcostmca.wmtpracticals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practical_7 extends AppCompatActivity {

    private final static int Request_code_permission = 1;

    private static final String[] permissions = new String[]{Manifest.permission.CAMERA };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical7);
        Check();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Request_code_permission:
                for (int i = permissions.length - 1; i >= 0; --i) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        TastyToast.makeText(this, "Permission required for " + permissions[i], TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                        return;
                    }
                }
                break;
        }
    }

    private void Check() {
        final List<String> deniedPermission = new ArrayList<String>();
        for (final String per : permissions) {
            final int res = ContextCompat.checkSelfPermission(this, per);
            if (res != PackageManager.PERMISSION_GRANTED) {
                deniedPermission.add(per);
            }
        }
        if (!deniedPermission.isEmpty()) {
            final String[] permissions = deniedPermission.toArray(new String[deniedPermission.size()]);
            ActivityCompat.requestPermissions(this, permissions, Request_code_permission);
        } else {
            final int[] results = new int[permissions.length];
            Arrays.fill(results, PackageManager.PERMISSION_GRANTED);
            onRequestPermissionsResult(Request_code_permission, permissions, results);
        }
    }
}