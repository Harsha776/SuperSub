package com.harsha.data.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video implements Parcelable
{
    @SerializedName("_id")
    @Expose
    private String _id;

    @SerializedName("url")
    @Expose
    private String url;

    protected Video(Parcel in) {
        _id = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [_id = "+_id+", url = "+url+"]";
    }
}
