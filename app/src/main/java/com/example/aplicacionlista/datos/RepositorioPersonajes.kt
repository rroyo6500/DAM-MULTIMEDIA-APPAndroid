package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.Pais
import com.example.aplicacionlista.modelo.Personaje

interface RepositorioPersonajes {

    fun poblar() {
        nuevoPersonaje(
            Personaje("Santos", "Productor en Minas Gerais", Pais.BRASIL)
        )
        nuevoPersonaje(
            Personaje("Mateo", "Caficultor del Eje Cafetero", Pais.COLOMBIA)
        )
        nuevoPersonaje(
            Personaje("Abebe", "Recolector en Yirgacheffe", Pais.ETIOPIA)
        )
        nuevoPersonaje(
            Personaje("Carlos", "Tostador en Antigua", Pais.GUATEMALA)
        )
        nuevoPersonaje(
            Personaje("Elena", "Productora en Copán", Pais.HONDURA)
        )
        nuevoPersonaje(
            Personaje("Budi", "Cultivador en Sumatra", Pais.INDONESIA)
        )
        nuevoPersonaje(
            Personaje("Kamau", "Agrónomo en Nyeri", Pais.KENIA)
        )
        nuevoPersonaje(
            Personaje("Sofía", "Barista en Chiapas", Pais.MEXICO)
        )
        nuevoPersonaje(
            Personaje("Diego", "Productor en Boquete", Pais.PANAMA)
        )
        nuevoPersonaje(
            Personaje("Valeria", "Catadora en Cajamarca", Pais.PERU, "Especialista en altura")
        )
    }

    fun nuevoPersonaje(p: Personaje)
    fun actualizar(id: Int, p: Personaje)
    fun borrar(id: Int)
    fun buscar(id: Int): Personaje
    fun longitud(): Int

}