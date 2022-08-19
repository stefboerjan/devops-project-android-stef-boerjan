package com.example.breakingbadapp.screens.character

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.breakingbadapp.network.CharacterProperty
import com.example.breakingbadapp.network.EpisodeProperty
import org.w3c.dom.Text

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .into(imgView)
    }
}

@BindingAdapter("episodeSeasonString")
fun TextView.setSeasonString(item: EpisodeProperty?) {
    item?.let {
        text = String.format("Season %d", item.season)
    }
}

@BindingAdapter("occupation")
fun TextView.setOccupation(item: CharacterProperty?) {
    item?.let {
        text = item.occupation.joinToString(", ")
    }
}

@BindingAdapter("characters")
fun TextView.setCharacters(item: EpisodeProperty?) {
    item?.let {
        text = item.characters.joinToString(", ")
    }
}


