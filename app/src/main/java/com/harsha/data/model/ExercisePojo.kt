package com.harsha.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ExercisePojo() :Parcelable {
    @SerializedName("difficulty")
    @Expose
    private var difficulty: String? = null

    @SerializedName("duration")
    @Expose
    private var duration: String? = null

    @SerializedName("reps")
    @Expose
    private var reps: String? = null

    @SerializedName("sets")
    @Expose
    private var sets: String? = null

    @SerializedName("subtitle")
    @Expose
    private var subtitle: String? = null

    @SerializedName("description")
    @Expose
    private var description: String? = null

    @SerializedName("illustration")
    @Expose
    private var illustration: Illustration? = null

    @SerializedName("_id")
    @Expose
    private var _id: String? = null

    @SerializedName("video")
    @Expose
    private var video: Video? = null

    @SerializedName("title")
    @Expose
    private var title: String? = null

    @SerializedName("category")
    @Expose
    private var category: String? = null

    constructor(parcel: Parcel) : this() {
        difficulty = parcel.readString()
        duration = parcel.readString()
        reps = parcel.readString()
        sets = parcel.readString()
        subtitle = parcel.readString()
        description = parcel.readString()
        illustration = parcel.readParcelable(Illustration::class.java.classLoader)
        _id = parcel.readString()
        video = parcel.readParcelable(Video::class.java.classLoader)
        title = parcel.readString()
        category = parcel.readString()
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

    fun getReps(): String? {
        return reps
    }

    fun setReps(reps: String?) {
        this.reps = reps
    }

    fun getSets(): String? {
        return sets
    }

    fun setSets(sets: String?) {
        this.sets = sets
    }

    fun getSubtitle(): String? {
        return subtitle
    }

    fun setSubtitle(subtitle: String?) {
        this.subtitle = subtitle
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getIllustration(): Illustration? {
        return illustration
    }

    fun setIllustration(illustration: Illustration?) {
        this.illustration = illustration
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

    fun getCategory(): String? {
        return category
    }

    fun setCategory(category: String?) {
        this.category = category
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(difficulty)
        parcel.writeString(duration)
        parcel.writeString(reps)
        parcel.writeString(sets)
        parcel.writeString(subtitle)
        parcel.writeString(description)
        parcel.writeParcelable(illustration, flags)
        parcel.writeString(_id)
        parcel.writeParcelable(video, flags)
        parcel.writeString(title)
        parcel.writeString(category)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExercisePojo> {
        override fun createFromParcel(parcel: Parcel): ExercisePojo {
            return ExercisePojo(parcel)
        }

        override fun newArray(size: Int): Array<ExercisePojo?> {
            return arrayOfNulls(size)
        }
    }
}