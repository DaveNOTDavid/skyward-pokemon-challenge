package com.davenotdavid.skywardpokemonchallenge.model

data class PokemonCardsResponse(val data: List<PokemonCard>,
                                val page: Int,
                                val pageSize: Int,
                                val count: Int,
                                val totalCount: Int)

data class PokemonCardDetailsResponse(val data: PokemonCard)

data class PokemonCard(val id: String,
                       val name: String,
                       val images: Images,
                       // E.g. ["Grass", "Metal"]
                       val types: List<String>,
                       // E.g. "Rare Holo"
                       val rarity: String,
                       // E.g. "Kagemaru Himeno"
                       val artist: String,
                       val cardmarket: CardMarket)

// Image URLs
data class Images(val small: String,
                  val large: String)

data class CardMarket(val url: String)
