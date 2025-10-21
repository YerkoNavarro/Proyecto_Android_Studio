package com.example.proyectoandroidstudio.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Carrito(navController: NavController) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Pastelería Mil Sabores")
                }
            )
        }




    ) { innerPadding ->


        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(50.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Carrito",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

    }

}