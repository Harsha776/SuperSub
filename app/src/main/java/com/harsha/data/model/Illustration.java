package com.harsha.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Illustration implements Parcelable
{
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    @SerializedName("caption")
    @Expose
    private String caption;

    @SerializedName("description")
    @Expose
    private String description;

    protected Illustration(Parcel in) {
        imageUrl = in.readString();
        caption = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(caption);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Illustration> CREATOR = new Creator<Illustration>() {
        @Override
        public Illustration createFromParcel(Parcel in) {
            return new Illustration(in);
        }

        @Override
        public Illustration[] newArray(int size) {
            return new Illustration[size];
        }
    };

    public String getImageUrl ()
    {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getCaption ()
    {
        return caption;
    }

    public void setCaption (String caption)
    {
        this.caption = caption;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [imageUrl = "+imageUrl+", caption = "+caption+", description = "+description+"]";
    }
}
