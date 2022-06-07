package com.jskhaleel.navsample.ui.navigation

/**
 * Created by Khaleel Jageer on 07/06/22.
 */
sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Login : Screen("login")
    object Signup : Screen("signup")
}
