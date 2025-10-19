package com.example.proyectoandroidstudio.viewModel

import androidx.lifecycle.ViewModel
import com.example.proyectoandroidstudio.R
import com.example.proyectoandroidstudio.model.Producto

class ProductoViewModel{

    val productos = mutableListOf(
        Producto(
            id = 1,
            nombre = "Torta de Chocolate",
            precio = 25.0,
            descripcion = "Deliciosa torta de chocolate con relleno cremoso",
            imagen = R.drawable.pastel
        ),
        Producto(
            id = 2,
            nombre = "Pastel de Vainilla",
            precio = 20.0,
            descripcion = "Pastel suave de vainilla con glaseado blanco",
            imagen = R.drawable.pastel_2
        ),
        Producto(
            id = 3,
            nombre = "Cupcakes",
            precio = 5.0,
            descripcion = "Docena de cupcakes variados",
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