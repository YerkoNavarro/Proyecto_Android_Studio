package com.example.proyectoandroidstudio.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.proyectoandroidstudio.R
import com.example.proyectoandroidstudio.viewModel.PerfilViewModel
import com.example.proyectoandroidstudio.DAO.dbUserActual
import com.example.proyectoandroidstudio.DAO.dbUser
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Perfil(navController: NavController) {
    val viewModel: PerfilViewModel = viewModel()

    var currentUser by remember { mutableStateOf<dbUserActual?>(null) }
    var usuarioEncontrado by remember { mutableStateOf<dbUser?>(null) }


    LaunchedEffect(Unit) {
        currentUser = viewModel.getCurrentUser()
        currentUser?.dbCorreo?.let { correo ->
            usuarioEncontrado = viewModel.buscarPorcorreo(correo)
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Mi Perfil")
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
            Image(
                painter = painterResource(R.drawable.perfil),
                contentDescription = "Perfil",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Text(
                text = "Datos de Usuario",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Text(

                text = "Correo: ${currentUser?.dbCorreo ?: "Cargando..."}"

            )
            Text(
                text = "Nombre ${usuarioEncontrado?.dbNombre ?: "Cargando..."}"
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilPreview() {
    Perfil(navController = rememberNavController())
}