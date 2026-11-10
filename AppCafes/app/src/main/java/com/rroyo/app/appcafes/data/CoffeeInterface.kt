package com.rroyo.app.appcafes.data

import com.rroyo.app.appcafes.model.Coffee

interface CoffeeInterface {

    fun populate() {
//        addNewCoffee(
//            Coffee(
//
//            )
//        )
    }

    fun addNewCoffee(coffee: Coffee)

    fun updateCoffee(id: Int, coffee: Coffee)

    fun deleteCoffee(id: Int)

    fun getCoffee(id: Int): Coffee
    fun getCoffee(name: String): Coffee?

    fun length(): Int


}