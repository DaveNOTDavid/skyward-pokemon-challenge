package com.davenotdavid.skywardpokemonchallenge.ui.pokemoncards.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.davenotdavid.skywardpokemonchallenge.R
import com.davenotdavid.skywardpokemonchallenge.model.PokemonCard
import com.davenotdavid.skywardpokemonchallenge.ui.pokemoncards.adapter.PokemonCardsAdapter

/**
 * [BindingAdapter] for the [PokemonCard] list.
 */
@BindingAdapter("app:items")
fun setItems(recyclerView: RecyclerView, items: List<PokemonCard>) {
    (recyclerView.adapter as PokemonCardsAdapter).submitList(items)
}

/**
 * Handles image view/data binding for image loading/caching via [Glide].
 */
@BindingAdapter("imageUrl")
fun loadImage(image: ImageView, url: String?) =
    Glide
        .with(image.context)
        .load(url)
        .placeholder(R.drawable.ic_placeholder)
        .into(image)
