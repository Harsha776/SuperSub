package com.harsha.data.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MyPojo implements Parcelable
{
    @SerializedName("banner")
    @Expose
    private Banner banner;

    @SerializedName("categories")
    @Expose
    private ArrayList<Categories> categories;

    @SerializedName("topPicks")
    @Expose
    private TopPicks topPicks;

    protected MyPojo(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MyPojo> CREATOR = new Creator<MyPojo>() {
        @Override
        public MyPojo createFromParcel(Parcel in) {
            return new MyPojo(in);
        }

        @Override
        public MyPojo[] newArray(int size) {
            return new MyPojo[size];
        }
    };

    public Banner getBanner ()
    {
        return banner;
    }

    public void setBanner (Banner banner)
    {
        this.banner = banner;
    }

    public ArrayList<Categories> getCategories ()
    {
        return categories;
    }

    public void setCategories (ArrayList<Categories> categories)
    {
        this.categories = categories;
    }

    public TopPicks getTopPicks ()
    {
        return topPicks;
    }

    public void setTopPicks (TopPicks topPicks)
    {
        this.topPicks = topPicks;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [banner = "+banner+", categories = "+categories+", topPicks = "+topPicks+"]";
    }
}