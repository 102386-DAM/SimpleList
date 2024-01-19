package gei.igualada.udl.cat.simplelist.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gei.igualada.udl.cat.simplelist.models.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList: StateFlow<List<Pokemon>> = _pokemonList

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        _pokemonList.value = listOf(
            Pokemon("Bulbasaur", 1, 7, 69),
            Pokemon("Ivysaur", 2, 10, 130),
            Pokemon("Venusaur", 3, 20, 1000),
            Pokemon("Charmander", 4, 6, 85),
            Pokemon("Charmeleon", 5, 11, 190),
            Pokemon("Charizard", 6, 17, 905),
            Pokemon("Squirtle", 7, 5, 90),
            Pokemon("Wartortle", 8, 10, 225),
            Pokemon("Blastoise", 9, 16, 855),
            Pokemon("Caterpie", 10, 3, 29)
        )
    }


    /*private fun fetchPokemonList() {
        viewModelScope.launch {
            val response = // Use Retrofit or another HTTP client to fetch data from PokeAPI
                _pokemonList.value = response.results
        }
    }*/
}
