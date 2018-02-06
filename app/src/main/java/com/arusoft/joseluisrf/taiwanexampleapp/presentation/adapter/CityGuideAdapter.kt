package com.arusoft.joseluisrf.taiwanexampleapp.presentation.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arusoft.joseluisrf.taiwanexampleapp.R
import com.arusoft.joseluisrf.taiwanexampleapp.data.mapper.FeedMapper
import com.arusoft.joseluisrf.taiwanexampleapp.databinding.ItemCityGuideBinding
import com.arusoft.joseluisrf.taiwanexampleapp.databinding.ItemCityGuideFullImageBinding
import com.arusoft.joseluisrf.taiwanexampleapp.domain.model.FeedModel


class CityGuideAdapter constructor() : RecyclerView.Adapter< BaseItemViewHolder>() {

    
    private var mIsLoadingFooterAdded = false
    private val data = mutableListOf<FeedModel>()
    

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseItemViewHolder {
        return when (viewType) {
            R.layout.item_city_guide -> DescriptionItemViewHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_city_guide, parent, false))

            R.layout.item_city_guide_full_image -> ImageItemViewHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_city_guide_full_image, parent, false))

            R.layout.loading_item_card ->  LoaderItemViewHolder(LayoutInflater.from(parent?.context).inflate( R.layout.loading_item_card, parent, false))

            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: BaseItemViewHolder?, position: Int) {
        val model = data.get(position)

        if( holder is DescriptionItemViewHolder){
            holder.binding.model = model
        } else if(holder is ImageItemViewHolder){
            holder.binding.model = model
        }
    }

    override fun getItemViewType(position: Int): Int = when (data.get(position)?.type) {
        FULL_ITEM -> R.layout.item_city_guide
        IMAGE_ITEM -> R.layout.item_city_guide_full_image
        LOADER_ITEM -> R.layout.loading_item_card
        else -> R.layout.item_city_guide
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    
    fun addAll(items: List<FeedModel>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    fun add(item: FeedModel) {
        data.add(item)
        notifyItemInserted(data.size - 1)
    }
    
    fun addLoading() {
        if (!mIsLoadingFooterAdded) {
            mIsLoadingFooterAdded = true
            add(FeedModel())
        }
    }

    fun removeLoading() {
        if (mIsLoadingFooterAdded) {
            val position = data.size - 1
            val item = data.get(position)

            if (item != null) {
                data.removeAt(position)
                notifyItemRemoved(position)
            }
            mIsLoadingFooterAdded = false
        }
    }
    companion object {

        private const val FULL_ITEM = 1
        private const val IMAGE_ITEM = 2
        private const val LOADER_ITEM = 3

    }
}

open class BaseItemViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView)

open class DescriptionItemViewHolder constructor(val binding: ItemCityGuideBinding) : BaseItemViewHolder(binding.root)

open class ImageItemViewHolder constructor(val binding: ItemCityGuideFullImageBinding) : BaseItemViewHolder(binding.root)

open class LoaderItemViewHolder constructor(itemView: View) : BaseItemViewHolder(itemView)



