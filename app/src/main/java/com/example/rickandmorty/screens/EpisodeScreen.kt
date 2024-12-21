package com.example.rickandmorty.screens
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.model.EpisodeDTO
import com.example.rickandmorty.model.EpisodeResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodeScreen(results: List<EpisodeResult>)
{
    val x = Modifier.padding(16.dp)
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedEpisode by remember { mutableStateOf<EpisodeResult?>(null) }
    LazyColumn(
        Modifier
            .padding(8.dp)
            .fillMaxSize())
    {
        items(results)
        {
            result ->
            Card(
                Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxSize()
                    .clickable {
                        selectedEpisode = result
                        showBottomSheet = true
                    }
            ) {
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

                    Text(text = "Creation Date : ${result.created.substring(0..9)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.tertiary
                        )
                    if (showBottomSheet && selectedEpisode != null) {
                        ModalBottomSheet(
                            onDismissRequest = {
                                showBottomSheet = false
                                selectedEpisode = null
                            }
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Episode Details",
                                    style = MaterialTheme.typography.headlineMedium,
                                    modifier = Modifier.padding(bottom = 16.dp)
                                )
                                Text("Episode: ${selectedEpisode?.episode}")
                                Text("Name: ${selectedEpisode?.name}")
                                Text("Air Date: ${selectedEpisode?.air_date}")
                                Text("Created: ${selectedEpisode?.created?.substring(0..9)}")
                                result.characters.forEach{y->
                                    Text(y)
                                }

                            }
                        }
                    }
                }}}}}


