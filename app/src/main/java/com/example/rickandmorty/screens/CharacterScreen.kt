package com.example.rickandmorty.screens

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rickandmorty.model.CharacterResult
import com.example.rickandmorty.model.EpisodeResult

@Composable
fun CharacterScreen(results: List<CharacterResult> )
{

    LazyVerticalGrid( columns = GridCells.Fixed(1), Modifier.fillMaxSize()) {
        items(results)
        {
                characters->
            CharacterCard(characters)

        }
    }
}
@Composable
fun CharacterCard( character : CharacterResult)
{
    Card(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp))
    {
        Column(){
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data(character.image)
                .crossfade(true)
                .build(),
                contentDescription = null
            , modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), contentScale = ContentScale.FillBounds)
        }
        Column(Modifier.padding(16.dp)) {
            Text(text = character.name ,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,

                )
            Text(text = "${character.status} - ${character.species}" ,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface.copy(0.6f)
            )

            Text(
                text = "Last known location:",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = character.location.name,
                style = MaterialTheme.typography.bodyLarge
            )



        }
    }
}