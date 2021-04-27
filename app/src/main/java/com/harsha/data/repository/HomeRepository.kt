package com.hemanth.cricbuzz.data.repository

import com.hemanth.cricbuzz.data.model.NewsResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

interface HomeRepository {

    fun getNewsDetails(id:String): Single<Response<ResponseBody>>

    fun getFeedDetails():Single<Response<ResponseBody>>

}