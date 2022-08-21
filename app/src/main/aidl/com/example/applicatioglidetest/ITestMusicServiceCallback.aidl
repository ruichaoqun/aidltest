// ITestMusicServiceCallback.aidl
package com.example.applicatioglidetest;

import com.example.applicatioglidetest.MusicItem;

interface ITestMusicServiceCallback {
    void onPlayStateChange(int platState);
    void onMediaSourceChange(inout MusicItem musicItem);
}