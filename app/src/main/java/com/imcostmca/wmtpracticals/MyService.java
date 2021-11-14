package com.imcostmca.wmtpracticals;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import com.sdsmdg.tastytoast.TastyToast;

public class MyService extends Service {

    MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        TastyToast.makeText(getApplicationContext(), "Service is Created", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.playfile);
        mediaPlayer.setLooping(false);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }
}
