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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage





@Composable
fun MainScreen(viewModel: HomeScreenViewModel)
{
    val navController = rememberNavController()
    val screenlist =listOf<Screen>(Screen.Home, Screen.Episode, Screen.Character, Screen.Locations)
    val character = viewModel.characters.collectAsState()
    val locations = viewModel.location.collectAsState()
    var selectedScreen by remember { mutableStateOf("home") }
    var episodes = viewModel.episodes.collectAsState()
    Scaffold(topBar = { topBar(title = "Rick and Morty") }
        ,bottomBar = {NavigationBar{
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
            composable(Screen.Character.route)
            {
                CharacterScreen(character.value)
            }
            composable(Screen.Locations.route)
            {
                LocationScreen(locations.value)
            }
        }

    }
}

@Composable
fun HomeScreen()
{
Text("This is homescreen")
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar(title : String )
{
    TopAppBar(
        title = {
            Text(title)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
    )

}