package com.harsha.data.repositoryImpl

import com.harsha.data.RepoService
import com.hemanth.cricbuzz.data.model.NewsResponse
import com.hemanth.cricbuzz.data.repository.HomeRepository
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

class HomeRepositoryImpl(
    private val repoService: RepoService
) : HomeRepository {

    override fun getNewsDetails(id:String): Single<Response<ResponseBody>> = repoService.getNewsDetails(id)
    override fun getFeedDetails(): Single<Response<ResponseBody>> =repoService.getFeedDetails()


}