package com.harsha.ui.home

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.harsha.common.Constants.ID
import com.harsha.ui.exercise.ExerciseActivity
import com.harsha.ui.home.categoryAdapter.CategoryAdapter
import com.harsha.ui.home.topPicksAdapter.TopPicksAdapter
import com.harsha.ui.splashactivity.R
import com.harsha.ui.splashactivity.databinding.HomeActivityBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mBinding:HomeActivityBinding
    lateinit var homeViewModel: HomeViewModel
    lateinit var itemCategoryList:CategoryAdapter
    lateinit var itemTopPicksAdapter: TopPicksAdapter

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
        initializeViewModel()
        responeObserver()
        observeNetworkState()
    }

    /**
     * this method is used to initialize the view
     */
    private fun initializeView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.home_activity)
        mBinding.tvRetry.setOnClickListener {
            homeViewModel.getFeedDetails()
        }
    }

    /**
     * This method is used initialize the viewModel class for this activity.
     */
    private fun initializeViewModel() {
        homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        mBinding.viewModel=homeViewModel
        homeViewModel.getFeedDetails()
    }

    /**
     * observing the api response
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun responeObserver(){
        homeViewModel.responseObserver().observe(this, Observer {
            if(it!=null){
                mBinding.tvTitle.text = it.banner.header
                Glide.with(this).load(it.banner.image).placeholder(getDrawable(R.drawable.place_holder)).into(mBinding.ivLoadBanner)
                itemCategoryList = CategoryAdapter(it.categories)
                mBinding.rvCategory.adapter=itemCategoryList
                mBinding.tvTopPicks.text=it.topPicks.title
                itemTopPicksAdapter= TopPicksAdapter(it.topPicks.drills,this)
                mBinding.rvTopPicks.setHasFixedSize(true)
                mBinding.rvTopPicks.adapter=itemTopPicksAdapter
            }
        })
    }

    private fun observeNetworkState(){
        homeViewModel.checkNetworkState().observe(this, Observer {
            if(it!=null && it) {
                mBinding.clNetWork.visibility=View.VISIBLE
            }else
                mBinding.clNetWork.visibility=View.GONE
        })

    }


    fun onSelect(id:String){
        val intent=Intent(this,ExerciseActivity::class.java)
        intent.putExtra(ID,id)
        startActivity(intent)
    }
}