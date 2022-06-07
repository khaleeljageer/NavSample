package com.jskhaleel.navsample.ui.navigation.graph

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jskhaleel.navsample.ui.navigation.Route
import com.jskhaleel.navsample.ui.navigation.Screen
import com.jskhaleel.navsample.ui.view.LoginScreen
import com.jskhaleel.navsample.ui.view.main.MainViewModel

/**
 * Created by Khaleel Jageer on 07/06/22.
 */
fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Login.route, route = Route.AUTH.name) {
        composable(route = Screen.Login.route) {
            LoginScreen(onForgetPasswordClick = {}, onSignupClick = {
                navController.navigate(Screen.Signup.route)
            })
        }
        composable(route = Screen.Signup.route) {
            val mainViewModel: MainViewModel = hiltViewModel()

            Text(text = "Signup Screen", fontSize = 24.sp, modifier = Modifier.clickable {
                mainViewModel.setUserLogged()
                navController.navigate(Route.MAIN.name) {
                    popUpTo(route = Route.AUTH.name) { inclusive = true }
                }
            })
        }
    }
}