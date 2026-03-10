package com.guzzardo.jj4tictactoe

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import android.util.Log

class MainActivity : ComponentActivity() {
    public var lastWidthMeasureSpec: Int = 0
    public var lastHeightMeasureSpec: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        // 1. Install the splash screen
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)


        /*
        startKoin {
            androidContext(this@MyApplication)
            modules(sharedModule)
        } */




        // 2. Set the condition to keep the splash screen
        val isVMReady = true //false // Replace with your actual loading state
        splashScreen.setKeepOnScreenCondition {
            !isVMReady // Keep on screen as long as this is true
        }

        setContentView(R.layout.lib_game)
        val mGameView = findViewById<View>(R.id.game_view) as GameView
        mGameView.measure(lastWidthMeasureSpec, lastHeightMeasureSpec)
        Log.i("Greeting", "Calculated view width: $lastWidthMeasureSpec, height: $lastHeightMeasureSpec")

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