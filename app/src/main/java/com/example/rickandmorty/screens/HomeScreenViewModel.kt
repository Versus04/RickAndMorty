package com.example.rickandmorty.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.model.CharacterDTO
import com.example.rickandmorty.model.CharacterResult
import com.example.rickandmorty.network.RickApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel()
{
    private val _characters = MutableStateFlow<List<CharacterResult>>(emptyList())
    val characters: StateFlow<List<CharacterResult>> = _characters


    fun getcharacters()
    {
        viewModelScope.launch()
        {
           try {
               val responses = RickApiService.retrofitservice.getCharacterList()
               responses.body()?.let {
                   characterresponse ->
                   _characters.value=characterresponse.results
               }
           }
           catch (e : Exception)
           {

           }
        }
    }
    init {
        getcharacters()
    }
}