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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Homescreen(viewModel: HomeScreenViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            ,verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {         AsyncImage(model = "https://rickandmortyapi.com/api/character/avatar/2.jpeg" , contentDescription = null )
    Text("Hello")
       characterList(
           viewModel = viewModel
       )
    }


}

@Composable
fun characterList(viewModel: HomeScreenViewModel)
{
    val characters = viewModel.characters.collectAsState(initial = emptyList())
    /*LazyColumn {
        items(characters.value) { character ->
            // Add character item composable here
            Text(character.toString())
        } */
    LazyVerticalGrid(columns = GridCells.Fixed(4),contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp) ,) {
        items(characters.value)
        {
            characters->
            Card() {

                    AsyncImage(model = characters.image, contentDescription = null)
                    Text(characters.name)

            }

        }
    }
}