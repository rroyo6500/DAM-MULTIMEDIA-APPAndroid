package com.rroyo.appcafes.data

import com.rroyo.appcafes.model.Coffee

class CoffeeList : CoffeeInterface {

    private val list: MutableList<Coffee> = mutableListOf()

    override fun addNewCoffee(coffee: Coffee) {
        list.add(coffee)
    }

    override fun updateCoffee(id: Int, coffee: Coffee) {
        list[id] = coffee
    }

    override fun deleteCoffee(id: Int) {
        list.removeAt(id)
    }

    override fun getCoffee(id: Int): Coffee = list[id]

    override fun getCoffee(name: String): Coffee? =
        list.firstOrNull() { it.name == name }

    override fun length(): Int = list.size
}