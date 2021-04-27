package com.harsha.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Drills implements Parcelable
{
    @SerializedName("difficulty")
    @Expose
    private String difficulty;

    @SerializedName("duration")
    @Expose
    private String duration;

    @SerializedName("subtitle")
    @Expose
    private String subtitle;

    @SerializedName("_id")
    @Expose
    private String _id;

    @SerializedName("video")
    @Expose
    private Video video;

    @SerializedName("title")
    @Expose
    private String title;

    protected Drills(Parcel in) {
        difficulty = in.readString();
        duration = in.readString();
        subtitle = in.readString();
        _id = in.readString();
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(difficulty);
        dest.writeString(duration);
        dest.writeString(subtitle);
        dest.writeString(_id);
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Drills> CREATOR = new Creator<Drills>() {
        @Override
        public Drills createFromParcel(Parcel in) {
            return new Drills(in);
        }

        @Override
        public Drills[] newArray(int size) {
            return new Drills[size];
        }
    };

    public String getDifficulty ()
    {
        return difficulty;
    }

    public void setDifficulty (String difficulty)
    {
        this.difficulty = difficulty;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getSubtitle ()
    {
        return subtitle;
    }

    public void setSubtitle (String subtitle)
    {
        this.subtitle = subtitle;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public Video getVideo ()
    {
        return video;
    }

    public void setVideo (Video video)
    {
        this.video = video;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [difficulty = "+difficulty+", duration = "+duration+", subtitle = "+subtitle+", _id = "+_id+", video = "+video+", title = "+title+"]";
    }
}