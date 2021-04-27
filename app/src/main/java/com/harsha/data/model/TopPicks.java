package com.harsha.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TopPicks implements Parcelable
{
    @SerializedName("drills")
    @Expose
    private ArrayList<Drills> drills;

    @SerializedName("title")
    @Expose
    private String title;

    protected TopPicks(Parcel in) {
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TopPicks> CREATOR = new Creator<TopPicks>() {
        @Override
        public TopPicks createFromParcel(Parcel in) {
            return new TopPicks(in);
        }

        @Override
        public TopPicks[] newArray(int size) {
            return new TopPicks[size];
        }
    };

    public ArrayList<Drills> getDrills ()
    {
        return drills;
    }

    public void setDrills (ArrayList<Drills> drills)
    {
        this.drills = drills;
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
        return "ClassPojo [drills = "+drills+", title = "+title+"]";
    }
}
