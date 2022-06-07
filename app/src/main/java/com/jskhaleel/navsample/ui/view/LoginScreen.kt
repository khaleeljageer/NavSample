package com.jskhaleel.navsample.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Khaleel Jageer on 07/06/22.
 */
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onForgetPasswordClick: () -> Unit,
    onSignupClick: () -> Unit,
) {
    Surface(modifier = modifier.then(Modifier.fillMaxSize())) {
        Column(modifier = modifier.then(Modifier.fillMaxSize()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Login Screen",
                fontSize = 24.sp,
                modifier = Modifier.clickable { onSignupClick.invoke() })

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Forgot password",
                fontSize = 24.sp,
                modifier = Modifier.clickable { onForgetPasswordClick.invoke() })
        }
    }
}
