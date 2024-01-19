package gei.igualada.udl.cat.simplelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import gei.igualada.udl.cat.simplelist.models.Pokemon
import gei.igualada.udl.cat.simplelist.ui.theme.PokemonListViewModel
import gei.igualada.udl.cat.simplelist.ui.theme.SimpleListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    mainScreen()
                }
            }
        }
    }
}

@Composable
fun mainScreen() {
    val viewModel = remember { PokemonListViewModel() }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        PokemonList(viewModel = viewModel)
        AddButton(viewModel = viewModel)
    }
}

@Composable
fun PokemonList(viewModel: PokemonListViewModel) {

    val pokemonList by viewModel.pokemonList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Pokedex")
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            items(pokemonList) { pokemon ->
                PokemonCard(pokemon = pokemon)
            }
        }
    }

}

@Composable
fun AddButton(viewModel: PokemonListViewModel) {

}

@Composable
fun PokemonCard(pokemon: Pokemon) {
    Card(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Name: ${pokemon.name}",
                style = MaterialTheme.typography.h6,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "ID: ${pokemon.id}",
                style = MaterialTheme.typography.body1,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Height: ${pokemon.height} cm",
                style = MaterialTheme.typography.body1,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Weight: ${pokemon.weight} kg",
                style = MaterialTheme.typography.body1,
                color = Color.Black
            )
        }
    }
}





