package com.imcostmca.wmtpracticals;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.sdsmdg.tastytoast.TastyToast;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            TastyToast.makeText(context, "Flight Mode Status Changed", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
        }
    }
}
