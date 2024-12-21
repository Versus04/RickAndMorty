package com.example.rickandmorty.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route : String , val title : String , val icon : ImageVector) {
    object Home : Screen("home","Home",Icons.Default.Home)
    object Character : Screen("character","Character",Icons.Default.Person)
    object Locations : Screen("locations","Locations",Icons.Default.LocationOn)
    object Episode : Screen("epispdes","Episodes", Icons.Default.PlayArrow)
}