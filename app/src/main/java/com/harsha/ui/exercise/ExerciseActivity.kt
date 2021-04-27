package com.harsha.ui.exercise

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.harsha.common.Constants.ID
import com.harsha.ui.splashactivity.R
import com.harsha.ui.splashactivity.databinding.ExerciseActivityBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ExerciseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mBinding:ExerciseActivityBinding
    lateinit var excerciseViewModel: ExcerciseViewModel

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
        initializeViewModel()
        responseObserver()
    }

    /**
     * this method is used to initialize the view
     */
    private fun initializeView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.exercise_activity)
        mBinding.ivBackPress.setOnClickListener {
            onBackPressed()
        }
    }

    /**
     * This method is used initialize the viewModel class for this activity.
     */
    private fun initializeViewModel() {
        excerciseViewModel = ViewModelProviders.of(this, viewModelFactory).get(ExcerciseViewModel::class.java)
        mBinding.viewModel=excerciseViewModel
        excerciseViewModel.getNewsDetails(intent.getStringExtra(ID)!!)
    }

    /**
     * observing the delay to move next activity
     */
    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun responseObserver(){
        excerciseViewModel.onDelayObserver().observe(this, Observer {
            if(it!=null){
                mBinding.tvTitle.text = it.category
                mBinding.webView.loadUrl(it.video.url)
                mBinding.webView.webViewClient = object : WebViewClient(){}
                mBinding.webView.webChromeClient = object : WebChromeClient() {}
                mBinding.webView.settings.setJavaScriptEnabled(true)
                mBinding.tvTopPicks.text = it.title
                mBinding.tvDescribtion.text = it.description
                mBinding.tvRepTime.text = "${it.sets} ${getString(R.string.sets)} ${it.reps} ${getString(R.string.reps)}"
                Glide.with(this).load(it.illustration.imageUrl).into(mBinding.ivInfograohics)

            }
        })
    }

}