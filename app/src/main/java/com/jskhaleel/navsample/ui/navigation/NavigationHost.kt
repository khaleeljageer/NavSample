package com.jskhaleel.navsample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jskhaleel.navsample.ui.navigation.graph.authGraph
import com.jskhaleel.navsample.ui.navigation.graph.mainGraph
import com.jskhaleel.navsample.ui.view.main.MainViewModel

/**
 * Created by Khaleel Jageer on 06/06/22.
 */
@Composable
fun NavigationHost(mainViewModel: MainViewModel = hiltViewModel()) {
    val navController = rememberNavController()
    val startScreen = when (mainViewModel.userLogged) {
        true -> Route.MAIN.name
        else -> Route.AUTH.name
    }

    NavHost(navController = navController, startDestination = startScreen) {
        authGraph(navController)
        mainGraph(navController)
    }
}