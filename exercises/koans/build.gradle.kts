

// $ gradle koans:tasks intro
// always run on task execution
/*task("intro") {
    description = "Default running task"

    println(".")
}*/

apply {
    plugin("kotlin")
    //plugin("application")
}

// gradle run app: https://docs.gradle.org/current/userguide/application_plugin.html
plugins {
    application
}

dependencies {
    implementation("junit:junit:4.13.2")
}

// run: $ gradle -q :koans:run
application {
    // WARN: Kotlin created its own MainKoanKt object
    // using the name of the file with the main in it.
    mainClass.set("net.onyr.koans.MainKoanKt")
}

// make task available (see with $ gradle tasks --all)
//  gradle -q koans:example-task
tasks.register("example-task") {
    description = "Example task"

    println("Example task, registered inside :koans")
}

