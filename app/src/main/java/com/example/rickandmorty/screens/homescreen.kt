package com.example.rickandmorty.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Homescreen(viewModel: HomeScreenViewModel) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {         AsyncImage(model = "https://rickandmortyapi.com/api/character/avatar/2.jpeg" , contentDescription = null )
    Text("Hello")
        Text(viewModel.uistate.value)
    }


}
