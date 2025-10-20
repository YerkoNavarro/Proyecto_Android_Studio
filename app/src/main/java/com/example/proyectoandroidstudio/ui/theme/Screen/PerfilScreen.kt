package com.example.proyectoandroidstudio.ui.theme.Screen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.String

@Composable
fun PantallaPerfil(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF5E6)) // fondo general crema claro
    ) {

        // ---------------- Header ----------------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFFF5D8B3)) // header crema oscuro
                .padding(20.dp)
        ) {
            Column {
                Text(
                    text = "Cuenta",
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp),
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF8B5E3C) // marrón oscuro
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {

                    // Imagen de perfil
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFFEBCD)), // beige suave
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp),
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Foto De Perfil",
                            tint = Color(0xFF8B5E3C) // marrón oscuro
                        )
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    // Nombre y "Editar Perfil"
                    Column {
                        Text(
                            text = "Javier Muñoz",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(0xFF8B5E3C)
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Editar Perfil",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF8B5E3C).copy(alpha = 0.8f)
                            )
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = "Flecha",
                                modifier = Modifier.size(16.dp),
                                tint = Color(0xFF8B5E3C).copy(alpha = 0.8f)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ---------------- Lista de opciones ----------------
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {

            Text(
                text = "Mi Cuenta",
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp),
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF8B5E3C)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Opciones estilo pastelería
            OpcionMiCuentaPasteleria(icon = Icons.Default.LocationOn, titulo = "Direcciones", onClick = {}, showDivider = true)
            OpcionMiCuentaPasteleria(icon = Icons.Default.ShoppingCart, titulo = "Pedidos", onClick = {}, showDivider = true)
            OpcionMiCuentaPasteleria(icon = Icons.Default.Favorite, titulo = "Método de Pago", onClick = {}, showDivider = false)
        }
    }
}

@Composable
fun OpcionMiCuentaPasteleria(
    icon: ImageVector,
    titulo: String,
    onClick: () -> Unit,
    showDivider: Boolean = true
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
                .clickable { onClick() }
        ) {
            Icon(icon, contentDescription = titulo, modifier = Modifier.size(20.dp), tint = Color(0xFF8B5E3C))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = titulo, style = MaterialTheme.typography.bodyMedium, color = Color(0xFF8B5E3C))
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Flecha",
                modifier = Modifier.size(16.dp),
                tint = Color(0xFF8B5E3C).copy(alpha = 0.8f)
            )
        }

        if (showDivider) {
            Divider(color = Color(0xFFEEDFCC), thickness = 1.dp)
        }
    }
}