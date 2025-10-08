package com.example.proyectoandroidstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.proyectoandroidstudio.ui.theme.HomeScreen
import com.example.proyectoandroidstudio.ui.theme.ProyectoAndroidStudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Myapp()
        }
    }
}

@Composable
fun Myapp(){
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = "home"){
        composable("home"){HomeScreen(navController)}

    }
}


