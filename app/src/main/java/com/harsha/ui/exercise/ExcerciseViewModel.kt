package com.harsha.ui.exercise

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.harsha.common.NoConnectivityException
import com.harsha.data.model.ExercisePojo
import com.hemanth.cricbuzz.data.repository.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject


class ExcerciseViewModel @Inject constructor(private val homeRepository: HomeRepository):ViewModel() {

    private val successResponse = MutableLiveData<ExercisePojo>()
     val progressBar=ObservableBoolean(false)

    /**
     * <h2>getNewsDetails</h2>
     * this is the method to get excercise response from Api
     */
     fun getNewsDetails(id:String) {
        progressBar.set(true)
        val disposableObserver =
                object : DisposableSingleObserver<Response<ResponseBody>>() {
                    override fun onSuccess(value: Response<ResponseBody>) {
                        progressBar.set(false)
                        val response: String = value.body()!!.string()
                        Log.d("TAG", "onSuccess: "+response)
                        val jsonObject: JSONObject=JSONObject(response)
                        val gson = Gson()
                        val exercisePojo = gson.fromJson(jsonObject.toString(), ExercisePojo::class.java)
                        successResponse.postValue(exercisePojo)
                    }

                    override fun onError(e: Throwable) {
                        progressBar.set(false)
                        if (e is NoConnectivityException) {
                            Log.d("TAG", "onError: "+e.message)
                        }
                        else {
                            Log.d("TAG", "onError: "+e.message)
                        }
                    }
                }
        homeRepository.getNewsDetails(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(disposableObserver)

    }

    fun onDelayObserver():MutableLiveData<ExercisePojo>{
        return successResponse
    }
}