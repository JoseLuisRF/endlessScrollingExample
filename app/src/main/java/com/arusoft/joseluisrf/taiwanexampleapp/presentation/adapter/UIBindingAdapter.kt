package com.arusoft.joseluisrf.taiwanexampleapp.presentation.adapter

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide


@BindingAdapter("app:imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    if (!TextUtils.isEmpty(url)) {
        Glide.with(imageView.context)
                .load(url)
                .into(imageView)
    }
}