package com.example.proyectoandroidstudio.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectoandroidstudio.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    Scaffold (
        topBar = {
            TopAppBar(title = {Text(text = "Mi App Kotlin")})
        }

    ){innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(120.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Text(text = "Bienvenido")
            Button(onClick = {/*accion futura*/}) {
                Text("Presioname")
            }
        }

        /* ajustar a medida del titulo */
        Image(

            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo App",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Fit

        )


    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}


