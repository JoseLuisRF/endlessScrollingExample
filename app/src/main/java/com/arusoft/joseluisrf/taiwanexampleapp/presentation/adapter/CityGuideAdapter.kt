package com.arusoft.joseluisrf.taiwanexampleapp.presentation.adapter

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arusoft.joseluisrf.taiwanexampleapp.R
import com.arusoft.joseluisrf.taiwanexampleapp.data.database.entity.FeedEntity
import com.arusoft.joseluisrf.taiwanexampleapp.data.mapper.FeedMapper
import com.arusoft.joseluisrf.taiwanexampleapp.databinding.ItemCityGuideBinding
import com.arusoft.joseluisrf.taiwanexampleapp.databinding.ItemCityGuideFullImageBinding


class CityGuideAdapter constructor() : PagedListAdapter<FeedEntity, BaseItemViewHolder>(diffCallback) {


    override fun onBindViewHolder(holder: BaseItemViewHolder?, position: Int) {
        val mapper = FeedMapper()
        when(getItemViewType(position)){
            R.layout.item_city_guide -> (holder as DescriptionItemViewHolder).binding.model = mapper.convert(getItem(position)!!)

            R.layout.item_city_guide_full_image -> (holder as ImageItemViewHolder).binding.model =  mapper.convert(getItem(position)!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseItemViewHolder {
        return when (viewType) {
            R.layout.item_city_guide -> DescriptionItemViewHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent?.context),
                    R.layout.item_city_guide, parent, false))

            R.layout.item_city_guide_full_image -> ImageItemViewHolder(
                    DataBindingUtil.inflate(LayoutInflater.from(parent?.context),
                            R.layout.item_city_guide_full_image, parent, false))

            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int = when (getItem(position)?.type) {
        FULL_ITEM -> R.layout.item_city_guide
        IMAGE_ITEM -> R.layout.item_city_guide_full_image
        else -> R.layout.item_city_guide
    }


    companion object {

        private const val FULL_ITEM = 1
        private const val IMAGE_ITEM = 1
        /**
         * This diff callback informs the PagedListAdapter how to compute list differences when new
         * PagedLists arrive.
         * <p>
         * When you add a Cheese with the 'Add' button, the PagedListAdapter uses diffCallback to
         * detect there's only a single item difference from before, so it only needs to animate and
         * rebind a single view.
         *
         * @see android.support.v7.util.DiffUtil
         */
        private val diffCallback = object : DiffCallback<FeedEntity>() {
            override fun areItemsTheSame(oldItem: FeedEntity, newItem: FeedEntity): Boolean =
                    oldItem.id == newItem.id

            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */
            override fun areContentsTheSame(oldItem: FeedEntity, newItem: FeedEntity): Boolean =
                    oldItem == newItem
        }
    }
}

open class BaseItemViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView)

open class DescriptionItemViewHolder constructor(val binding: ItemCityGuideBinding) : BaseItemViewHolder(binding.root)

open class ImageItemViewHolder constructor(val binding: ItemCityGuideFullImageBinding) : BaseItemViewHolder(binding.root)



