package com.example.proyectoandroidstudio.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.proyectoandroidstudio.R
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyectoandroidstudio.DAO.dbUserActual

import com.example.proyectoandroidstudio.viewModel.PerfilViewModel
import com.example.proyectoandroidstudio.viewModel.UserViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {
    var user by remember{ mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    val viewModel: UserViewModel = viewModel()
    val viewModel2: PerfilViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Pastelería Mil Sabores")
                }
            )
        }
    ){innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(50.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            /* ajustar a medida del titulo */
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo App",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                label = { Text("Usuario (Gmail)") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth()
            )
            if (error.isNotBlank()) {
                Text(text = error, color = androidx.compose.ui.graphics.Color.Red)
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            val success = viewModel.dbloginUser(user, password)
                            if (success) {
                                error = ""
                                try {
                                    viewModel2.deleteAllActualUsers()

                                }catch (e: Exception){
                                    println("error al borrar en db")
                                }

                                viewModel2.insertActualUser(dbUserActual(0,user))
                                navController.navigate("menu")
                            } else {
                                error = "Usuario o contraseña incorrectos"
                            }
                        }

                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Iniciar sesión")
                }
                Spacer(Modifier.height(12.dp))
                Text("¿No tienes cuenta?")
                Button(
                    onClick = { navController.navigate("registro") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Registrarse")
                }
            }
        }
    }
}




