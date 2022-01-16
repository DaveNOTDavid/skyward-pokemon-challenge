package com.davenotdavid.skywardpokemonchallenge.api

import com.davenotdavid.skywardpokemonchallenge.model.PokemonCardDetailsResponse
import com.davenotdavid.skywardpokemonchallenge.model.PokemonCardsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonCardApiService {

    @GET("cards")
    fun searchCardsAsync(): Deferred<PokemonCardsResponse>

    @GET("cards/{id}")
    fun getCardDetailsAsync(@Path("id") id: String): Deferred<PokemonCardDetailsResponse>

}
