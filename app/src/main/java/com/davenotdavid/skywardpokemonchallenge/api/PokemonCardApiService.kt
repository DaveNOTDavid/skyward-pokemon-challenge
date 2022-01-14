package com.davenotdavid.skywardpokemonchallenge.api

import com.davenotdavid.skywardpokemonchallenge.model.PokemonCardResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonCardApiService {

    /**
     * TODO: Returns a max of 250 cards by default?
     * TODO: What to query besides API key?
     *
     * https://docs.pokemontcg.io/api-reference/cards/search-cards#query-parameters
     */
    @GET("cards")
    fun searchCardsAsync(@Query("pageSize") pageSize: Int): Deferred<PokemonCardResponse>

}
