package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex.pokemonList.PokemonListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "Pokemon_List_Screen"
            ) {
                composable("Pokemon_List_Screen"){
                    PokemonListScreen(navController = navController)
                }
                composable(
                    "Pokemon_Detail_Screen/{DominantColour}/{PokemonName} ",
                    arguments = listOf(
                        navArgument("DominantColour"){
                            type = NavType.IntType
                        },
                        navArgument("PokemonName"){
                            type = NavType.StringType
                        }

                    )
                ){
                    val DominantColour = remember {
                        val color = it.arguments?.getInt("DominantColour")
                        color?.let{ Color(it) } ?: Color.White
                    }
                    val PokemonName = remember {
                        it.arguments?.getString("PokemonName")
                    }
                }

            }
        }
    }
}

