package com.example.aplicacionlista.modelo

data class Personaje(
    var nombre: String,
    var ocupacion: String,
    var bando: Pais,
    var descripcion: String = "",
    var opinion: Int = 0
) {

}