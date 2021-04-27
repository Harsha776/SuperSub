package com.harsha.data.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categories implements Parcelable
{
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("icon")
    @Expose
    private String icon;

    @SerializedName("_id")
    @Expose
    private String _id;

    protected Categories(Parcel in) {
        name = in.readString();
        icon = in.readString();
        _id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(icon);
        dest.writeString(_id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Categories> CREATOR = new Creator<Categories>() {
        @Override
        public Categories createFromParcel(Parcel in) {
            return new Categories(in);
        }

        @Override
        public Categories[] newArray(int size) {
            return new Categories[size];
        }
    };

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", icon = "+icon+", _id = "+_id+"]";
    }
}
