package com.davenotdavid.skywardpokemonchallenge.ui.pokemoncards

import androidx.lifecycle.ViewModel
import com.davenotdavid.skywardpokemonchallenge.api.PokemonCardApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Identifies a [ViewModel] for construction injection.
 */
@HiltViewModel
class PokemonCardsViewModel @Inject constructor(private val repository: PokemonCardApiRepository) : ViewModel() {
    // TODO: Implement the ViewModel
}
