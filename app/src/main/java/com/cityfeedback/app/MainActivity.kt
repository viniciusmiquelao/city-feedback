package com.cityfeedback.app

import AppNavigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cityfeedback.app.ui.pages.MainScreen
import com.cityfeedback.app.ui.theme.CityfeedbackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CityfeedbackTheme {
                AppNavigation()
            }
        }
    }
}


