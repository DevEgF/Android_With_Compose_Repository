package com.example.movieapp.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movies") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ) {
            MainContent(navController = navController)
        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter and the Sorcerer's Stone",
        "Cross the Line",
        "Be Happy",
        "Happy Feet",
        "Life",
        "The Dark Knight",
        "Inception",
        "Pulp Fiction",
        "The Shawshank Redemption",
        "Titanic",
        "Gladiator",
        "The Lord of the Rings: The Fellowship of the Ring",
        "The Matrix",
        "Forrest Gump",
        "Fight Club",
        "The Godfather",
        "Jurassic Park",
        "The Avengers",
        "Interstellar",
        "Schindler's List",
        "Braveheart",
        "The Silence of the Lambs",
        "E.T. the Extra-Terrestrial",
        "The Lion King",
        "The Terminator",
        "Casablanca",
        "Alien",
        "The Wizard of Oz",
        "Gone with the Wind",
        "The Departed",
        "The Revenant",
        "The Social Network",
        "The Green Mile",
        "Saving Private Ryan",
        "A Beautiful Mind",
        "The Exorcist",
        "Avatar: The Last Airbender",
        "Finding Nemo",
        "The Princess Bride",
        "Black Swan",
        "The Dark Knight Rises",
        "The Sixth Sense",
        "Memento",
        "The Breakfast Club",
        "The Shining",
        "The Great Gatsby",
        "No Country for Old Men",
        "Inglourious Basterds",
        "The Good, the Bad and the Ugly",
        "Apocalypse Now",
        "The Sound of Music",
        "The Godfather: Part II",
        "One Flew Over the Cuckoo's Nest",
        "The Usual Suspects",
        "Shutter Island",
        "Eternal Sunshine of the Spotless Mind",
        "The Grand Budapest Hotel",
        "The Departed",
        "American Beauty",
        "Glory",
        "The Prestige",
        "Mad Max: Fury Road",
        "Requiem for a Dream",
        "Blade Runner",
        "Moulin Rouge!",
        "The Truman Show",
        "The King's Speech",
        "City of God",
        "The Pianist",
        "Raiders of the Lost Ark",
        "Rocky",
        "The Terminator 2: Judgment Day",
        "Twelve Monkeys",
        "The Matrix Reloaded",
        "The Matrix Revolutions",
        "Goodfellas",
        "The Wolf of Wall Street",
        "Apocalypto",
        "The Last Samurai",
        "The Pursuit of Happyness",
        "The Curious Case of Benjamin Button",
        "Seven Samurai",
        "The Sting",
        "The French Connection",
        "The Godfather: Part III",
        "American History X",
        "Django Unchained",
        "The Hateful Eight",
        "The Color Purple",
        "The Graduate",
        "The Elephant Man",
        "The Good, the Bad, the Weird",
        "The Lives of Others",
        "The Hunt for Red October",
        "The Hunt",
        "The Thing",
        "The Good Dinosaur",
        "The Iron Giant"
    )
) {
    Column {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    Log.d("TAG", "MainContent: $movie")
                }
            }
        }
    }
}

@Composable
fun MovieRow(movie: String, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movie)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(6.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Movie Image"
                )
            }
            Text(text = movie)
        }
    }
}