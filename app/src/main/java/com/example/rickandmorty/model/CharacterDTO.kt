package com.example.rickandmorty.model

data class CharacterDTO(
    val info: Info,
    val results: List<CharacterResult>
)