package com.example.applicatioglidetest;

import android.os.RemoteCallbackList;
import android.os.RemoteException;

public class ITestMusicServiceBinder extends ITestMusicService.Stub {
    private RemoteCallbackList<ITestMusicServiceCallback> mCallback = new RemoteCallbackList<>();

    @Override
    public void playNow() throws RemoteException {

    }

    @Override
    public void play() throws RemoteException {

    }

    @Override
    public void pause() throws RemoteException {

    }

    @Override
    public void playPre() throws RemoteException {

    }

    @Override
    public void playNext() throws RemoteException {

    }

    @Override
    public void hello() throws RemoteException {

    }

    @Override
    public MusicItem getMeidaItem() throws RemoteException {
        return null;
    }

    @Override
    public void registerServiceCallback(ITestMusicServiceCallback callback) throws RemoteException {
        mCallback.register(callback);
        testCallback();
    }

    @Override
    public void unRegisterServiceCallback(ITestMusicServiceCallback callback) throws RemoteException {
        mCallback.unregister(callback);
    }

    private void testCallback() {
        final int count = mCallback.beginBroadcast();
        for (int i=0; i<count; i++) {
            try {
                mCallback.getBroadcastItem(i).onPlayStateChange(1);
            } catch (RemoteException e) {
                // The RemoteCallbackList will take care of removing
                // the dead object for us.
            }
        }
        mCallback.finishBroadcast();
    }
}
