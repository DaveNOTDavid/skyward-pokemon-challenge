package com.davenotdavid.skywardpokemonchallenge.ui.pokemoncards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.davenotdavid.skywardpokemonchallenge.databinding.ListItemPokemonCardBinding
import com.davenotdavid.skywardpokemonchallenge.model.PokemonCard
import com.davenotdavid.skywardpokemonchallenge.ui.pokemoncards.PokemonCardsViewModel

/**
 * Adapter for the pokemon card list. Has a reference to the [PokemonCardsViewModel] to send
 * actions back to it.
 */
class PokemonCardsAdapter(private val cardsViewModel: PokemonCardsViewModel) :
    ListAdapter<PokemonCard, PokemonCardsAdapter.ViewHolder>(PokemonCardDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(cardsViewModel, item)
    }

    class ViewHolder private constructor(private val binding: ListItemPokemonCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cardsViewModel: PokemonCardsViewModel, pokemonCard: PokemonCard) {
            binding.viewmodel = cardsViewModel
            binding.pokemoncard = pokemonCard
            // Updates the view bound to modified vars.
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemPokemonCardBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between an old list and a new
 * list that's been passed to `submitList`.
 */
class PokemonCardDiffCallback : DiffUtil.ItemCallback<PokemonCard>() {
    override fun areItemsTheSame(oldItem: PokemonCard, newItem: PokemonCard): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PokemonCard, newItem: PokemonCard): Boolean {
        return oldItem == newItem
    }
}
