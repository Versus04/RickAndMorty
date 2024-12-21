package com.example.rickandmorty.screens

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.model.CharacterDTO
import com.example.rickandmorty.model.CharacterResult
import com.example.rickandmorty.model.EpisodeResult
import com.example.rickandmorty.model.Info
import com.example.rickandmorty.model.LocationResult
import com.example.rickandmorty.network.RickApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel()
{
    //characters
    private val _characters = MutableStateFlow<List<CharacterResult>>(emptyList())
    val characters: StateFlow<List<CharacterResult>> = _characters
    private val _charinfo= MutableStateFlow<Info>(Info(0,"",0,0))
    val charinfo : StateFlow<Info> = _charinfo

    //Episodes
    private val _episodes = MutableStateFlow<List<EpisodeResult>>(emptyList())
    val episodes : StateFlow<List<EpisodeResult>> = _episodes
    private val _epiinfo= MutableStateFlow<Info>(Info(0,"",0,0))
    val epiinfo : StateFlow<Info> = _epiinfo

    //Loocation
    private val _location = MutableStateFlow<List<LocationResult>>(emptyList())
    val location : StateFlow<List<LocationResult>> = _location
    private val _locationinfo= MutableStateFlow<Info>(Info(0,"",0,0))
    val locationinfoo : StateFlow<Info> = _locationinfo

    fun getcharacters()
    {
        viewModelScope.launch()
        {
           try {
               val responses = RickApiService.retrofitservice.getCharacterList()
               responses.body()?.let {
                   characterresponse ->
                   _characters.value=characterresponse.results
                   _charinfo.value=characterresponse.info
               }
           }
           catch (e : Exception)
           {

           }
        }
    }
    fun getEpisodes()
    {
        viewModelScope.launch()
        {
            try {
                val response = RickApiService.retrofitservice.getAllEpisodes()
                response.body()?.let {
                    episodeResponse->
                    _episodes.value=episodeResponse.results
                    _epiinfo.value=episodeResponse.info
                }
            }
            catch (e: Exception)
            {Log.d("episode", e.toString())
            }
        }
    }
    fun getLocationList()
    {
        viewModelScope.launch()
        {
            try {
                val response = RickApiService.retrofitservice.getLocationList()
                response.body()?.let {
                        locationresponse->
                    _location.value=locationresponse.results
                    _locationinfo.value = locationresponse.info
                }
            }
            catch (e: Exception)
            {Log.d("episode", e.toString())
            }
        }
    }
    init {
        getcharacters()
        getEpisodes()
        getLocationList()
    }
}