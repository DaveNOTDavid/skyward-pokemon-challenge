package com.davenotdavid.skywardpokemonchallenge.model

data class PokemonCardResponse(val data: List<PokemonCard>,
                               val page: Int,
                               val pageSize: Int,
                               val count: Int,
                               val totalCount: Int)

// TODO: Add more properties as needed
data class PokemonCard(val id: String,
                       val name: String,
                       val images: Images)

// Image URLs
data class Images(val small: String,
                  val large: String)
