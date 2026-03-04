package com.guzzardo.jj3tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 1. Install the splash screen
        val splashScreen = installSplashScreen()
        //enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // 2. Set the condition to keep the splash screen
        val isVMReady = true //false // Replace with your actual loading state
        splashScreen.setKeepOnScreenCondition {
            !isVMReady // Keep on screen as long as this is true
        }

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}