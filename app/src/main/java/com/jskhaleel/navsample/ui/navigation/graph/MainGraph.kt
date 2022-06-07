package com.jskhaleel.navsample.ui.navigation.graph

import androidx.compose.material.Text
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jskhaleel.navsample.ui.navigation.Route
import com.jskhaleel.navsample.ui.navigation.Screen

/**
 * Created by Khaleel Jageer on 07/06/22.
 */
fun NavGraphBuilder.mainGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Main.route, route = Route.MAIN.name) {
        composable(route = Screen.Main.route) {
            Text(text = "Main Screen", fontSize = 24.sp)
        }
    }
}