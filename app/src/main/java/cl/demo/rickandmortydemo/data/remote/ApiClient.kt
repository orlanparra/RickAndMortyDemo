package cl.demo.rickandmortydemo.data.remote

import cl.demo.rickandmortydemo.data.remote.dto.CharacterDto
import cl.demo.rickandmortydemo.data.remote.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int ) : CharactersDto
    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id : Int) : CharacterDto
}