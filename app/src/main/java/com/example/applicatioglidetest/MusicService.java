package com.example.applicatioglidetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    private ITestMusicService mServiceBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        mServiceBinder = new ITestMusicServiceBinder();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return (IBinder) mServiceBinder;
    }
}
