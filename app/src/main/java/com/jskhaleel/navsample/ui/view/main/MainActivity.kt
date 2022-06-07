package com.jskhaleel.navsample.ui.view.main

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.jskhaleel.navsample.ui.navigation.NavigationHost
import com.jskhaleel.navsample.ui.theme.NavSampleTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Khaleel Jageer on 07/06/22.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (mainViewModel.isReady) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        launchComposeUi()
                        true
                    } else {
                        false
                    }
                }
            }
        )

    }

    private fun launchComposeUi() {
        setContent {
            NavSampleTheme {
                NavigationHost()
            }
        }
    }
}