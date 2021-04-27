package com.harsha.ui.home.categoryAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.harsha.data.model.Categories
import com.harsha.ui.splashactivity.R
import com.harsha.ui.splashactivity.databinding.ItemCategoryListBinding

/**
 * this adapter is for category list
 */
class CategoryAdapter(category:ArrayList<Categories>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    lateinit var mContext: Context
    var category:ArrayList<Categories>

    init {
        this.category=category
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: ItemCategoryListBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_category_list, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return if(category!=null) category.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.tvCategoryname.text=category.get(position).getName()
        Glide.with(mContext).load(category.get(position).getIcon()).into(holder.itemBinding.ivCategoryImage)
    }

    class ViewHolder(itemBinding: ItemCategoryListBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        var itemBinding: ItemCategoryListBinding = itemBinding

    }
}