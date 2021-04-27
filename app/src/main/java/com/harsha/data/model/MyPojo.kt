package com.harsha.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MyPojo() :Parcelable{

    @SerializedName("banner")
    @Expose
    private var banner: Banner? = null

    @SerializedName("categories")
    @Expose
    private var categories: ArrayList<Categories>? = null

    @SerializedName("topPicks")
    @Expose
    private var topPicks: TopPicks? = null

    constructor(parcel: Parcel) : this() {
        banner = parcel.readParcelable(Banner::class.java.classLoader)
        topPicks = parcel.readParcelable(TopPicks::class.java.classLoader)
    }

    fun getBanner(): Banner? {
        return banner
    }

    fun setBanner(banner: Banner?) {
        this.banner = banner
    }

    fun getCategories(): ArrayList<Categories>?  {
        return categories
    }

    fun setCategories(categories: ArrayList<Categories>? ) {
        this.categories = categories
    }

    fun getTopPicks(): TopPicks? {
        return topPicks
    }

    fun setTopPicks(topPicks: TopPicks?) {
        this.topPicks = topPicks
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(banner, flags)
        parcel.writeParcelable(topPicks, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyPojo> {
        override fun createFromParcel(parcel: Parcel): MyPojo {
            return MyPojo(parcel)
        }

        override fun newArray(size: Int): Array<MyPojo?> {
            return arrayOfNulls(size)
        }
    }
}