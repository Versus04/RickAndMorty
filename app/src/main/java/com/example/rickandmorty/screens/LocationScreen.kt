package com.example.rickandmorty.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.model.EpisodeResult
import com.example.rickandmorty.model.LocationResult

@Composable
fun LocationScreen(results: List<LocationResult>)
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
                        text =result.name,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp
                        ),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = result.created.substring(0..9),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Text(text = result.dimension,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary)

                }
            }
        }
    }
}