package net.onyr.koans

import org.junit.Assert.*
import kotlin.random.Random as KRandom
import java.util.Random as JRandom

// Data classes
data class Person(private val name: String, private val age: Int) {

}

fun getPeople(): List<Person> {
    return listOf(Person("Alice", 29), Person("Bob", 31))
}

// Smart casts
fun evalExpr(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> evalExpr(expr.left) + evalExpr(expr.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

// sealed classes
// classes with fixed number of subclasses
fun evalSealedExpr(expr: SealedExpr): Int =
    when (expr) {
        is SealedNum -> expr.value
        is SealedSum -> evalSealedExpr(expr.left) + evalSealedExpr(expr.right)
        // no need for an else, nothing else possible
    }

sealed interface SealedExpr
class SealedNum(val value: Int) : SealedExpr
class SealedSum(val left: SealedExpr, val right: SealedExpr) : SealedExpr

fun comparePeople(): Boolean {
    val p1 = Person("Alice", 29)
    val p2 = Person("Alice", 29)
    return p1 == p2  // should be true
}


// Renamed imports (see at top of file)
fun useDifferentRandomClasses(): String {
    return "Kotlin random: " +
            KRandom.nextInt(2) +
            " Java random:" +
            JRandom().nextInt(2) +
            "."
}

// extension function
/* NOTE: When a function returns a single expression,
the curly braces can be omitted and the body is specified after a = symbol */
fun Int.r(): RationalNumber = RationalNumber(this, 1)

fun Pair<Int, Int>.r(): RationalNumber {
    return RationalNumber(this.first, this.second)
}

data class RationalNumber(val numerator: Int, val denominator: Int)

object ClassesKoan : Koan("Classes") {
    override fun run() {
        super.run() // call original run method

        println(getPeople())
        assertTrue(comparePeople())

        println(evalExpr(Sum(Num(1), Num(2))))
        println(evalSealedExpr(SealedSum(SealedNum(1), SealedNum(2))))

        println(useDifferentRandomClasses())

        val rationalNumber0 = 10.r()
        val rationalNumber1 = Pair(10, 8).r()
        println(rationalNumber0)
        println(rationalNumber1)
    }
}