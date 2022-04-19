package net.onyr.koans

abstract class Koan(private val label: String) {
    open fun run() {
        println()
        println("########## $label ##########")
    }
}