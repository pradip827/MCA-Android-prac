package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

public class Practical_6 extends AppCompatActivity {

    Switch switchWifi, switchBluetooth;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical6);

        switchWifi = findViewById(R.id.switchWifi);
        switchBluetooth = findViewById(R.id.switchBluetooth);


        switchWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(true);
                    TastyToast.makeText(getApplicationContext(), "Wi-Fi On", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                } else {
                    wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifiManager.setWifiEnabled(false);
                    TastyToast.makeText(getApplicationContext(), "Wi-Fi Off", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                }
            }
        });

        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        switchBluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (bluetoothAdapter == null) {
                        TastyToast.makeText(getApplicationContext(), "Bluetooth is not supported", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    } else {
                        if (!bluetoothAdapter.isEnabled()) {
                            startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), 1);
                            TastyToast.makeText(getApplicationContext(), "Bluetooth On", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                        }
                    }
                } else {
                    if (bluetoothAdapter != null) {
                        bluetoothAdapter.disable();
                        TastyToast.makeText(getApplicationContext(), "Bluetooth Off", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    }

                }
            }
        });
    }
}