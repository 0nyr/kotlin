package net.onyr.koans

import org.junit.Assert.assertTrue

// Hello World
fun start(): String = "OK"

// Names arguments
fun joinOptions(options: Collection<String>) =
    options.joinToString(
        prefix = "[", postfix = "]"
    )

// Default arguments
fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.uppercase() else name) + number

fun useFoo() = listOf(
        foo("a"),
        foo("b", number = 1),
        foo("c", toUpperCase = true),
        foo(name = "d", number = 2, toUpperCase = true)
)

// Triple-quoted strings
const val question = "life, the universe, and everything"
const val answer = 42

val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin("#")

// String template (regex)
var month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
fun getPattern(): String = """\d{2}\s${month}\s\d{4}"""

object IntroKoan {
    fun run() {
        println()
        println("########## Introduction ##########")

        println(start())

        // remove leading whitespace from raw strings
        // By default, | is used as margin prefix
        val text = """
        |Tell me and I forget.
        |Teach me and I remember.
        |Involve me and I learn.
        |(Benjamin Franklin)
        """.trimMargin()
        println(text)

        println(tripleQuotedString)

        val regex = Regex(getPattern())
        assertTrue(regex.containsMatchIn("12 JAN 1990"))
    }
}
