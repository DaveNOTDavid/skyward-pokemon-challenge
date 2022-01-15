package com.davenotdavid.skywardpokemonchallenge.api

import com.davenotdavid.skywardpokemonchallenge.model.PokemonCardResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PokemonCardApiService {

    @GET("cards")
    fun searchCardsAsync(): Deferred<PokemonCardResponse>

}
