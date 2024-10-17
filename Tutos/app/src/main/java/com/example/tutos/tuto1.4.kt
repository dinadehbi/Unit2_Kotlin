package com.example.fondamentaux_kotlin

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    return if (isTrick) {
        { println("No treats!") }
    } else {
        {
            println("Have a treat!")
            if (extraTreat != null) {
                println(extraTreat(5))
            }
        }
    }
}

fun main() {
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)

    repeat(4) {
        treatFunction()
    }

    // Appel de trickFunction
    trickFunction()
}
