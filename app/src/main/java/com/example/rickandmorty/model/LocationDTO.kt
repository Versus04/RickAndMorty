package com.example.rickandmorty.model

data class LocationDTO(
    val info: Info,
    val results: List<LocationResult>
)