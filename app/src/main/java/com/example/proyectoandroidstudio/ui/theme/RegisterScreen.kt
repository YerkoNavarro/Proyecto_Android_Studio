package com.example.proyectoandroidstudio.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.proyectoandroidstudio.viewModel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var gmail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    val viewModel: UserViewModel = viewModel()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Pastelería Mil Sabores") }
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
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre Usuario") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = gmail,
                onValueChange = { gmail = it },
                label = { Text("Gmail") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
            if (error.isNotBlank()) {
                Text(text = error, color = androidx.compose.ui.graphics.Color.Red)
            }
            Button(
                onClick = {
                    coroutineScope.launch {
                        val register = viewModel.dbregisterUser(name, address = "", gmail, password)
                        if (register) {
                            error = ""
                            navController.popBackStack() // vuelve al login
                        } else {
                            error = "Error en el registro. Asegúrate de que:"+ "\n- El correo tenga formato válido (ej: usuario@dominio.com)"+ "\n- La contraseña tenga al menos 4 caracteres"+ "\n- La contraseña contenga al menos un carácter especial: !@#$%&*"
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrar")
            }
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver al Login")
            }
        }
    }
}




