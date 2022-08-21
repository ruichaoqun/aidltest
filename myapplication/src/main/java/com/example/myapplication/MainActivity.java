package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.example.applicatioglidetest.ITestMusicService;
import com.example.applicatioglidetest.ITestMusicServiceCallback;
import com.example.applicatioglidetest.MusicItem;

public class MainActivity extends AppCompatActivity {
    private ITestMusicService mService = null;
    private static final String PACKAGE_NAME = "com.example.applicatioglidetest";
    private static final String SERVICE_NAME = "com.example.applicatioglidetest.MusicService";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bindService(View view) {
        if (mService != null) {
            Log.e("AAAA", "服务已绑定");
            return;
        }
        ComponentName componentName = new ComponentName(PACKAGE_NAME, SERVICE_NAME);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        ServiceConnection connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.e("AAAA", "服务已连接");
                mService = ITestMusicService.Stub.asInterface(service);

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        bindService(intent, connection, Service.BIND_AUTO_CREATE);
    }

    public void regitserCallback(View view) {
        if (mService != null) {
            try {
                mService.registerServiceCallback(callback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private ITestMusicServiceCallback callback = new ITestMusicServiceCallback.Stub() {

        @Override
        public void onPlayStateChange(int platState) throws RemoteException {
            Log.e("AAAA", "onPlayStateChange-->" + platState);
        }

        @Override
        public void onMediaSourceChange(MusicItem musicItem) throws RemoteException {

        }
    };
}