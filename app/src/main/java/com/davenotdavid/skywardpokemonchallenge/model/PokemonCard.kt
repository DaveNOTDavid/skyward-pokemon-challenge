package com.davenotdavid.skywardpokemonchallenge.model

data class PokemonCardResponse(val data: List<PokemonCard>,
                               val page: Int,
                               val pageSize: Int,
                               val count: Int,
                               val totalCount: Int)


data class PokemonCard(val id: String,
                       val name: String,
                       val superType: String
                      /* TODO: ... and the list goes on so confirm */)
