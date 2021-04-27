package com.harsha.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Banner() :Parcelable {

    @SerializedName("image")
    @Expose
    private var image: String? = null

    @SerializedName("header")
    @Expose
    private var header: String? = null

    constructor(parcel: Parcel) : this() {
        image = parcel.readString()
        header = parcel.readString()
    }

    fun getImage(): String? {
        return image
    }

    fun setImage(image: String?) {
        this.image = image
    }

    fun getHeader(): String? {
        return header
    }

    fun setHeader(header: String?) {
        this.header = header
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(image)
        parcel.writeString(header)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Banner> {
        override fun createFromParcel(parcel: Parcel): Banner {
            return Banner(parcel)
        }

        override fun newArray(size: Int): Array<Banner?> {
            return arrayOfNulls(size)
        }
    }
}