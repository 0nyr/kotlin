package net.onyr.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input

// building custom tasks: https://docs.gradle.org/current/userguide/custom_tasks.html

abstract class CustomTask : DefaultTask() {

    init {
        description = "A custom task example inside buildSrc"
    }
    @TaskAction
    fun action() {
        println("Hello from a CustomTask! (defined inside buildSrc)")
    }
}
