package com.harsha.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TopPicks() :Parcelable {
    @SerializedName("drills")
    @Expose
    private var drills: ArrayList<Drills>? = null

    @SerializedName("title")
    @Expose
    private var title: String? = null

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
    }

    fun getDrills(): ArrayList<Drills>? {
        return drills
    }

    fun setDrills(drills: ArrayList<Drills>?) {
        this.drills = drills
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TopPicks> {
        override fun createFromParcel(parcel: Parcel): TopPicks {
            return TopPicks(parcel)
        }

        override fun newArray(size: Int): Array<TopPicks?> {
            return arrayOfNulls(size)
        }
    }
}