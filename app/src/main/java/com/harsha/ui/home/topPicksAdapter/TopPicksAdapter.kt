package com.harsha.ui.home.topPicksAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.harsha.common.Util
import com.harsha.data.model.Drills
import com.harsha.ui.home.HomeActivity
import com.harsha.ui.splashactivity.R
import com.harsha.ui.splashactivity.databinding.ItemTopPicksListBinding

/**
 * this adpater is used to show top picks list
 */
class TopPicksAdapter(drills:ArrayList<Drills>,homeActivity: HomeActivity): RecyclerView.Adapter<TopPicksAdapter.ViewHolder>() {

    lateinit var mContext: Context
    lateinit var homeActivity: HomeActivity
    var drills:ArrayList<Drills>

    init {
        this.drills=drills
        this.homeActivity=homeActivity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: ItemTopPicksListBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_top_picks_list, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return if(drills!=null) drills.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.webView.loadUrl(drills.get(position).video.url)
        holder.itemBinding.tvSubtitle.text = drills.get(position).subtitle
        holder.itemBinding.tvTitle.text = "| ${drills.get(position).title}"
        holder.itemBinding.tvBasics.text = drills.get(position).difficulty
        holder.itemBinding.tvTime.text = Util.secondsToMinute(drills.get(position).duration.toInt())
        holder.itemBinding.cvMain.setOnClickListener {
            homeActivity.onSelect(drills.get(position)._id)
        }

    }

    class ViewHolder(itemBinding: ItemTopPicksListBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        var itemBinding: ItemTopPicksListBinding

        init {
            this.itemBinding=itemBinding
            itemBinding.webView.setWebViewClient(object :WebViewClient(){})
            itemBinding.webView.setWebChromeClient(object : WebChromeClient() {})
            itemBinding.webView.getSettings().setJavaScriptEnabled(true)
        }

    }
}