package com.arusoft.joseluisrf.taiwanexampleapp.presentation.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arusoft.joseluisrf.taiwanexampleapp.R
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.joseluisrf.taiwanexampleapp.data.mapper.FeedMapper
import com.arusoft.joseluisrf.taiwanexampleapp.databinding.ItemCityGuideBinding
import com.arusoft.joseluisrf.taiwanexampleapp.databinding.ItemCityGuideFullImageBinding


class CityGuideAdapter constructor() : RecyclerView.Adapter< BaseItemViewHolder>() {

    override fun getItemCount(): Int {
        return data.count()
    }

    private val data = mutableListOf<FeedEntity>()

    /**
     * Adds an element to the adapter.
     *
     * @param items [BaseHomeCardModel]
     */
    fun addAll(items: List<FeedEntity>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseItemViewHolder {
        return when (viewType) {
            R.layout.item_city_guide -> DescriptionItemViewHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_city_guide, parent, false))

            R.layout.item_city_guide_full_image -> ImageItemViewHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_city_guide_full_image, parent, false))

            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: BaseItemViewHolder?, position: Int) {
        val mapper = FeedMapper()
        val model = mapper.convert(data.get(position))

        if( holder is DescriptionItemViewHolder){
            holder.binding.model = model
        } else if(holder is ImageItemViewHolder){
            holder.binding.model = model
        }
    }

    override fun getItemViewType(position: Int): Int = when (data.get(position)?.type) {
        FULL_ITEM -> R.layout.item_city_guide
        IMAGE_ITEM -> R.layout.item_city_guide_full_image
        else -> R.layout.item_city_guide
    }


    companion object {

        private const val FULL_ITEM = 1
        private const val IMAGE_ITEM = 2

    }
}

open class BaseItemViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView)

open class DescriptionItemViewHolder constructor(val binding: ItemCityGuideBinding) : BaseItemViewHolder(binding.root)

open class ImageItemViewHolder constructor(val binding: ItemCityGuideFullImageBinding) : BaseItemViewHolder(binding.root)



