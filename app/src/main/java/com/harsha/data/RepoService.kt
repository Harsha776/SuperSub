package com.harsha.data

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoService {

    @GET("exercise/{exerciseId}")
    fun getNewsDetails(@Path("exerciseId") id:String): Single<Response<ResponseBody>>

    @GET("explore")
    fun getFeedDetails() : Single<Response<ResponseBody>>

}