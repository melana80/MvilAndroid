package com.example.mvilandroid

import androidx.annotation.DrawableRes

data class ProductoMerch(
    val id: Int,
    val nombre: String,
    val tipo: String,
    val precio: Double,
    val descripcion: String,
    @DrawableRes val imagenRes: Int
)
