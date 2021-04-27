package com.harsha.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Drills() :Parcelable {

    @SerializedName("difficulty")
    @Expose
    private var difficulty: String? = null

    @SerializedName("duration")
    @Expose
    private var duration: String? = null

    @SerializedName("subtitle")
    @Expose
    private var subtitle: String? = null

    @SerializedName("_id")
    @Expose
    private var _id: String? = null

    @SerializedName("video")
    @Expose
    private var video: Video? = null

    @SerializedName("title")
    @Expose
    private var title: String? = null

    constructor(parcel: Parcel) : this() {
        difficulty = parcel.readString()
        duration = parcel.readString()
        subtitle = parcel.readString()
        _id = parcel.readString()
        video = parcel.readParcelable(Video::class.java.classLoader)
        title = parcel.readString()
    }

    fun getDifficulty(): String? {
        return difficulty
    }

    fun setDifficulty(difficulty: String?) {
        this.difficulty = difficulty
    }

    fun getDuration(): String? {
        return duration
    }

    fun setDuration(duration: String?) {
        this.duration = duration
    }

    fun getSubtitle(): String? {
        return subtitle
    }

    fun setSubtitle(subtitle: String?) {
        this.subtitle = subtitle
    }

    fun get_id(): String? {
        return _id
    }

    fun set_id(_id: String?) {
        this._id = _id
    }

    fun getVideo(): Video? {
        return video
    }

    fun setVideo(video: Video?) {
        this.video = video
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(difficulty)
        parcel.writeString(duration)
        parcel.writeString(subtitle)
        parcel.writeString(_id)
        parcel.writeParcelable(video, flags)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Drills> {
        override fun createFromParcel(parcel: Parcel): Drills {
            return Drills(parcel)
        }

        override fun newArray(size: Int): Array<Drills?> {
            return arrayOfNulls(size)
        }
    }
}