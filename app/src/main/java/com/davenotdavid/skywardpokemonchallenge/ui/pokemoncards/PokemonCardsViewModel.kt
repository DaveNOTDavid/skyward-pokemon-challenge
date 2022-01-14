package com.davenotdavid.skywardpokemonchallenge.ui.pokemoncards

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davenotdavid.skywardpokemonchallenge.api.PokemonCardApiRepository
import com.davenotdavid.skywardpokemonchallenge.model.PokemonCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Identifies a [ViewModel] for construction injection.
 */
@HiltViewModel
class PokemonCardsViewModel @Inject constructor(private val cardApiRepository: PokemonCardApiRepository)
    : ViewModel() {

    // Inits LiveData val to an empty list to avoid a null-pointer when data binding adapter.
    private val _pokemonCards = MutableLiveData<List<PokemonCard>>().apply { value = emptyList() }
    val pokemonCards: LiveData<List<PokemonCard>> = _pokemonCards

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    init {
        getPokemonCards()
    }

    private fun getPokemonCards() = viewModelScope.launch {
        _dataLoading.value = true

        try {
            val pokemonCards = cardApiRepository.searchCards()
            _pokemonCards.value = pokemonCards
            _dataLoading.value = false
        } catch (ex: Exception) {
            Log.e(PokemonCardsViewModel::class.java.name, "Exception $ex")
            _pokemonCards.value = emptyList()
            _dataLoading.value = false
        }
    }

}
