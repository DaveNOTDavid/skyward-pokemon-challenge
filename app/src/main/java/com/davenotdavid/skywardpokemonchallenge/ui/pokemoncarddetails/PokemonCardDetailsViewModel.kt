package com.davenotdavid.skywardpokemonchallenge.ui.pokemoncarddetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davenotdavid.skywardpokemonchallenge.api.PokemonCardApiRepository
import com.davenotdavid.skywardpokemonchallenge.model.PokemonCard
import com.davenotdavid.skywardpokemonchallenge.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonCardDetailsViewModel @Inject constructor(private val cardApiRepository: PokemonCardApiRepository)
    : ViewModel() {

    private val _pokemonCard = MutableLiveData<PokemonCard?>()
    val pokemonCard: LiveData<PokemonCard?> = _pokemonCard

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _openCardPageEvent = MutableLiveData<Event<String>>()
    val openCardPageEvent: LiveData<Event<String>> = _openCardPageEvent

    fun openCardPage(url: String) {
        _openCardPageEvent.value = Event(url)
    }

    fun getCardDetails(cardId: String) = viewModelScope.launch {
        _dataLoading.value = true

        try {
            val pokemonCards = cardApiRepository.getCardDetails(cardId)
            _pokemonCard.value = pokemonCards
            _dataLoading.value = false
        } catch (ex: Exception) {
            Log.e(PokemonCardDetailsViewModel::class.java.name, "Exception $ex")
            _pokemonCard.value = null
            _dataLoading.value = false
        }
    }

}
