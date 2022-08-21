// ITestMusicService.aidl
package com.example.applicatioglidetest;

import com.example.applicatioglidetest.MusicItem;
import com.example.applicatioglidetest.ITestMusicServiceCallback;

// Declare any non-default types here with import statements

interface ITestMusicService {
    void playNow();
    void play();
    void pause();
    void playPre();
    void playNext();
    void hello();
    MusicItem getMeidaItem();
    void registerServiceCallback(ITestMusicServiceCallback callback);
    void unRegisterServiceCallback(ITestMusicServiceCallback callback);
}