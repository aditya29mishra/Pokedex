package com.example.pokedex.repository

import com.example.pokedex.data.remote.PokeAPI
import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.data.remote.responses.PokemonList
import com.example.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeAPI
){
    suspend fun GetPokemonList(limit: Int , offset: Int): Resource<PokemonList> {
        val response = try {
            api.GetPokemonList(limit,offset)
        }catch (e:Exception){
            return Resource.Error("An unknown error occurred")
        }
        return  Resource.Success(response)

    }

    suspend fun GetPokemonInfo(pokemonName: String): Resource<Pokemon>{
        val response = try {
            api.GetpokemonInfo(pokemonName)
        }catch (e:Exception){
            return Resource.Error("An unknown error occurred")
        }
        return  Resource.Success(response)
    }
}