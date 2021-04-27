package com.harsha.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExercisePojo implements Parcelable {

    @SerializedName("difficulty")
    @Expose
    private String difficulty;

    @SerializedName("duration")
    @Expose
    private String duration;

    @SerializedName("reps")
    @Expose
    private String reps;

    @SerializedName("sets")
    @Expose
    private String sets;

    @SerializedName("subtitle")
    @Expose
    private String subtitle;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("illustration")
    @Expose
    private Illustration illustration;

    @SerializedName("_id")
    @Expose
    private String _id;

    @SerializedName("video")
    @Expose
    private Video video;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("category")
    @Expose
    private String category;

    protected ExercisePojo(Parcel in) {
        difficulty = in.readString();
        duration = in.readString();
        reps = in.readString();
        sets = in.readString();
        subtitle = in.readString();
        description = in.readString();
        illustration = in.readParcelable(Illustration.class.getClassLoader());
        _id = in.readString();
        video = in.readParcelable(Video.class.getClassLoader());
        title = in.readString();
        category = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(difficulty);
        dest.writeString(duration);
        dest.writeString(reps);
        dest.writeString(sets);
        dest.writeString(subtitle);
        dest.writeString(description);
        dest.writeParcelable(illustration, flags);
        dest.writeString(_id);
        dest.writeParcelable(video, flags);
        dest.writeString(title);
        dest.writeString(category);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ExercisePojo> CREATOR = new Creator<ExercisePojo>() {
        @Override
        public ExercisePojo createFromParcel(Parcel in) {
            return new ExercisePojo(in);
        }

        @Override
        public ExercisePojo[] newArray(int size) {
            return new ExercisePojo[size];
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

    public String getReps ()
    {
        return reps;
    }

    public void setReps (String reps)
    {
        this.reps = reps;
    }

    public String getSets ()
    {
        return sets;
    }

    public void setSets (String sets)
    {
        this.sets = sets;
    }

    public String getSubtitle ()
    {
        return subtitle;
    }

    public void setSubtitle (String subtitle)
    {
        this.subtitle = subtitle;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public Illustration getIllustration ()
    {
        return illustration;
    }

    public void setIllustration (Illustration illustration)
    {
        this.illustration = illustration;
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

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

}
