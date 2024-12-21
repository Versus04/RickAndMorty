package com.example.rickandmorty.screens
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage




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
@Composable
fun MainScreen(viewModel: HomeScreenViewModel)
{
    val navController = rememberNavController()
    val screenlist =listOf<Screen>(Screen.Home, Screen.Episode, Screen.Character, Screen.Locations)
    val character = viewModel.characters.collectAsState()
    var selectedScreen by remember { mutableStateOf("home") }
    var episodes = viewModel.episodes.collectAsState()
    Scaffold(bottomBar = {NavigationBar{
        screenlist.forEach { screens->
            NavigationBarItem(icon = { Icon(imageVector = screens.icon,contentDescription = screens.title) },
                label = { Text(screens.title) },
                selected = selectedScreen==screens.title,
                onClick = {
                    selectedScreen=screens.title
                    navController.navigate(screens.route)
                },

            )

        }

        }}) {
        paddingValues->
        NavHost(navController, startDestination = Screen.Home.route, modifier = Modifier.padding(paddingValues)) {
            composable(Screen.Home.route)
            {
                HomeScreen()
            }
            composable(Screen.Episode.route)
            {
                EpisodeScreen(episodes.value)
            }
            composable(Screen.Home.route)
            {
                HomeScreen()
            }
        }

    }
}

@Composable
fun HomeScreen()
{
Text("This is homescreen")
}