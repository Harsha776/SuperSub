package com.harsha.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Illustration() :Parcelable{
    @SerializedName("imageUrl")
    @Expose
    private var imageUrl: String? = null

    @SerializedName("caption")
    @Expose
    private var caption: String? = null

    @SerializedName("description")
    @Expose
    private var description: String? = null

    constructor(parcel: Parcel) : this() {
        imageUrl = parcel.readString()
        caption = parcel.readString()
        description = parcel.readString()
    }

    fun getImageUrl(): String? {
        return imageUrl
    }

    fun setImageUrl(imageUrl: String?) {
        this.imageUrl = imageUrl
    }

    fun getCaption(): String? {
        return caption
    }

    fun setCaption(caption: String?) {
        this.caption = caption
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(imageUrl)
        parcel.writeString(caption)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Illustration> {
        override fun createFromParcel(parcel: Parcel): Illustration {
            return Illustration(parcel)
        }

        override fun newArray(size: Int): Array<Illustration?> {
            return arrayOfNulls(size)
        }
    }
}