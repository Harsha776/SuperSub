package com.harsha.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner implements Parcelable
{
    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("header")
    @Expose
    private String header;

    protected Banner(Parcel in) {
        image = in.readString();
        header = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(header);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Banner> CREATOR = new Creator<Banner>() {
        @Override
        public Banner createFromParcel(Parcel in) {
            return new Banner(in);
        }

        @Override
        public Banner[] newArray(int size) {
            return new Banner[size];
        }
    };

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getHeader ()
    {
        return header;
    }

    public void setHeader (String header)
    {
        this.header = header;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [image = "+image+", header = "+header+"]";
    }
}
