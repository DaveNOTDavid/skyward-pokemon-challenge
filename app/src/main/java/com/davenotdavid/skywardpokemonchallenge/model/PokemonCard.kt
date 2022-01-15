package com.davenotdavid.skywardpokemonchallenge.model

data class PokemonCardsResponse(val data: List<PokemonCard>,
                                val page: Int,
                                val pageSize: Int,
                                val count: Int,
                                val totalCount: Int)

data class PokemonCardDetailsResponse(val data: PokemonCard)

// TODO: Add more properties as needed
data class PokemonCard(val id: String,
                       val name: String,
                       val images: Images)

// Image URLs
data class Images(val small: String,
                  val large: String)
