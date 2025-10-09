package com.example.proyectoandroidstudio.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.proyectoandroidstudio.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroScreen(navController: NavController) {


    Scaffold (
        topBar = {
            TopAppBar(title = {Text(text = "pasteleria mil sabores")})

        }

    ){innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(50.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){


            Spacer(modifier = Modifier.height(90.dp))
            Text(text = "Bienvenido")
            Button(onClick = {/*accion futura*/}) {
                Text("Ingresar")
            }
        }






    }




}




