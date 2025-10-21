package com.example.proyectoandroidstudio.viewModel

import androidx.lifecycle.ViewModel
import com.example.proyectoandroidstudio.R
import com.example.proyectoandroidstudio.model.Producto

class ProductoViewModel{

    val productos = mutableListOf(
        Producto(
            id = 1,
            nombre = "Torta de Chocolate",
            precio = 25000,
            descripcion = "Deliciosa torta de chocolate con relleno cremoso",
            imagen = R.drawable.pastel
        ),
        Producto(
            id = 2,
            nombre = "Pastel de Vainilla",
            precio = 20000,
            descripcion = "Pastel suave de vainilla con glaseado blanco",
            imagen = R.drawable.pastel_2
        ),
        Producto(
            id = 3,
            nombre = "Torta de Frutos rojos",
            precio = 30000,
            descripcion = "Delicioso pastel de frutos rojos con relleno de crema",
            imagen = R.drawable.pastel_3
        )
    )



    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }

    fun eliminarProducto(id: Int) {
        productos.removeIf { it.id == id }
    }
}