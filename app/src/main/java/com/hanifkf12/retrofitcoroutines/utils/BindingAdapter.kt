package com.hanifkf12.retrofitcoroutines.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class BindingAdapter {
    companion object{
        @JvmStatic
        @BindingAdapter("setImage")
        fun setImage(imageView: ImageView, url: String){
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+ url).into(imageView)
        }

    }
}