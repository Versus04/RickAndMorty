package com.example.rickandmorty.model

data class EpisodeDTO(
    val info: Info,
    val results: List<EpisodeResult>
)