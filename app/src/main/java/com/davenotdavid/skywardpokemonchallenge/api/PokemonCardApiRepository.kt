package com.davenotdavid.skywardpokemonchallenge.api

import com.davenotdavid.skywardpokemonchallenge.model.PokemonCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * This repo instance used in say, View Models, are constructor-injected via
 * Hilt's View Model annotation.
 */
class PokemonCardApiRepository @Inject constructor(private val service: PokemonCardApiService) {

    @Throws(Exception::class)
    suspend fun searchCards(): List<PokemonCard> {
        return withContext(Dispatchers.IO) {
            service.searchCardsAsync().await().data
        }
    }

}
