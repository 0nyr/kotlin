package net.onyr.koans

import org.junit.Assert.assertTrue
import java.lang.IllegalArgumentException

// Hello World
fun start(): String = "OK"

// Names arguments
fun joinOptions(options: Collection<String>): String =
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

// Nullable types
fun sendMessageToClient(
    client: Client?, message: String?, mailer: Mailer
) {
    val email: String? = client?.personalInfo?.email
    if (email == null || message == null ) return
    mailer.sendMessage(email, message)
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}
class MailSender : Mailer {
    override fun sendMessage(email: String, message: String) {
        println("Sender: $email, Message: $message")
    }
}

// Nothing type
fun failWithWrongAge(age: Int?): Nothing {
    throw IllegalArgumentException("Wrong age: $age")
}

fun checkAge(age: Int?) {
    if (age == null || age !in 0..150) failWithWrongAge(age)
    println("Congrats! Next year you'll be ${age + 1}.")
}

// lambda expressions
fun containsEven(collection: Collection<Int>): Boolean =
    collection.any {
        // lambda (last expression considered as return)
            predicate: Int ->
        (predicate in collection) && predicate % 2 == 0
    }

object IntroKoan : Koan("Introduction") {
    override fun run() {
        super.run() // call original run method

        println(start())

        val strings: Collection<String> = listOf(
            "Once", "Even", "Never", "Always", "Eventually"
        )
        println(joinOptions(strings))

        useFoo()

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

        val client = Client(PersonalInfo("client@mail.com"))
        sendMessageToClient(client, "this is a message", MailSender())

        checkAge(10)

        val collection: Collection<Int> = listOf(1, 2, 3, 5, 11)
        println("Does collection contains an even number ?: ${containsEven(collection)}")
    }
}
