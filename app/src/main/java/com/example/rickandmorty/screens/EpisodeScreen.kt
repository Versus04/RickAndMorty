package com.example.rickandmorty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.model.EpisodeDTO
import com.example.rickandmorty.model.EpisodeResult

@Composable
fun EpisodeScreen(results: List<EpisodeResult>)
{
    val x = Modifier.padding(16.dp)
    LazyColumn(Modifier.padding(8.dp).fillMaxSize())
    {
        items(results)
        {
            result ->
            Card(Modifier.padding(vertical = 8.dp).fillMaxSize()) {
                Column(modifier = x){
                    Text(
                        text = "Episode Number : ${result.episode}",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp
                        ),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Name : ${result.name}",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Text(text = "Air Date : ${result.air_date}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary)

                    Text(text = "Creation Date : ${result.created}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.tertiary
                        )
                }
            }


        }
    }
}
@Preview
@Composable
fun EpisodePreview()
{
    val sampleEpisode = listOf(EpisodeResult(
        id = 1,
        name = "Pilot",
        air_date = "December 2, 2013",
        episode = "S01E01",
        characters = listOf(
            "https://rickandmortyapi.com/api/character/1",
            "https://rickandmortyapi.com/api/character/2",
            "https://rickandmortyapi.com/api/character/35",
            "https://rickandmortyapi.com/api/character/38"
            // Add more URLs as needed
        ),
        url = "https://rickandmortyapi.com/api/episode/1",
        created = "2017-11-10T12:56:33.798Z"
    ))
    EpisodeScreen(sampleEpisode)
}