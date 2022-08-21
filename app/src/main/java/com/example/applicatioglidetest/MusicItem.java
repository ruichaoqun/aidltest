package com.example.applicatioglidetest;

import android.os.Parcel;
import android.os.Parcelable;

public class MusicItem implements Parcelable {
    private int musicId;
    private String title;

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    private String album;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.musicId);
        dest.writeString(this.title);
        dest.writeString(this.album);
    }

    public void readFromParcel(Parcel source) {
        this.musicId = source.readInt();
        this.title = source.readString();
        this.album = source.readString();
    }

    public MusicItem() {
    }

    protected MusicItem(Parcel in) {
        this.musicId = in.readInt();
        this.title = in.readString();
        this.album = in.readString();
    }

    public static final Parcelable.Creator<MusicItem> CREATOR = new Parcelable.Creator<MusicItem>() {
        @Override
        public MusicItem createFromParcel(Parcel source) {
            return new MusicItem(source);
        }

        @Override
        public MusicItem[] newArray(int size) {
            return new MusicItem[size];
        }
    };
}
