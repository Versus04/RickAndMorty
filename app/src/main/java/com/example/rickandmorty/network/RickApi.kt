package com.example.rickandmorty.network
import retrofit2.Response
import com.example.rickandmorty.model.CharacterDTO
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET
private const val BASE_URL="https://rickandmortyapi.com/api/"
interface RickApi {

    @GET("character")
    suspend fun getCharacterList(): Response<CharacterDTO>

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