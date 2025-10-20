package com.example.proyectoandroidstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.proyectoandroidstudio.ui.theme.ProyectoAndroidStudioTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoandroidstudio.ui.theme.Carrito
import com.example.proyectoandroidstudio.ui.theme.HomeScreen
import com.example.proyectoandroidstudio.ui.theme.Login
import com.example.proyectoandroidstudio.ui.theme.Perfil
import com.example.proyectoandroidstudio.ui.theme.RegistroScreen
import com.example.proyectoandroidstudio.ui.theme.NavigationBarExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    
    ProyectoAndroidStudioTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background //usa el color de theme.kt
        ) {
            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                composable("login") {
                    Login(navController = navController)
                }
                composable("registro") {
                    RegistroScreen(navController = navController)
                }
                composable("menu") {
                    NavigationBarExample()
                }
                composable("carrito") {
                    Carrito(navController = navController)
                }
                composable("perfil") {
                    Perfil(navController = navController)
                }
            }
        }
    }
}
