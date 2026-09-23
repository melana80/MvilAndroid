package com.example.mvilandroid

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

enum class Pantalla { HOME, CATALOGO, DETALLE }

@Composable
fun AppNavigation() {
    var pantallaActual by remember { mutableStateOf(Pantalla.HOME) }
    var productoSeleccionado by remember { mutableStateOf<ProductoMerch?>(null) }

    when (pantallaActual) {
        Pantalla.HOME -> MerchHomeScreen(
            onVerCatalogo = { pantallaActual = Pantalla.CATALOGO }
        )

        Pantalla.CATALOGO -> MerchCatalogoScreen(
            productos = listaProductos,
            onProductoClick = { producto ->
                productoSeleccionado = producto
                pantallaActual = Pantalla.DETALLE
            },
            onVolver = { pantallaActual = Pantalla.HOME }
        )

        Pantalla.DETALLE -> {
            productoSeleccionado?.let { producto ->
                MerchDetalleScreen(
                    producto = producto,
                    onVolver = { pantallaActual = Pantalla.CATALOGO }
                )
            }
        }
    }
}
