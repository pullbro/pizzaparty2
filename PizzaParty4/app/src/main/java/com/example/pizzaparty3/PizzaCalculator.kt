package com.example.pizzaparty3

import kotlin.math.ceil

val SLICES_PER_PIZZA = 8

enum class HungerLevel(var numSlices: Int) {
    LIGHT(2), MEDIUM(3), RAVENOUS(4)
}

/*
class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel) {
    var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    val totalPizzas: Int
        get() {
            return ceil(partySize * hungerLevel.numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
        }

    init {
        this.partySize = partySize
    }
}*/

class PizzaCalculator(partySize: Int, var selectedOption: String) {
    var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    var numSlices = when (selectedOption) {
        "Light" -> 2
        "Medium" -> 3
        "Ravenous" -> 5
        else -> 14
    }
    val totalPizzas: Int
        get() {
            return ceil(partySize * numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
        }

    init {
        this.partySize = partySize
    }
}