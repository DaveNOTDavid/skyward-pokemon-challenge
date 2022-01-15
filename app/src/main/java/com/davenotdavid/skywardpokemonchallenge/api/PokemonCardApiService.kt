package com.davenotdavid.skywardpokemonchallenge.api

import com.davenotdavid.skywardpokemonchallenge.model.PokemonCardDetailsResponse
import com.davenotdavid.skywardpokemonchallenge.model.PokemonCardsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonCardApiService {

    @GET("cards")
    fun searchCardsAsync(@Query("pageSize") pageSize: Int): Deferred<PokemonCardsResponse>

    @GET("cards/{id}")
    fun getCardDetailsAsync(@Path("id") id: String): Deferred<PokemonCardDetailsResponse>

}
