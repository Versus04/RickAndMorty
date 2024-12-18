package com.example.rickandmorty.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.network.RickApiService
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel()
{
    private val _uistate = mutableStateOf("")
    val uistate = _uistate

    fun getcharacters()
    {
        viewModelScope.launch()
        {
            try{
                val resultval = RickApiService.retrofitservice.getCharacterList()
                _uistate.value = resultval.body().toString()
            }
            catch (e : Exception)
            {
                _uistate.value= e.toString()
            }
        }
    }
    init {
        getcharacters()
    }
}