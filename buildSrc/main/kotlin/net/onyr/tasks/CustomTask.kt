package net.onyr.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input

class CustomTask : DefaultTask() {
    @Input
    var name: String = "default"

    @TaskAction
    fun action() {
        println("Hello, $name!")
    }
}
