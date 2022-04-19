package net.onyr.koans

// run: $  gradle :koans:run --warning-mode all --build-cache --configuration-cache --parallel
fun main(args: Array<String>) {
    println("Running Koans...")

    IntroKoan.run() // singleton
}
