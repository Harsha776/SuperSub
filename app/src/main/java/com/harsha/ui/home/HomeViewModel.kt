package com.harsha.ui.home

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.harsha.common.NoConnectivityException
import com.harsha.data.model.MyPojo
import com.hemanth.cricbuzz.data.repository.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject


class HomeViewModel @Inject constructor( private val homeRepository: HomeRepository):ViewModel() {

    private val successResponse = MutableLiveData<MyPojo>()
     val progressBar=ObservableBoolean(false)
    val netWorkState = MutableLiveData<Boolean>()

    /**
     * <h2>getNewsDetails</h2>
     * this is the method to get news response from Api
     */
     fun getFeedDetails() {
        progressBar.set(true)
        val disposableObserver =
                object : DisposableSingleObserver<Response<ResponseBody>>() {
                    override fun onSuccess(value: Response<ResponseBody>) {
                        progressBar.set(false)
                        netWorkState.postValue(false)
                        val response: String = value.body()!!.string()
                        Log.d("TAG", "onSuccess: "+response)
                        val jsonObject: JSONObject=JSONObject(response)
                        val gson = Gson()
                        val myPojo = gson.fromJson(jsonObject.toString(), MyPojo::class.java)
                        successResponse.postValue(myPojo)
                    }

                    override fun onError(e: Throwable) {
                        progressBar.set(false)
                        if (e is NoConnectivityException) {
                            netWorkState.postValue(true)
                        } else {
                            Log.d("TAG", "onError: " + e.message)
                        }
                    }
                }
        homeRepository.getFeedDetails().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(disposableObserver)

    }

    fun responseObserver():MutableLiveData<MyPojo>{
        return successResponse
    }

    fun checkNetworkState():MutableLiveData<Boolean>{
        return netWorkState
    }
}