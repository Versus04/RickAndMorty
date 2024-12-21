package com.example.rickandmorty.network
import retrofit2.Response
import com.example.rickandmorty.model.CharacterDTO
import com.example.rickandmorty.model.CharacterResult
import com.example.rickandmorty.model.EpisodeDTO
import com.example.rickandmorty.model.LocationDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL="https://rickandmortyapi.com/api/"
interface RickApi {

    @GET("character")
    suspend fun getCharacterList(): Response<CharacterDTO>

    @GET("location")
    suspend fun  getLocationList(): Response<LocationDTO>

    @GET("episode")
    suspend fun getAllEpisodes(): Response<EpisodeDTO>

}
private val retrofit : Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


object RickApiService{
    val retrofitservice :RickApi by lazy {
        retrofit.create(RickApi::class.java)
    }

}